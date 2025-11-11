# Контрольная работа - Вариант 5
## Туристическое агентство - Управление базой данных клиентов

### Описание
Проект представляет собой реализацию паттерна DAO (Data Access Object) для управления данными туристического агентства с использованием JDBC и MySQL.

### Технологии
- Java 11
- JDBC (Java Database Connectivity)
- MySQL 8.0
- Maven

### Структура проекта
```
javalab/
├── src/
│   └── main/
│       ├── java/
│       │   └── by/bsuir/travel/
│       │       ├── entity/
│       │       │   └── Travel.java          # Entity класс туриста
│       │       ├── dao/
│       │       │   ├── AbstractDAO.java     # Абстрактный класс DAO
│       │       │   └── TravelDAO.java       # Реализация DAO для Travel
│       │       ├── util/
│       │       │   └── ConnectionDB.java    # Управление подключением к БД
│       │       └── Main.java                # Главный класс с демонстрацией
│       └── resources/
│           ├── database.properties          # Настройки подключения к БД
│           └── init.sql                     # SQL скрипт инициализации БД
├── pom.xml                                  # Maven конфигурация
└── README.md
```

### Реализованные методы TravelDAO

В соответствии с заданием контрольной работы (Вариант 5), реализованы следующие методы:

1. **`Travel findEntityById(int id)`** - поиск туриста по ID
2. **`List<Travel> findAll()`** - получение всех туристов из БД
3. **`boolean delete(int id)`** - удаление туриста по ID
4. **`boolean delete(Travel tourist)`** - удаление туриста по объекту
5. **`boolean create(Travel tourist)`** - добавление нового туриста
6. **`Travel update(Travel tourist)`** - обновление данных туриста

### Подготовка к запуску

#### 1. Установка MySQL
Убедитесь, что MySQL Server установлен и запущен на вашем компьютере.

#### 2. Создание базы данных
Выполните SQL скрипт для создания БД и таблиц:
```bash
mysql -u root -p < src/main/resources/init.sql
```

Или вручную:
1. Откройте MySQL клиент
2. Выполните команды из файла `src/main/resources/init.sql`

#### 3. Настройка подключения
Отредактируйте файл `src/main/resources/database.properties` если необходимо:
```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/travel_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
db.user=root
db.password=root
db.name=travel_db
```

### Сборка и запуск

#### Через Maven:
```bash
# Компиляция проекта
mvn clean compile

# Запуск главного класса
mvn exec:java -Dexec.mainClass="by.bsuir.travel.Main"
```

#### Через IDE (IntelliJ IDEA, Eclipse):
1. Импортируйте проект как Maven проект
2. Дождитесь загрузки зависимостей
3. Запустите класс `Main.java`

### Описание таблицы БД

**Таблица: tourists**
| Поле | Тип | Описание |
|------|-----|----------|
| id | INT | Первичный ключ (AUTO_INCREMENT) |
| first_name | VARCHAR(50) | Имя туриста |
| last_name | VARCHAR(50) | Фамилия туриста |
| email | VARCHAR(100) | Email (уникальный) |
| phone_number | VARCHAR(20) | Номер телефона |
| destination | VARCHAR(100) | Направление/страна |
| duration_days | INT | Длительность тура (дни) |
| price | DECIMAL(10,2) | Стоимость тура |
| created_at | TIMESTAMP | Дата создания записи |

### Примеры использования

```java
TravelDAO travelDAO = new TravelDAO();

// Создание нового туриста
Travel tourist = new Travel();
tourist.setFirstName("Иван");
tourist.setLastName("Петров");
tourist.setEmail("ivan@mail.ru");
tourist.setPhoneNumber("+375291234567");
tourist.setDestination("Париж");
tourist.setDurationDays(7);
tourist.setPrice(1500.00);
travelDAO.create(tourist);

// Получение всех туристов
List<Travel> allTourists = travelDAO.findAll();

// Поиск по ID
Travel found = travelDAO.findEntityById(1);

// Обновление
tourist.setPrice(1600.00);
travelDAO.update(tourist);

// Удаление
travelDAO.delete(tourist.getId());
```

### Автор
Контрольная работа выполнена в рамках курса "Технологии программирования инфокоммуникационных систем" (Часть 2)

### Примечания
- Используется PreparedStatement для защиты от SQL-инъекций
- Реализован паттерн DAO для абстракции работы с БД
- Применяется ResourceBundle для управления конфигурацией
- Все соединения с БД корректно закрываются (try-with-resources)