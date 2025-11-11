# Контрольная работа - Вариант 5
## Туристическое агентство - БД клиентов

[![Тестирование](https://github.com/ddzostar71-bit/javalab/actions/workflows/test-project.yml/badge.svg)](https://github.com/ddzostar71-bit/javalab/actions/workflows/test-project.yml)

**Для демонстрации:**
- [Как показать работу](DEMO_INSTRUCTION.md)
- [Про CI/CD](PIPELINE.md)

## О проекте

Приложение для управления клиентской базой туристического агентства. Используется паттерн DAO для работы с БД.

### Стек
- Java 11
- JDBC
- MySQL 8.0
- Maven
- GitHub Actions

### Структура
```
javalab/
├── src/main/java/by/bsuir/travel/
│   ├── entity/Travel.java
│   ├── dao/AbstractDAO.java
│   ├── dao/TravelDAO.java
│   ├── util/ConnectionDB.java
│   └── Main.java
├── src/main/resources/
│   ├── database.properties
│   └── init.sql
└── pom.xml
```

### Реализованные методы (Вариант 5)

1. `Travel findEntityById(int id)` - поиск по ID
2. `List<Travel> findAll()` - список всех записей
3. `boolean delete(int id)` - удаление по ID
4. `boolean delete(Travel tourist)` - удаление по объекту
5. `boolean create(Travel tourist)` - создание записи
6. `Travel update(Travel tourist)` - обновление записи

## Архитектура

### DAO паттерн

Используется классическая схема с абстрактным базовым классом и конкретной реализацией для каждой сущности.

**Travel.java** - сущность туриста:
```java
public class Travel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String destination;
    private Integer durationDays;
    private Double price;
}
```

**AbstractDAO.java** - базовый класс с набором методов для CRUD операций.

**TravelDAO.java** - реализация для работы с туристами:
- PreparedStatement для защиты от инъекций
- try-with-resources для автоматического закрытия соединений
- Отдельный метод маппинга ResultSet в объект
- Получение сгенерированных ID при INSERT

**ConnectionDB.java** - управление подключением через ResourceBundle для чтения настроек из properties.

### Безопасность

- Все запросы через PreparedStatement
- Проверка на null
- Автоматическое управление ресурсами
- Конфигурация вынесена в отдельный файл

## Установка

### Требования
- Java 11+
- Maven 3.6+
- MySQL 8.0

### Запуск

Создать БД:
```bash
mysql -u root -p < src/main/resources/init.sql
```

Настроить подключение в `src/main/resources/database.properties`:
```properties
db.password=ваш_пароль
```

Запустить:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="by.bsuir.travel.Main"
```

### Таблица БД

**tourists**
| Поле | Тип | Описание |
|------|-----|----------|
| id | INT | PK, AUTO_INCREMENT |
| first_name | VARCHAR(50) | Имя |
| last_name | VARCHAR(50) | Фамилия |
| email | VARCHAR(100) | Email (UNIQUE) |
| phone_number | VARCHAR(20) | Телефон |
| destination | VARCHAR(100) | Направление |
| duration_days | INT | Дней |
| price | DECIMAL(10,2) | Цена |
| created_at | TIMESTAMP | Дата создания |

### Пример использования

```java
TravelDAO dao = new TravelDAO();

// Создание
Travel tourist = new Travel();
tourist.setFirstName("Иван");
tourist.setLastName("Петров");
tourist.setEmail("ivan@mail.ru");
tourist.setPhoneNumber("+375291234567");
tourist.setDestination("Париж");
tourist.setDurationDays(7);
tourist.setPrice(1500.00);
dao.create(tourist);

// Получение всех
List<Travel> all = dao.findAll();

// Поиск
Travel found = dao.findEntityById(1);

// Обновление
tourist.setPrice(1600.00);
dao.update(tourist);

// Удаление
dao.delete(tourist.getId());
```

## CI/CD

Проект использует GitHub Actions для автоматического тестирования. При каждом коммите:
- Создается чистое окружение
- Инициализируется БД
- Компилируется и запускается код
- Генерируются отчеты

Подробнее в [PIPELINE.md](PIPELINE.md)

---

**Курс:** Технологии программирования инфокоммуникационных систем (Часть 2), БГУИР
