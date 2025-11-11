# CI/CD Pipeline

Проект использует GitHub Actions для автоматического тестирования.

## Настройка

Workflow описан в `.github/workflows/test-project.yml`

### Триггеры

```yaml
on:
  push:
    branches: [ "**" ]
  pull_request:
    branches: [ "**" ]
  workflow_dispatch:
```

Запускается при пуше в любую ветку, при PR и вручную.

### Окружение

```yaml
runs-on: ubuntu-latest
```

Чистая Ubuntu VM для каждого запуска.

## Этапы

### 1. Клонирование репозитория

```yaml
- uses: actions/checkout@v4
```

Стандартный action для клонирования кода.

### 2. Установка Java JDK 11

```yaml
- uses: actions/setup-java@v4
  with:
    java-version: '11'
    distribution: 'temurin'
    cache: maven
```

Устанавливается Temurin OpenJDK 11 с кэшированием Maven зависимостей.

### 3. Установка MySQL

```yaml
- run: |
    sudo systemctl start mysql.service
    mysql -e "SELECT VERSION();" -uroot -proot
```

MySQL уже есть в образе, просто запускается.

### 4. Создание БД

```yaml
- run: |
    mysql -uroot -proot < src/main/resources/init.sql
    mysql -uroot -proot -e "USE travel_db; SELECT COUNT(*) FROM tourists;"
```

Выполняется SQL скрипт инициализации и проверка.

### 5. Настройка подключения

```yaml
- run: sed -i 's/db.password=root/db.password=root/g' src/main/resources/database.properties
```

Обновление конфига для CI окружения.

### 6. Компиляция

```yaml
- run: mvn clean compile
```

Стандартная сборка Maven.

### 7. Запуск приложения

```yaml
- run: |
    mvn exec:java -Dexec.mainClass="by.bsuir.travel.Main" 2>&1 | tee full_output.txt
    cat full_output.txt | grep -v "^\[INFO\]" | grep -v "^\[WARNING\]" > clean_output.txt
```

Запуск с полным выводом. Создается два файла:
- `full_output.txt` - весь вывод с Maven логами
- `clean_output.txt` - чистый вывод программы

### 8. Создание отчета

```yaml
- run: |
    cat > CONTROL_WORK_REPORT.txt << 'EOF'
    [структура отчета]
    EOF
```

Генерируется текстовый отчет с описанием задания и результатами.

### 9. Загрузка артефактов

```yaml
- uses: actions/upload-artifact@v4
  with:
    name: Control-Work-Report-Variant-5-${{ github.run_number }}
    path: |
      CONTROL_WORK_REPORT.txt
      clean_output.txt
    retention-days: 90
```

Отчеты сохраняются как артефакты на 90 дней.

### 10. Статистика

```yaml
- run: |
    mysql -uroot -proot -e "USE travel_db;
    SELECT 'Всего туристов:', COUNT(*) FROM tourists
    UNION ALL
    SELECT 'Средняя цена тура:', ROUND(AVG(price), 2) FROM tourists"
```

Вывод статистики по БД.

## Интерактивный режим

Есть второй workflow `interactive-test.yml` с параметрами:

```yaml
workflow_dispatch:
  inputs:
    search_id: ...
    delete_id: ...
    create_first_name: ...
```

Позволяет указать параметры для тестирования методов.

## Время выполнения

Полный цикл занимает примерно 1-2 минуты:
- Клонирование: ~5 сек
- Java setup: ~10-15 сек
- MySQL: ~5-10 сек
- Создание БД: ~3-5 сек
- Компиляция: ~20-40 сек
- Запуск: ~5-10 сек
- Отчеты: ~5 сек

## Просмотр результатов

1. Вкладка Actions на GitHub
2. Выбрать нужный запуск
3. Посмотреть логи или скачать артефакты

## Расширения

Можно добавить:
- JUnit тесты: `mvn test`
- Checkstyle: `mvn checkstyle:check`
- JaCoCo: `mvn jacoco:report`
- Создание JAR: `mvn package`
