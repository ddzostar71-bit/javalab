# Лабораторная работа 2: Объектно-ориентированное программирование

## Описание

Лабораторная работа включает 6 заданий на основы ООП в Java, охватывающие создание классов, конструкторы, методы, перегрузку методов, работу с классами-обертками и строками.

## Задания

### Задание 1: Класс "Круг"
**Описание:** Разработка класса Circle с тремя полями (радиус, координаты центра X и Y).

**Реализованные конструкторы:**
- Без параметров (радиус = 1.0, центр = (0, 0))
- С одним параметром (радиус)
- С двумя параметрами (координаты центра)
- С тремя параметрами (радиус и координаты центра)

**Методы:**
- `printCharacteristics()` - выводит все характеристики круга
- `moveCenter(deltaX, deltaY)` - изменяет координаты центра
- `setRadius(radius)` - изменяет радиус
- `getArea()` - вычисляет площадь круга (πr²)
- `getCircumference()` - вычисляет длину окружности (2πr)

**Пример работы:**
```java
Circle circle = new Circle(5.0, 2.0, 3.0);
circle.printCharacteristics();  // Круг: радиус=5.00, центр=(2.00, 3.00)
circle.moveCenter(1, -1);
System.out.println("Площадь: " + circle.getArea());  // Площадь: 78.54
```

### Задание 2: Класс "Склад"
**Описание:** Разработка класса Warehouse с двумя полями (количество единиц товара, стоимость одной единицы).

**Реализованные конструкторы:**
- Без параметров
- С двумя параметрами (количество, цена)

**Методы:**
- `setQuantity(quantity)` - изменяет количество товара
- `setPricePerUnit(price)` - изменяет стоимость единицы
- `getTotalCost()` - рассчитывает общую стоимость товара
- `isMoreExpensiveThan(Warehouse other)` - сравнивает стоимость товаров
- `getTotalQuantity(Warehouse... warehouses)` - статический метод с переменным числом параметров для подсчета общего количества

**Пример работы:**
```java
Warehouse wh1 = new Warehouse(100, 50.0);
Warehouse wh2 = new Warehouse(200, 45.0);
System.out.println("Общая стоимость wh1: " + wh1.getTotalCost());  // 5000.00
System.out.println("wh1 дороже wh2: " + wh1.isMoreExpensiveThan(wh2));  // true
int total = Warehouse.getTotalQuantity(wh1, wh2);  // 300
```

### Задание 3: Класс "Книга"
**Описание:** Разработка класса Book с четырьмя полями (автор, название, год выпуска, количество страниц).

**Реализованные конструкторы:**
- Без параметров
- С четырьмя параметрами

**Методы:**
- `setAuthor(author)`, `setTitle(title)`, `setYear(year)`, `setPages(pages)` - методы изменения полей
- Перегруженные методы `setAuthor()`, `setTitle()`, `setYear()`, `setPages()` - для ввода с клавиатуры
- `printInfoByTitle(searchTitle)` - поиск и вывод информации о книге по названию

**Пример работы:**
```java
Book book = new Book("Толстой", "Война и мир", 1869, 1225);
book.printInfo();  // Книга: 'Война и мир' автор Толстой, 1869 год, 1225 стр.
book.setAuthor();  // Ввод нового автора с клавиатуры
```

### Задание 4: Класс "Дробь"
**Описание:** Разработка класса Fraction для работы с математическими дробями (m/n).

**Реализованные методы:**
- `add(Fraction other)` - сложение дробей
- `subtract(Fraction other)` - вычитание дробей
- `multiply(Fraction other)` - умножение дробей
- `divide(Fraction other)` - деление дробей
- `reduce()` - автоматическое сокращение дроби
- `add(Fraction... fractions)` - статический метод сложения с переменным числом параметров
- `multiply(Fraction... fractions)` - статический метод умножения с переменным числом параметров

**Дополнительная функциональность:**
- Метод `modifyEvenIndexFractions(Fraction[] fractions)` - изменяет элементы массива с четным индексом путем добавления следующего элемента

**Пример работы:**
```java
Fraction f1 = new Fraction(1, 2);  // 1/2
Fraction f2 = new Fraction(3, 4);  // 3/4
Fraction sum = f1.add(f2);  // 5/4
Fraction product = f1.multiply(f2);  // 3/8
System.out.println("Сумма всех: " + Fraction.add(f1, f2, f3));
```

### Задание 5: Работа с классом Double
**Описание:** Демонстрация методов класса Double.

**Выполняемые операции:**
- Создание объектов Double с помощью `valueOf()`
- Преобразование String к double с помощью `parseDouble()`
- Преобразование Double ко всем примитивным типам (`byteValue()`, `shortValue()`, `intValue()`, `longValue()`, `floatValue()`, `doubleValue()`)
- Вывод значения Double на консоль
- Преобразование литерала double к строке с помощью `toString()`

**Пример работы:**
```java
Double d1 = Double.valueOf(3.14);
double parsed = Double.parseDouble("123.456");
int intValue = d1.intValue();  // 3
String str = Double.toString(3.14);  // "3.14"
```

### Задание 6: Методы работы со строками
**Описание:** Демонстрация методов класса String.

**Используемые методы:**
- `charAt(index)` - получить символ по индексу
- `endsWith(suffix)` - проверить окончание строки
- `startsWith(prefix)` - проверить начало строки
- `contains(substring)` - проверить наличие подстроки
- `indexOf(substring)` - найти позицию подстроки
- `replace(oldChar, newChar)` - заменить символы
- `toUpperCase()` - преобразовать в верхний регистр
- `toLowerCase()` - преобразовать в нижний регистр
- `substring(start, end)` - извлечь подстроку

**Пример работы:**
```java
String str = "I like Java!!!";
System.out.println("Последний символ: " + str.charAt(str.length() - 1));  // '!'
System.out.println("Заканчивается на '!!!': " + str.endsWith("!!!"));  // true
System.out.println("Содержит 'Java': " + str.contains("Java"));  // true
System.out.println("Позиция 'Java': " + str.indexOf("Java"));  // 7
```

## Запуск программы

### Компиляция
```bash
javac LaboratoryWork2.java
```

### Запуск
```bash
java LaboratoryWork2
```

### Интерактивное меню
После запуска программа выводит меню с выбором заданий:
```
Лабораторная работа 2 - Меню заданий:
1. Класс 'Круг'
2. Класс 'Склад'
3. Класс 'Книга'
4. Класс 'Дробь'
5. Работа с классом Double
6. Методы работы со строками

Выберите задание (1-6) или 0 для выхода:
```

## Особенности реализации

### Инкапсуляция
Все поля классов объявлены как `private` с доступом через геттеры и сеттеры.

### Конструкторы
Каждый класс имеет несколько конструкторов для различных сценариев использования.

### Перегрузка методов
Класс Book демонстрирует перегрузку методов - одно и то же имя метода с разными параметрами.

### Статические методы с varargs
Классы Warehouse и Fraction содержат статические методы с переменным числом параметров.

### Автоматическое сокращение дробей
Класс Fraction автоматически сокращает дроби используя алгоритм НОД (наибольший общий делитель).

## Требования
- Java 11 или выше
- Все задания выполняются в одной программе с интерактивным меню
- Классы реализованы как статические вложенные классы

## Структура кода
- Каждый класс документирован с помощью JavaDoc комментариев
- Используются принципы ООП: инкапсуляция, перегрузка методов
- Методы логически сгруппированы и хорошо структурированы

---

## Техническая информация

### Принципы ООП

#### 1. Инкапсуляция (Encapsulation)
**Определение:** Объединение данных и методов работы с ними в единый объект с сокрытием внутренней реализации.

**Реализация в коде:**
```java
static class Circle {
    private double radius;      // Скрыто от внешнего доступа
    private double centerX;
    private double centerY;

    // Доступ только через публичные методы
    public void setRadius(double radius) {
        if (radius > 0) {  // Валидация
            this.radius = radius;
        }
    }

    public double getRadius() {
        return radius;
    }
}
```

**Преимущества:**
- Контроль над изменением данных (валидация)
- Возможность изменить внутреннюю реализацию без изменения внешнего API
- Защита от некорректных значений
- Упрощение отладки

**Уровни доступа в Java:**
| Модификатор | Класс | Пакет | Подкласс | Мир |
|-------------|-------|-------|----------|-----|
| private     | ✓     | ✗     | ✗        | ✗   |
| default     | ✓     | ✓     | ✗        | ✗   |
| protected   | ✓     | ✓     | ✓        | ✗   |
| public      | ✓     | ✓     | ✓        | ✓   |

#### 2. Абстракция (Abstraction)
**Определение:** Выделение существенных характеристик объекта, игнорирование несущественных деталей.

**Пример:**
```java
// Абстракция "Склад" - нужны только количество и цена
static class Warehouse {
    private int quantity;
    private double pricePerUnit;
    // НЕ нужны: адрес, название, сотрудники и т.д.

    public double getTotalCost() {
        return quantity * pricePerUnit;
    }
}
```

### Конструкторы

#### Назначение и особенности
- Инициализация объекта при создании
- Имеет то же имя, что и класс
- Не имеет возвращаемого типа (даже void)
- Может быть перегружен (несколько версий с разными параметрами)

#### Конструктор по умолчанию
```java
public Circle() {
    this.radius = 1.0;
    this.centerX = 0.0;
    this.centerY = 0.0;
}
```

**Важно:** Если НЕ определен ни один конструктор, Java автоматически создает конструктор без параметров. Если определен хотя бы один, конструктор по умолчанию НЕ создается.

#### Цепочка конструкторов (Constructor Chaining)
```java
public Circle() {
    this(1.0);  // Вызов другого конструктора
}

public Circle(double radius) {
    this(radius, 0.0, 0.0);
}

public Circle(double radius, double centerX, double centerY) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
}
```

**Преимущества:**
- Избегание дублирования кода
- Единая точка инициализации
- Проще поддерживать и изменять

#### Конструктор копирования
```java
public Circle(Circle other) {
    this.radius = other.radius;
    this.centerX = other.centerX;
    this.centerY = other.centerY;
}

// Использование:
Circle c1 = new Circle(5.0);
Circle c2 = new Circle(c1);  // Копия
```

### Перегрузка методов (Method Overloading)

**Определение:** Несколько методов с одинаковым именем, но разными параметрами в одном классе.

**Задание 3 - класс Book:**
```java
// Метод с параметром
public void setAuthor(String author) {
    this.author = author;
}

// Перегруженный метод без параметра (ввод с клавиатуры)
public void setAuthor() {
    System.out.print("Введите автора: ");
    this.author = scanner.nextLine();
}
```

**Правила перегрузки:**
1. Должно отличаться количество параметров ИЛИ их типы
2. Возвращаемый тип НЕ учитывается
3. Модификаторы доступа могут быть разными

**Примеры:**
```java
// ✓ Разное количество параметров
void print()
void print(String s)
void print(String s1, String s2)

// ✓ Разные типы параметров
void setValue(int x)
void setValue(double x)
void setValue(String x)

// ✗ Только возвращаемый тип отличается
int getValue()
String getValue()  // ОШИБКА компиляции!

// ✓ Порядок параметров отличается
void set(int x, String s)
void set(String s, int x)
```

### Статические методы и переменные

#### Статические переменные (class variables)
```java
static class Warehouse {
    private static int totalWarehouses = 0;  // Общая для всех объектов
    private int quantity;  // Уникальная для каждого объекта

    public Warehouse() {
        totalWarehouses++;  // Инкрементируем при создании
    }
}
```

**Хранение в памяти:**
- Статические переменные хранятся в Method Area (с Java 8 - в Metaspace)
- Существуют в единственном экземпляре
- Создаются при загрузке класса, уничтожаются при выгрузке

#### Статические методы
```java
public static int getTotalQuantity(Warehouse... warehouses) {
    int total = 0;
    for (Warehouse w : warehouses) {
        total += w.quantity;
    }
    return total;
}

// Вызов:
int total = Warehouse.getTotalQuantity(wh1, wh2, wh3);
```

**Особенности:**
- Вызываются через имя класса (не нужен объект)
- НЕ имеют доступа к `this` и нестатическим членам
- Часто используются для utility-методов

**Когда использовать:**
- ✓ Utility-методы (Math.abs(), Collections.sort())
- ✓ Factory-методы (Integer.valueOf())
- ✓ Методы не зависящие от состояния объекта
- ✗ Методы требующие доступа к полям объекта

### Varargs (Variable Arguments)

**Синтаксис:**
```java
public static int sum(int... numbers) {  // int[] numbers внутри
    int sum = 0;
    for (int num : numbers) {
        sum += num;
    }
    return sum;
}
```

**Использование:**
```java
sum();              // Пустой массив
sum(1);             // [1]
sum(1, 2, 3);       // [1, 2, 3]
sum(new int[]{1, 2, 3});  // Тоже работает
```

**Правила:**
1. Только ОДИН varargs параметр в методе
2. Должен быть ПОСЛЕДНИМ параметром
3. Компилируется в обычный массив

**Примеры из кода:**
```java
// Warehouse - подсчет общего количества
public static int getTotalQuantity(Warehouse... warehouses)

// Fraction - сложение нескольких дробей
public static Fraction add(Fraction... fractions)

// Fraction - умножение нескольких дробей
public static Fraction multiply(Fraction... fractions)
```

### Работа с дробями (Задание 4)

#### Алгоритм НОД (Наибольший общий делитель)
**Алгоритм Евклида:**
```java
private int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
```

**Сложность:** O(log(min(a, b)))

**Пример:**
```
gcd(48, 18):
48 % 18 = 12  → gcd(18, 12)
18 % 12 = 6   → gcd(12, 6)
12 % 6 = 0    → gcd(6, 0)
Результат: 6
```

#### Операции с дробями

**Сложение:** a/b + c/d = (ad + bc) / bd
```java
public Fraction add(Fraction other) {
    int newNumerator = this.numerator * other.denominator +
                       other.numerator * this.denominator;
    int newDenominator = this.denominator * other.denominator;
    return new Fraction(newNumerator, newDenominator);
}
```

**Умножение:** a/b × c/d = (ac) / (bd)
```java
public Fraction multiply(Fraction other) {
    return new Fraction(
        this.numerator * other.numerator,
        this.denominator * other.denominator
    );
}
```

**Деление:** a/b ÷ c/d = a/b × d/c = (ad) / (bc)
```java
public Fraction divide(Fraction other) {
    return new Fraction(
        this.numerator * other.denominator,
        this.denominator * other.numerator
    );
}
```

**Сокращение дроби:**
```java
public void reduce() {
    int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
    numerator /= gcd;
    denominator /= gcd;
}
```

### Классы-обертки (Wrapper Classes)

#### Зачем нужны?
1. Работа с коллекциями (ArrayList<Integer>, не ArrayList<int>)
2. Методы для преобразования типов
3. Константы (Integer.MAX_VALUE, Double.NaN)
4. Возможность использовать null

#### Примитивы и их обертки
| Примитив | Обертка | Размер | Диапазон |
|----------|---------|--------|----------|
| byte     | Byte    | 8 бит  | -128 до 127 |
| short    | Short   | 16 бит | -32,768 до 32,767 |
| int      | Integer | 32 бит | -2³¹ до 2³¹-1 |
| long     | Long    | 64 бит | -2⁶³ до 2⁶³-1 |
| float    | Float   | 32 бит | IEEE 754 |
| double   | Double  | 64 бит | IEEE 754 |
| char     | Character | 16 бит | 0 до 65,535 |
| boolean  | Boolean | 1 бит | true/false |

#### Методы Double (Задание 5)

**Создание объектов:**
```java
// Способ 1: конструктор (deprecated с Java 9)
Double d1 = new Double(3.14);

// Способ 2: valueOf (рекомендуется)
Double d2 = Double.valueOf(3.14);
Double d3 = Double.valueOf("3.14");
```

**Преобразование из String:**
```java
double value = Double.parseDouble("123.456");  // примитив
Double obj = Double.valueOf("123.456");        // объект
```

**Преобразование к примитивам:**
```java
Double d = Double.valueOf(123.456);
byte b = d.byteValue();     // 123 (обрезается)
short s = d.shortValue();   // 123
int i = d.intValue();       // 123
long l = d.longValue();     // 123L
float f = d.floatValue();   // 123.456f
double dbl = d.doubleValue(); // 123.456
```

**Autoboxing и Unboxing:**
```java
// Autoboxing: примитив → объект
Integer i = 42;  // компилятор: Integer.valueOf(42)

// Unboxing: объект → примитив
int j = i;       // компилятор: i.intValue()

// В выражениях
Integer a = 10;
Integer b = 20;
Integer c = a + b;  // unboxing → сложение → boxing
```

**Кэш Integer:**
```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b);  // true (из кэша)

Integer c = 128;
Integer d = 128;
System.out.println(c == d);  // false (разные объекты)

// Правильное сравнение:
System.out.println(c.equals(d));  // true
```

### Работа со строками (Задание 6)

#### Immutability (Неизменяемость)
**String - immutable класс:**
```java
String s1 = "Hello";
String s2 = s1.toUpperCase();  // Создается НОВЫЙ объект
System.out.println(s1);  // "Hello" (не изменилась!)
System.out.println(s2);  // "HELLO"
```

**Почему String неизменяемый:**
1. Безопасность (для имен классов, путей файлов и т.д.)
2. Кэширование хэш-кода
3. Thread-safety
4. String Pool

#### String Pool
```java
String s1 = "Hello";          // В String Pool
String s2 = "Hello";          // Ссылка на тот же объект
String s3 = new String("Hello");  // В heap (вне pool)

System.out.println(s1 == s2);  // true (один объект)
System.out.println(s1 == s3);  // false (разные объекты)
System.out.println(s1.equals(s3));  // true (одинаковое содержимое)
```

**intern():**
```java
String s3 = new String("Hello").intern();  // Помещает в pool
System.out.println(s1 == s3);  // true
```

#### Основные методы String

**Получение символов:**
```java
char ch = str.charAt(7);           // Символ по индексу
int code = str.codePointAt(7);     // Unicode code point
char[] chars = str.toCharArray();  // Массив символов
```

**Поиск:**
```java
int pos = str.indexOf("Java");      // Первое вхождение
int lastPos = str.lastIndexOf("a"); // Последнее вхождение
boolean has = str.contains("Java"); // Содержит ли подстроку
```

**Проверки:**
```java
boolean starts = str.startsWith("I like");  // Начинается с
boolean ends = str.endsWith("!!!");         // Заканчивается на
boolean empty = str.isEmpty();              // Пустая ли
boolean blank = str.isBlank();              // Пустая/пробелы (Java 11+)
```

**Модификация (создание новых строк):**
```java
String upper = str.toUpperCase();           // ВЕРХНИЙ РЕГИСТР
String lower = str.toLowerCase();           // нижний регистр
String replaced = str.replace('a', 'o');    // Замена символа
String replaced2 = str.replaceAll("a", "o"); // Замена (regex)
String sub = str.substring(7, 11);          // Подстрока [start, end)
String trimmed = str.trim();                // Удалить пробелы
```

**Сравнение:**
```java
str.equals("Java")           // Сравнение содержимого
str.equalsIgnoreCase("java") // Без учета регистра
str.compareTo("Java")        // Лексикографическое сравнение
```

#### StringBuilder и StringBuffer

**Когда использовать:**
- String - когда не требуется изменение (константы, параметры)
- StringBuilder - изменяемые строки в однопоточной среде
- StringBuffer - изменяемые строки в многопоточной среде

**Сравнение производительности:**
```java
// Медленно: O(n²) - создается n строк
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;  // Каждый раз новый объект!
}

// Быстро: O(n) - один объект
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String result = sb.toString();
```

**Методы StringBuilder:**
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");        // "Hello World"
sb.insert(5, ",");          // "Hello, World"
sb.delete(5, 6);            // "Hello World"
sb.reverse();               // "dlroW olleH"
sb.replace(0, 5, "Hi");     // "Hi olleH"
String result = sb.toString();
```

### Геометрические вычисления (Задание 1)

#### Формулы круга
**Площадь круга:** S = πr²
```java
public double getArea() {
    return Math.PI * radius * radius;
}
```

**Длина окружности:** C = 2πr
```java
public double getCircumference() {
    return 2 * Math.PI * radius;
}
```

**Math.PI:**
- Значение: 3.141592653589793
- Тип: double
- Точность: ~15-17 значащих цифр

#### Работа с вещественными числами
```java
// Форматирование вывода
System.out.printf("Площадь: %.2f\n", area);  // 2 знака после запятой

// DecimalFormat для более сложного форматирования
DecimalFormat df = new DecimalFormat("#.##");
String formatted = df.format(3.14159);  // "3.14"
```

### Лучшие практики ООП

#### 1. Следуйте соглашениям об именовании
```java
// Классы: UpperCamelCase
class Circle, class Warehouse

// Методы и переменные: lowerCamelCase
double centerX, getTotalCost()

// Константы: UPPER_SNAKE_CASE
private static final double DEFAULT_RADIUS = 1.0;
```

#### 2. Принцип единственной ответственности (SRP)
```java
// ✓ Хорошо: класс отвечает только за круг
class Circle {
    private double radius;
    public double getArea() { ... }
    public void printCharacteristics() { ... }
}

// ✗ Плохо: слишком много обязанностей
class Circle {
    private double radius;
    public void saveToDatabase() { ... }  // Работа с БД
    public void sendEmail() { ... }       // Отправка email
}
```

#### 3. Валидация в сеттерах
```java
public void setRadius(double radius) {
    if (radius <= 0) {
        throw new IllegalArgumentException("Радиус должен быть положительным");
    }
    this.radius = radius;
}
```

#### 4. Неизменяемые объекты (Immutable)
```java
// Все поля final, нет сеттеров
public final class ImmutableCircle {
    private final double radius;

    public ImmutableCircle(double radius) {
        this.radius = radius;
    }

    // Только геттеры, сеттеров нет
    public double getRadius() {
        return radius;
    }

    // "Модификация" создает новый объект
    public ImmutableCircle withRadius(double newRadius) {
        return new ImmutableCircle(newRadius);
    }
}
```

**Преимущества:**
- Thread-safe
- Можно безопасно передавать и хранить
- Проще для понимания и отладки

#### 5. Переопределение toString()
```java
@Override
public String toString() {
    return String.format("Circle[radius=%.2f, center=(%.2f, %.2f)]",
                         radius, centerX, centerY);
}
```

#### 6. Переопределение equals() и hashCode()
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Circle other = (Circle) obj;
    return Double.compare(radius, other.radius) == 0 &&
           Double.compare(centerX, other.centerX) == 0 &&
           Double.compare(centerY, other.centerY) == 0;
}

@Override
public int hashCode() {
    return Objects.hash(radius, centerX, centerY);
}
```

### Память и производительность

#### Размер объектов в памяти
**Примерный размер Circle:**
```
Object header:    12 bytes (указатель класса + флаги)
double radius:     8 bytes
double centerX:    8 bytes
double centerY:    8 bytes
Padding:           4 bytes (выравнивание до 8)
Итого:            40 bytes
```

**Сравнение с примитивами:**
```java
// 3 примитивных double: 24 bytes
double radius, centerX, centerY;

// Объект Circle: ~40 bytes (+ overhead)
Circle circle = new Circle();
```

#### Оптимизация
1. **Избегайте создания временных объектов:**
```java
// Плохо: создается временный Fraction
Fraction result = f1.add(f2).multiply(f3).divide(f4);

// Лучше: переиспользуем объект (если mutable)
result = f1.add(f2);
result = result.multiply(f3);
result = result.divide(f4);
```

2. **Object pooling для часто создаваемых объектов**
3. **Ленивая инициализация тяжелых полей**

## Автор
Student

## Версия
2.0
