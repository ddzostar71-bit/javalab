# Инструкция по установке и настройке проекта

## Что нужно скачать и установить для запуска проекта

### 1. Java Development Kit (JDK) 11 или выше

#### Windows:
1. Перейдите на сайт: https://www.oracle.com/java/technologies/downloads/
2. Выберите **Java 11** или **Java 17** (LTS версии)
3. Скачайте установщик для Windows (например, `jdk-11_windows-x64_bin.exe`)
4. Запустите установщик и следуйте инструкциям
5. После установки добавьте переменную окружения:
   - Откройте "Панель управления" → "Система" → "Дополнительные параметры системы"
   - Нажмите "Переменные среды"
   - Создайте новую системную переменную `JAVA_HOME` со значением пути к JDK (например: `C:\Program Files\Java\jdk-11`)
   - Добавьте в переменную `Path` значение: `%JAVA_HOME%\bin`

#### Linux:
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install openjdk-11-jdk

# Fedora/CentOS
sudo dnf install java-11-openjdk-devel
```

#### macOS:
```bash
# Через Homebrew
brew install openjdk@11
```

#### Проверка установки:
```bash
java -version
javac -version
```
Должны увидеть версию Java 11 или выше.

---

### 2. Apache Maven

#### Windows:
1. Перейдите на сайт: https://maven.apache.org/download.cgi
2. Скачайте **Binary zip archive** (например, `apache-maven-3.9.5-bin.zip`)
3. Распакуйте архив в папку (например: `C:\Program Files\Apache\maven`)
4. Добавьте переменные окружения:
   - Создайте `MAVEN_HOME` = `C:\Program Files\Apache\maven`
   - Добавьте в `Path` значение: `%MAVEN_HOME%\bin`

#### Linux:
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install maven

# Fedora/CentOS
sudo dnf install maven
```

#### macOS:
```bash
brew install maven
```

#### Проверка установки:
```bash
mvn -version
```

---

### 3. MySQL Server 8.0

#### Windows:
1. Перейдите на сайт: https://dev.mysql.com/downloads/mysql/
2. Скачайте **MySQL Installer for Windows**
3. Запустите установщик
4. Выберите тип установки: **Developer Default**
5. Во время установки:
   - Задайте пароль для пользователя `root` (например: `root`)
   - Запомните этот пароль - он понадобится в настройках!
   - Убедитесь, что сервер запускается как служба Windows
6. После установки проверьте, что служба MySQL запущена

#### Linux:
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo systemctl enable mysql

# Установка пароля root
sudo mysql_secure_installation

# Fedora/CentOS
sudo dnf install mysql-server
sudo systemctl start mysqld
sudo systemctl enable mysqld
```

#### macOS:
```bash
brew install mysql
brew services start mysql
```

#### Проверка установки:
```bash
mysql --version
```

Вход в MySQL:
```bash
mysql -u root -p
```
Введите пароль, который установили при установке.

---

### 4. MySQL Workbench (опционально, но рекомендуется)

Графический интерфейс для работы с MySQL.

1. Перейдите на сайт: https://dev.mysql.com/downloads/workbench/
2. Скачайте версию для вашей ОС
3. Установите программу
4. Запустите и подключитесь к локальному серверу (localhost:3306)

---

## Настройка проекта

### Шаг 1: Клонирование/Загрузка проекта

Если проект на GitHub:
```bash
git clone <URL_репозитория>
cd javalab
```

### Шаг 2: Создание базы данных

#### Вариант А - через командную строку:
```bash
mysql -u root -p < src/main/resources/init.sql
```
Введите пароль root пользователя MySQL.

#### Вариант Б - через MySQL Workbench:
1. Откройте MySQL Workbench
2. Подключитесь к серверу
3. Откройте файл `src/main/resources/init.sql`
4. Нажмите кнопку "Execute" (молния)

#### Вариант В - вручную через консоль:
```bash
# Войдите в MySQL
mysql -u root -p

# В консоли MySQL выполните:
source /полный/путь/к/src/main/resources/init.sql;

# Или скопируйте содержимое файла и вставьте в консоль
```

### Шаг 3: Настройка подключения к БД

Откройте файл `src/main/resources/database.properties` и при необходимости измените:

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/travel_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
db.user=root
db.password=root    # ИЗМЕНИТЕ на свой пароль MySQL!
db.name=travel_db
```

**ВАЖНО:** Замените `db.password=root` на тот пароль, который вы установили для пользователя root в MySQL!

### Шаг 4: Загрузка зависимостей Maven

```bash
cd javalab
mvn clean install
```

Эта команда:
- Скачает все необходимые библиотеки (MySQL Connector)
- Скомпилирует проект
- Создаст JAR файл

---

## Запуск проекта

### Вариант 1 - через Maven:
```bash
mvn exec:java -Dexec.mainClass="by.bsuir.travel.Main"
```

### Вариант 2 - через IDE (IntelliJ IDEA):
1. Откройте IntelliJ IDEA
2. Выберите "Open" и откройте папку `javalab`
3. Дождитесь, пока Maven загрузит все зависимости
4. Откройте файл `src/main/java/by/bsuir/travel/Main.java`
5. Нажмите правой кнопкой мыши → "Run 'Main.main()'"

### Вариант 3 - через Eclipse:
1. Откройте Eclipse
2. File → Import → Existing Maven Projects
3. Выберите папку `javalab`
4. Откройте `Main.java`
5. Нажмите правой кнопкой → Run As → Java Application

---

## Проверка работоспособности

Если все настроено правильно, вы увидите в консоли:

```
================================================================================
КОНТРОЛЬНАЯ РАБОТА - ВАРИАНТ 5
Туристическое агентство - Управление клиентами
================================================================================

1. ТЕСТ МЕТОДА findAll() - Получение всех туристов:
--------------------------------------------------------------------------------
Travel{id=1, firstName='Иван', lastName='Петров', ...}
Travel{id=2, firstName='Мария', lastName='Сидорова', ...}
...
```

---

## Возможные проблемы и решения

### Ошибка: "Communications link failure"
**Причина:** MySQL сервер не запущен или неверные настройки подключения.

**Решение:**
- Проверьте, что MySQL сервер запущен
- Проверьте правильность пароля в `database.properties`
- Убедитесь, что порт 3306 не занят другим приложением

### Ошибка: "Access denied for user 'root'@'localhost'"
**Причина:** Неверный пароль в настройках.

**Решение:**
- Откройте `src/main/resources/database.properties`
- Исправьте значение `db.password` на правильный пароль

### Ошибка: "Unknown database 'travel_db'"
**Причина:** База данных не создана.

**Решение:**
- Выполните SQL скрипт из файла `src/main/resources/init.sql`

### Ошибка: "ClassNotFoundException: com.mysql.cj.jdbc.Driver"
**Причина:** Не загружена зависимость MySQL Connector.

**Решение:**
```bash
mvn clean install
```

### Ошибка: "JAVA_HOME is not set"
**Причина:** Не настроена переменная окружения JAVA_HOME.

**Решение:**
- Установите переменную окружения JAVA_HOME (см. раздел установки JDK)
- Перезапустите терминал/IDE

---

## Минимальные требования к системе

- **ОС:** Windows 7+, macOS 10.12+, Linux (любой современный дистрибутив)
- **RAM:** минимум 2 GB (рекомендуется 4 GB)
- **Место на диске:** 1 GB свободного места
- **Процессор:** любой современный процессор

---

## Контрольный список перед запуском

- [ ] Установлена Java JDK 11 или выше
- [ ] Установлен Apache Maven
- [ ] Установлен MySQL Server 8.0
- [ ] MySQL сервер запущен
- [ ] Выполнен SQL скрипт `init.sql`
- [ ] Настроен файл `database.properties` с правильным паролем
- [ ] Выполнена команда `mvn clean install`
- [ ] Проект скомпилирован без ошибок

---

## Дополнительные материалы

### Полезные команды MySQL:

```sql
-- Просмотр всех баз данных
SHOW DATABASES;

-- Выбор базы данных
USE travel_db;

-- Просмотр таблиц
SHOW TABLES;

-- Просмотр данных в таблице
SELECT * FROM tourists;

-- Удаление базы данных (если нужно пересоздать)
DROP DATABASE travel_db;
```

### Полезные команды Maven:

```bash
# Очистка проекта
mvn clean

# Компиляция
mvn compile

# Тестирование
mvn test

# Создание JAR файла
mvn package
```

---

## Контакты и поддержка

Если возникли проблемы:
1. Проверьте раздел "Возможные проблемы и решения"
2. Убедитесь, что все компоненты установлены правильно
3. Проверьте логи ошибок в консоли

Успехов в выполнении контрольной работы!
