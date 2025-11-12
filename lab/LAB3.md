# Лабораторная работа 3: Продвинутое ООП

## Описание

Лабораторная работа включает 5 заданий на продвинутые концепции объектно-ориентированного программирования: наследование, полиморфизм, композицию, абстрактные классы, интерфейсы и пользовательские исключения.

## Задания

### Задание 1: Наследование - Student и Magistracy
**Описание:** Реализация наследования с классом Student и его наследником Magistracy.

**Класс Student:**
- Поля: `firstName`, `lastName`, `group`, `averageMark`
- Метод `getScholarship()`: возвращает 100 руб. при среднем балле ≥ 8, иначе 80 руб.

**Класс Magistracy** (extends Student):
- Дополнительное поле: `scientificWork` (название научной работы)
- Переопределенный метод `getScholarship()`: возвращает 200 руб. при среднем балле ≥ 8, иначе 180 руб.

**Демонстрация полиморфизма:**
```java
Student student = new Magistracy("Анна", "Иванова", "М-101", 8.5, "Машинное обучение");
System.out.println(student.getScholarship());  // 200 руб. (вызывается метод Magistracy)
```

**Пример работы:**
```
Студент: Иван Петров, группа: Б-201, средний балл: 7.9, стипендия: 80 руб.
Магистрант: Алексей Кузнецов, группа: М-101, научная работа: 'Анализ больших данных',
средний балл: 8.7, стипендия: 200 руб.
```

### Задание 2: Композиция - Car, Lorry, SportCar
**Описание:** Реализация композиции объектов и наследования.

**Иерархия классов:**
- `Person` - базовый класс с ФИО
- `Driver extends Person` - водитель с стажем вождения
- `Engine` - двигатель с мощностью и производителем
- `Car` - автомобиль с маркой, классом, весом, водителем и двигателем
- `Lorry extends Car` - грузовик с грузоподъемностью
- `SportCar extends Car` - спортивный автомобиль с максимальной скоростью

**Методы Car:**
- `start()` - "Поехали"
- `stop()` - "Останавливаемся"
- `turnRight()` - "Поворот направо"
- `turnLeft()` - "Поворот налево"
- `toString()` - полная информация об автомобиле

**Пример работы:**
```
Автомобиль: Ferrari 488, класс: S, вес: 1470.0 кг
Водитель: Козлов Алексей Петрович, стаж: 10 лет
Двигатель: Ferrari, мощность: 650 л.с.
Максимальная скорость: 330 км/ч

Поехали
Поворот налево
Поворот направо
Останавливаемся
```

### Задание 3: Абстрактные классы - Фрукты
**Описание:** Реализация абстрактного класса Fruit и его наследников.

**Абстрактный класс Fruit:**
- Поле: `weight` (вес в кг)
- Завершенный метод: `printManufacturerInfo()` - выводит "Made in RB"
- Абстрактный метод: `getCost()` - вычисляет стоимость с учетом веса

**Классы-наследники:**
- `Apple extends Fruit` - яблоко (2.5 руб./кг)
- `Pear extends Fruit` - груша (3.0 руб./кг)
- `Plum extends Fruit` - слива (4.0 руб./кг)

**Функциональность:**
- Подсчет общей стоимости всех проданных фруктов
- Подсчет стоимости отдельно по каждому виду фруктов

**Пример работы:**
```
Яблоко: вес=1.50 кг, стоимость=3.75 руб.
Производитель: Made in RB

Груша: вес=1.20 кг, стоимость=3.60 руб.
Производитель: Made in RB

Итоговая стоимость:
Общая стоимость всех фруктов: 25.40 руб.
Стоимость яблок: 13.25 руб.
Стоимость груш: 8.10 руб.
Стоимость слив: 4.05 руб.
```

### Задание 4: Интерфейсы - Printable
**Описание:** Реализация интерфейса Printable и работа с полиморфизмом.

**Интерфейс Printable:**
- Метод `void print()` - выводит информацию об объекте
- Метод `String getTitle()` - возвращает название

**Классы реализации:**
- `Book implements Printable` - книга с названием и автором
- `Magazine implements Printable` - журнал с названием и номером выпуска

**Статические методы фильтрации:**
- `Magazine.printMagazines(Printable[])` - выводит только журналы
- `BookStatic.printBooks(Printable[])` - выводит только книги

**Использование instanceof:**
```java
for (Printable item : printableItems) {
    if (item instanceof Book) {
        // Обработка книги
    } else if (item instanceof Magazine) {
        // Обработка журнала
    }
}
```

**Пример работы:**
```
Все элементы массива:
Книга: 'Война и мир', автор: Л. Толстой
Журнал: 'Наука и техника', номер: 45
Книга: 'Преступление и наказание', автор: Ф. Достоевский

Список журналов:
- Наука и техника
- Компьютерный мир
- Автомобили

Список книг:
- Война и мир
- Преступление и наказание
- Мастер и Маргарита
```

### Задание 5: Пользовательские исключения
**Описание:** Создание и обработка пользовательских исключений для валидации данных.

**Пользовательские исключения:**
- `WrongLoginException` - ошибка валидации логина
- `WrongPasswordException` - ошибка валидации пароля

**Правила валидации:**

**Для login:**
- Длина < 20 символов
- Только латинские буквы, цифры и знак подчеркивания

**Для password:**
- Длина < 20 символов
- Только латинские буквы, цифры и знак подчеркивания
- Должен совпадать с confirmPassword

**Метод валидации:**
```java
boolean validateCredentials(String login, String password, String confirmPassword)
```

**Обработка:**
- Используется несколько блоков `catch`
- Обработка исключений внутри метода
- Возвращает `true` при успешной валидации, `false` при ошибке

**Пример работы:**
```
Тест 1:
Логин: 'user_123', Пароль: 'password_123', Подтверждение: 'password_123'
Результат валидации: УСПЕХ

Тест 2:
Логин: 'user@123', Пароль: 'password_123', Подтверждение: 'password_123'
Ошибка логина: Логин должен содержать только латинские буквы, цифры и знак подчеркивания
Результат валидации: ОШИБКА

Тест 3:
Логин: 'user123', Пароль: 'password', Подтверждение: 'different'
Ошибка пароля: Пароль и подтверждение пароля не совпадают
Результат валидации: ОШИБКА
```

## Запуск программы

### Компиляция
```bash
javac LaboratoryWork3.java
```

### Запуск
```bash
java LaboratoryWork3
```

### Интерактивное меню
После запуска программа выводит меню с выбором заданий:
```
Лабораторная работа 3 - Меню заданий:
1. Наследование - Student и Magistracy
2. Композиция - Car, Lorry, SportCar
3. Абстрактные классы - Фрукты
4. Интерфейсы - Printable
5. Пользовательские исключения

Выберите задание (1-5) или 0 для выхода:
```

## Ключевые концепции ООП

### 1. Наследование
Класс Magistracy наследует от Student все поля и методы, расширяя функциональность.

### 2. Полиморфизм
Переменная типа Student может ссылаться на объект Magistracy, при этом вызываются переопределенные методы наследника.

### 3. Композиция
Класс Car содержит объекты Driver и Engine, демонстрируя отношение "has-a".

### 4. Абстрактные классы
Класс Fruit определяет общий интерфейс для всех фруктов, но не может быть инстанцирован напрямую.

### 5. Интерфейсы
Интерфейс Printable определяет контракт для классов Book и Magazine.

### 6. Обработка исключений
Пользовательские исключения позволяют создавать специфичную логику обработки ошибок.

## Паттерны проектирования

### Template Method
Абстрактный класс Fruit определяет шаблон для всех фруктов.

### Strategy
Интерфейс Printable позволяет использовать разные стратегии вывода для Book и Magazine.

## Особенности реализации

### Использование instanceof
Для проверки типа объекта в runtime и выполнения специфичной логики.

### Регулярные выражения
Pattern и Matcher для валидации строк в задании 5.

### Множественные конструкторы исключений
Каждое исключение имеет конструктор по умолчанию и с сообщением.

## Требования
- Java 11 или выше
- Понимание основ ООП
- Все задания выполняются в одной программе с интерактивным меню

## Структура кода
- Классы логически организованы по заданиям
- Используются вложенные статические классы
- Полная документация JavaDoc
- Следование принципам SOLID

---

## Техническая информация

### Наследование (Inheritance)

#### Основные концепции
**Определение:** Механизм создания нового класса на основе существующего с наследованием его свойств и методов.

**Терминология:**
- **Суперкласс (родитель, базовый класс)** - класс, от которого наследуют
- **Подкласс (потомок, производный класс)** - класс, который наследует
- **extends** - ключевое слово для наследования в Java

#### Задание 1: Student и Magistracy

**Иерархия классов:**
```
        Object (корень всех классов)
          ↓
       Student
          ↓
     Magistracy
```

**Реализация:**
```java
class Student {
    protected String firstName;
    protected String lastName;
    protected String group;
    protected double averageMark;

    public int getScholarship() {
        return averageMark >= 8.0 ? 100 : 80;
    }
}

class Magistracy extends Student {
    private String scientificWork;

    @Override  // Аннотация переопределения
    public int getScholarship() {
        return averageMark >= 8.0 ? 200 : 180;
    }
}
```

#### Уровни доступа и наследование

| Модификатор | В своем классе | В подклассе | В любом классе |
|-------------|----------------|-------------|----------------|
| private     | ✓              | ✗           | ✗              |
| protected   | ✓              | ✓           | ✗              |
| public      | ✓              | ✓           | ✓              |

**Важно:** `protected` позволяет доступ в подклассах, но не в других классах пакета (в отличие от Java где package-private шире).

#### super - доступ к родителю
```java
class Magistracy extends Student {
    public Magistracy(String firstName, String lastName, String group,
                      double averageMark, String scientificWork) {
        // Вызов конструктора родителя
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    public void printInfo() {
        super.printInfo();  // Вызов метода родителя
        System.out.println("Научная работа: " + scientificWork);
    }
}
```

**Правила использования super():**
1. Должен быть ПЕРВЫМ оператором в конструкторе
2. Если не указан явно, компилятор вставляет `super()` автоматически
3. Если у родителя нет конструктора без параметров - ошибка компиляции

### Полиморфизм (Polymorphism)

#### Определение
**Полиморфизм** - способность объекта принимать множество форм. Один интерфейс - разные реализации.

#### Типы полиморфизма

**1. Полиморфизм времени компиляции (Compile-time):**
- Перегрузка методов (Method Overloading)
- Перегрузка операторов (не поддерживается в Java)

**2. Полиморфизм времени выполнения (Runtime):**
- Переопределение методов (Method Overriding)
- Динамическое связывание методов

#### Runtime Polymorphism - пример из задания 1
```java
Student student1 = new Student("Иван", "Петров", "Б-201", 7.9);
Student student2 = new Magistracy("Анна", "Иванова", "М-101", 8.5, "ML");

// Вызов метода определяется типом ОБЪЕКТА, а не переменной
System.out.println(student1.getScholarship());  // 80 (Student)
System.out.println(student2.getScholarship());  // 200 (Magistracy)
```

**Тип переменной:** Student
**Тип объекта:** Magistracy
**Вызывается метод:** Magistracy.getScholarship() ✓

#### Virtual Method Table (vtable)

**Как JVM определяет какой метод вызывать:**
```
Объект Magistracy:
┌─────────────────────┐
│ Object Header       │
├─────────────────────┤
│ vtable pointer  ────┼──→ vtable для Magistracy
├─────────────────────┤       ┌──────────────────────┐
│ firstName           │       │ toString() → Object  │
│ lastName            │       │ equals()   → Object  │
│ group               │       │ hashCode() → Object  │
│ averageMark         │       │ getScholarship() → Magistracy │ ← переопределен
│ scientificWork      │       └──────────────────────┘
└─────────────────────┘
```

**Производительность:**
- Вызов виртуального метода: ~1-2 наносекунды накладных расходов
- JIT-компилятор оптимизирует частые вызовы
- Для критичных участков можно использовать `final` методы (не виртуальные)

#### Method Overriding - правила

```java
class Parent {
    public Number getValue() { return 42; }
}

class Child extends Parent {
    // ✓ Более специфичный возвращаемый тип (covariant return type)
    @Override
    public Integer getValue() { return 100; }

    // ✗ Менее доступный модификатор
    // protected Integer getValue() { ... }  // ОШИБКА!

    // ✗ Другие параметры (это overloading, не overriding)
    // public Integer getValue(int x) { ... }

    // ✗ Более широкие исключения
    // public Integer getValue() throws Exception { ... }  // ОШИБКА!
}
```

**Правила переопределения:**
1. Сигнатура метода должна совпадать (имя + параметры)
2. Возвращаемый тип: тот же или подтип (covariant)
3. Модификатор доступа: тот же или шире
4. Исключения: те же или подтипы (narrower)
5. final/static методы не переопределяются

### Композиция (Composition)

#### Композиция vs Наследование

**Наследование (is-a):** Magistracy **является** Student
```java
class Magistracy extends Student { }
```

**Композиция (has-a):** Car **содержит** Engine
```java
class Car {
    private Engine engine;  // Композиция
    private Driver driver;
}
```

#### Когда использовать композицию?

**✓ Используйте композицию когда:**
- Отношение "has-a" (автомобиль имеет двигатель)
- Нужна гибкость в изменении поведения в runtime
- Множественное "наследование" (у Car есть Engine И Driver)
- Избегание жесткой связанности

**✓ Используйте наследование когда:**
- Отношение "is-a" (магистр является студентом)
- Нужен полиморфизм
- Логическая иерархия типов

#### Задание 2: Иерархия автомобилей

**Комбинация наследования и композиции:**
```
Person ←────┐ (is-a)
            │
         Driver ←── has-a ── Car ──┐
                              ↑    ├─ has-a → Engine
                              │    │
                    ┌─────────┴────┴─────────┐
                    │                        │
                  Lorry                  SportCar
```

**Преимущества композиции здесь:**
1. Driver может быть изменен без изменения Car
2. Engine может быть заменен (разные типы двигателей)
3. Можно создать Car без Driver (например, на заводе)
4. Тестирование проще (можно подменить Engine)

### Абстрактные классы (Abstract Classes)

#### Определение
**Абстрактный класс** - класс, который не может быть инстанцирован и может содержать абстрактные методы.

#### Задание 3: Fruit - абстрактный класс

```java
abstract class Fruit {
    protected double weight;

    // Конкретный (реализованный) метод
    public void printManufacturerInfo() {
        System.out.println("Made in RB");
    }

    // Абстрактный метод (без реализации)
    public abstract double getCost();
}
```

**Правила:**
1. Нельзя создать объект: `new Fruit()` - ошибка!
2. Может содержать как абстрактные, так и конкретные методы
3. Может иметь конструкторы (вызываются из подклассов)
4. Может иметь поля, статические методы
5. Подклассы ДОЛЖНЫ реализовать все абстрактные методы

#### Template Method Pattern

```java
abstract class Fruit {
    public abstract double getCost();  // Шаг 1: определяется в подклассах

    public void printManufacturerInfo() {  // Шаг 2: общий для всех
        System.out.println("Made in RB");
    }

    // Template Method
    public final void displayFullInfo() {
        System.out.println("Стоимость: " + getCost());
        printManufacturerInfo();
        // Алгоритм зафиксирован, но шаги настраиваются
    }
}
```

#### Абстрактный класс vs Интерфейс

| Характеристика | Абстрактный класс | Интерфейс |
|----------------|-------------------|-----------|
| Множественное наследование | ✗ (только один) | ✓ (несколько) |
| Конструкторы | ✓ | ✗ |
| Поля | ✓ (любые) | ✗ (только static final) |
| Методы с телом | ✓ | ✓ (default/static с Java 8) |
| Модификаторы полей | ✓ (любые) | Только public static final |
| Когда использовать | Общая реализация + is-a | Контракт/поведение |

### Интерфейсы (Interfaces)

#### Определение
**Интерфейс** - контракт, определяющий набор методов без реализации (до Java 8).

#### Задание 4: Printable

```java
interface Printable {
    void print();           // Абстрактный по умолчанию
    String getTitle();

    // Java 8+: default метод
    default void printWithBorder() {
        System.out.println("=================");
        print();
        System.out.println("=================");
    }

    // Java 8+: static метод
    static void printHeader() {
        System.out.println("КАТАЛОГ");
    }
}
```

#### Реализация интерфейса

```java
class Book implements Printable {
    private String title;
    private String author;

    @Override
    public void print() {
        System.out.printf("Книга: '%s', автор: %s%n", title, author);
    }

    @Override
    public String getTitle() {
        return title;
    }
}
```

#### Множественная реализация

```java
interface Printable { void print(); }
interface Comparable { int compareTo(Object o); }
interface Serializable { /* маркерный */ }

class Book implements Printable, Comparable, Serializable {
    // Реализация всех методов всех интерфейсов
}
```

#### Functional Interface (Java 8+)

```java
@FunctionalInterface
interface Validator {
    boolean validate(String input);

    // Может содержать default и static методы
    default boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }
}

// Использование с лямбдой
Validator lengthValidator = s -> s.length() >= 5;
```

### instanceof - проверка типа

#### Синтаксис
```java
if (obj instanceof ClassName) {
    ClassName typed = (ClassName) obj;
    // Работа с typed
}
```

#### Задание 4: фильтрация по типу

```java
public static void printMagazines(Printable[] items) {
    for (Printable item : items) {
        if (item instanceof Magazine) {
            System.out.println(item.getTitle());
        }
    }
}
```

#### Pattern Matching (Java 16+)

```java
// Старый стиль
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}

// Новый стиль (Java 16+)
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());  // s уже приведен к типу
}
```

#### Производительность instanceof
- Очень быстрая операция (~1-2 наносекунды)
- Проверяет всю иерархию классов
- JIT-компилятор оптимизирует частые проверки

### Пользовательские исключения

#### Иерархия исключений

```
Throwable
├── Error (системные ошибки, не ловим)
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception
    ├── RuntimeException (unchecked)
    │   ├── NullPointerException
    │   ├── IllegalArgumentException
    │   └── ...
    └── Checked Exceptions
        ├── IOException
        ├── SQLException
        └── WrongLoginException (наше!)
```

#### Задание 5: Создание исключений

```java
// Checked exception - должно быть обработано
class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

// Альтернатива: Unchecked exception
class WrongPasswordException extends RuntimeException {
    // Не требует обязательной обработки
}
```

#### Checked vs Unchecked

| Checked | Unchecked (Runtime) |
|---------|---------------------|
| Extends Exception | Extends RuntimeException |
| Должны быть обработаны | Обработка опциональна |
| Проверяется компилятором | Не проверяется |
| IOException, SQLException | NPE, IllegalArgumentException |
| Для ожидаемых ошибок | Для программных ошибок |

#### Обработка исключений

```java
public boolean validateCredentials(String login, String password, String confirmPassword) {
    try {
        // Валидация логина
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }
        if (login.length() >= 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }

        // Валидация пароля
        if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

        return true;

    } catch (WrongLoginException e) {
        System.out.println("Ошибка логина: " + e.getMessage());
        return false;
    } catch (WrongPasswordException e) {
        System.out.println("Ошибка пароля: " + e.getMessage());
        return false;
    }
}
```

#### Лучшие практики исключений

**1. Не глушите исключения:**
```java
// ✗ Плохо
try {
    riskyOperation();
} catch (Exception e) {
    // Пустой catch - проблема скрыта!
}

// ✓ Хорошо
try {
    riskyOperation();
} catch (Exception e) {
    logger.error("Ошибка операции", e);
    throw new ApplicationException("Не удалось выполнить", e);
}
```

**2. Ловите специфичные исключения:**
```java
// ✗ Плохо - слишком широко
try {
    parseFile();
} catch (Exception e) { }

// ✓ Хорошо - конкретные типы
try {
    parseFile();
} catch (FileNotFoundException e) {
    // Файл не найден
} catch (IOException e) {
    // Ошибка чтения
}
```

**3. Try-with-resources (Java 7+):**
```java
// Автоматическое закрытие ресурсов
try (Scanner scanner = new Scanner(new File("file.txt"))) {
    while (scanner.hasNext()) {
        process(scanner.nextLine());
    }
} catch (IOException e) {
    handleError(e);
}
// scanner.close() вызывается автоматически
```

### Регулярные выражения (Regex)

#### Задание 5: Валидация с Pattern

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Компиляция паттерна (кэшируется для производительности)
private static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9_]+");

public boolean isValidLogin(String login) {
    Matcher matcher = LOGIN_PATTERN.matcher(login);
    return matcher.matches() && login.length() < 20;
}
```

#### Основные метасимволы

| Метасимвол | Значение | Пример |
|------------|----------|--------|
| `.` | Любой символ | `a.c` → "abc", "a1c" |
| `*` | 0 или более | `ab*c` → "ac", "abc", "abbc" |
| `+` | 1 или более | `ab+c` → "abc", "abbc" |
| `?` | 0 или 1 | `ab?c` → "ac", "abc" |
| `[abc]` | Любой из | `[abc]` → "a", "b", "c" |
| `[^abc]` | Не из списка | `[^abc]` → "d", "e", "1" |
| `[a-z]` | Диапазон | `[a-z]` → любая строчная буква |
| `\d` | Цифра | `\d+` → "123", "4" |
| `\w` | Буква/цифра/_ | `\w+` → "hello", "test_1" |
| `\s` | Пробельный символ | `\s+` → " ", "\t", "\n" |
| `^` | Начало строки | `^abc` → строка начинается с "abc" |
| `$` | Конец строки | `abc$` → строка заканчивается на "abc" |

#### Примеры паттернов для валидации

```java
// Email
"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"

// Телефон (Беларусь)
"^\\+375\\d{9}$"  // +375291234567

// Логин (только буквы, цифры, подчеркивание, 3-20 символов)
"^[a-zA-Z0-9_]{3,20}$"

// Пароль (минимум 8 символов, буква + цифра)
"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"
```

#### Производительность Regex

**Компиляция vs использование:**
```java
// ✗ Плохо - компиляция при каждом вызове
for (String s : strings) {
    if (s.matches("[a-z]+")) { }  // Компилирует паттерн каждый раз!
}

// ✓ Хорошо - компиляция один раз
Pattern pattern = Pattern.compile("[a-z]+");
for (String s : strings) {
    if (pattern.matcher(s).matches()) { }
}
```

**Сложность:**
- Простые паттерны: O(n) где n - длина строки
- Паттерны с backtracking: может быть экспоненциальной!
- Избегайте вложенных кванторов: `(a+)+`

### SOLID Principles

#### 1. Single Responsibility Principle (SRP)
**Принцип единственной ответственности:** Класс должен иметь только одну причину для изменения.

```java
// ✗ Плохо - много ответственностей
class Student {
    void calculateScholarship() { }
    void saveToDatabase() { }
    void sendEmail() { }
}

// ✓ Хорошо - разделено
class Student {
    void calculateScholarship() { }
}
class StudentRepository {
    void save(Student s) { }
}
class EmailService {
    void send(Student s) { }
}
```

#### 2. Open/Closed Principle (OCP)
**Принцип открытости/закрытости:** Открыт для расширения, закрыт для модификации.

```java
// Задание 3: Fruit - открыт для расширения
abstract class Fruit {
    public abstract double getCost();
}

// Добавляем новый фрукт БЕЗ изменения Fruit
class Orange extends Fruit {
    public double getCost() { return weight * 3.5; }
}
```

#### 3. Liskov Substitution Principle (LSP)
**Принцип подстановки Барбары Лисков:** Подклассы должны быть заменяемы на базовый класс.

```java
// Задание 1: Student и Magistracy
Student student = new Magistracy(...);
int scholarship = student.getScholarship();  // Работает корректно!
```

**Нарушение LSP:**
```java
class Bird {
    void fly() { /* летит */ }
}

class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Пингвины не летают!");
    }
}

// Проблема:
Bird bird = new Penguin();
bird.fly();  // Неожиданное исключение!
```

#### 4. Interface Segregation Principle (ISP)
**Принцип разделения интерфейсов:** Много специализированных интерфейсов лучше одного универсального.

```java
// ✗ Плохо - "толстый" интерфейс
interface Worker {
    void work();
    void eat();
    void sleep();
}

// ✓ Хорошо - разделенные интерфейсы
interface Workable {
    void work();
}
interface Eatable {
    void eat();
}
interface Sleepable {
    void sleep();
}
```

#### 5. Dependency Inversion Principle (DIP)
**Принцип инверсии зависимостей:** Зависьте от абстракций, а не от конкретных реализаций.

```java
// ✗ Плохо - зависимость от конкретного класса
class Car {
    private PetrolEngine engine;  // Жестко привязан к бензиновому
}

// ✓ Хорошо - зависимость от интерфейса
interface Engine {
    void start();
}

class Car {
    private Engine engine;  // Может быть любой тип
}

class PetrolEngine implements Engine { }
class ElectricEngine implements Engine { }
```

### Паттерны проектирования (Design Patterns)

#### 1. Template Method (Задание 3)

**Назначение:** Определить скелет алгоритма, делегируя некоторые шаги подклассам.

```java
abstract class Fruit {
    // Template Method
    public final void displayInfo() {
        printWeight();          // Шаг 1: общий
        printCost();            // Шаг 2: специфичный
        printManufacturer();    // Шаг 3: общий
    }

    private void printWeight() {
        System.out.println("Вес: " + weight);
    }

    protected abstract void printCost();  // Реализуется в подклассах

    private void printManufacturer() {
        System.out.println("Made in RB");
    }
}
```

#### 2. Strategy (Задание 4)

**Назначение:** Определить семейство алгоритмов и сделать их взаимозаменяемыми.

```java
interface Printable {
    void print();  // Стратегия печати
}

class Book implements Printable {
    public void print() { /* стратегия для книги */ }
}

class Magazine implements Printable {
    public void print() { /* стратегия для журнала */ }
}

// Контекст
class Printer {
    public void printItem(Printable item) {
        item.print();  // Делегируем стратегии
    }
}
```

#### 3. Factory Method

```java
abstract class FruitFactory {
    // Factory Method
    protected abstract Fruit createFruit(double weight);

    // Использование Factory Method
    public Fruit orderFruit(double weight) {
        Fruit fruit = createFruit(weight);
        fruit.printManufacturerInfo();
        return fruit;
    }
}

class AppleFactory extends FruitFactory {
    protected Fruit createFruit(double weight) {
        return new Apple(weight);
    }
}
```

### Память и производительность

#### Размер объектов

**Student:**
```
Object header:     16 bytes
String firstName:   8 bytes (ссылка) + ~40 bytes (объект String)
String lastName:    8 bytes (ссылка) + ~40 bytes
String group:       8 bytes (ссылка) + ~24 bytes
double averageMark: 8 bytes
Padding:            0 bytes
Итого:             ~152 bytes (приблизительно)
```

**Magistracy (extends Student):**
```
Student fields:    ~152 bytes (унаследовано)
String scientificWork: 8 bytes (ссылка) + ~40 bytes
Итого:            ~200 bytes
```

#### Влияние наследования на производительность

**Вызов метода:**
1. **Прямой вызов:** ~0.1 наносекунд
2. **Виртуальный вызов (полиморфизм):** ~1-2 наносекунды
3. **Вызов через интерфейс:** ~2-3 наносекунды

**JIT-оптимизации:**
- Inlining простых методов
- Devirtualization (превращение виртуальных вызовов в прямые)
- Speculative optimization (оптимистическая оптимизация)

#### instanceof - производительность

```java
// Тест производительности
for (int i = 0; i < 1_000_000; i++) {
    if (obj instanceof String) { }  // ~1-2 наносекунды
}
```

**Оптимизации:**
1. Проверяйте наиболее вероятные типы первыми
2. Избегайте глубоких иерархий (instanceof проверяет всю цепочку)
3. Используйте полиморфизм вместо instanceof где возможно

### Лучшие практики

#### 1. Предпочитайте композицию наследованию
```java
// Вместо
class ColoredCircle extends Circle { }
class BorderedCircle extends Circle { }
class ColoredBorderedCircle extends ColoredCircle { }  // Проблема!

// Используйте
class Circle {
    private Color color;
    private Border border;
}
```

#### 2. Программируйте на уровне интерфейсов
```java
// ✗ Привязка к реализации
ArrayList<String> list = new ArrayList<>();

// ✓ Привязка к интерфейсу
List<String> list = new ArrayList<>();
```

#### 3. Используйте аннотацию @Override
```java
@Override
public int getScholarship() {
    // Компилятор проверит, что метод действительно переопределен
}
```

#### 4. Делайте классы final или abstract
```java
// Либо final (не наследуется)
public final class UtilityClass { }

// Либо abstract (только для наследования)
public abstract class BaseClass { }

// Избегайте наследования от обычных классов
```

#### 5. Валидация в конструкторах
```java
public Student(String firstName, String lastName, String group, double averageMark) {
    if (firstName == null || firstName.isEmpty()) {
        throw new IllegalArgumentException("Имя не может быть пустым");
    }
    if (averageMark < 0 || averageMark > 10) {
        throw new IllegalArgumentException("Средний балл должен быть от 0 до 10");
    }
    // ... инициализация
}
```

## Автор
Student

## Версия
2.0
