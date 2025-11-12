import java.util.*;
import java.util.stream.IntStream;

public class LaboratoryWork2 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Выберите задание (1-6) или 0 для выхода: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера
            
            switch (choice) {
                case 0:
                    System.out.println("Выход из программы...");
                    return;
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    private static void printMenu() {
        System.out.println("Лабораторная работа 2 - Меню заданий:");
        System.out.println("1. Класс 'Круг'");
        System.out.println("2. Класс 'Склад'");
        System.out.println("3. Класс 'Книга'");
        System.out.println("4. Класс 'Дробь'");
        System.out.println("5. Работа с классом Double");
        System.out.println("6. Методы работы со строками");
    }
    
    // ==================== ЗАДАНИЕ 1 - Класс Круг ====================
    static class Circle {
        private double radius;
        private double centerX;
        private double centerY;
        
        // Конструкторы
        public Circle() {
            this.radius = 1.0;
            this.centerX = 0.0;
            this.centerY = 0.0;
        }
        
        public Circle(double radius) {
            this.radius = radius;
            this.centerX = 0.0;
            this.centerY = 0.0;
        }
        
        public Circle(double centerX, double centerY) {
            this.radius = 1.0;
            this.centerX = centerX;
            this.centerY = centerY;
        }
        
        public Circle(double radius, double centerX, double centerY) {
            this.radius = radius;
            this.centerX = centerX;
            this.centerY = centerY;
        }
        
        // Методы
        public void printCharacteristics() {
            System.out.printf("Круг: радиус=%.2f, центр=(%.2f, %.2f)%n", 
                            radius, centerX, centerY);
        }
        
        public void moveCenter(double deltaX, double deltaY) {
            this.centerX += deltaX;
            this.centerY += deltaY;
        }
        
        public void setRadius(double radius) {
            this.radius = radius;
        }
        
        public double getArea() {
            return Math.PI * radius * radius;
        }
        
        public double getCircumference() {
            return 2 * Math.PI * radius;
        }
    }
    
    private static void task1() {
        System.out.println("\n=== Задание 1: Класс 'Круг' ===");
        
        // Создание объектов разными конструкторами
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(2.0, 3.0);
        Circle circle4 = new Circle(7.0, 1.0, 1.0);
        
        System.out.println("Созданные круги:");
        circle1.printCharacteristics();
        circle2.printCharacteristics();
        circle3.printCharacteristics();
        circle4.printCharacteristics();
        
        // Демонстрация методов
        System.out.println("\nДемонстрация методов:");
        circle1.moveCenter(3, -2);
        circle1.setRadius(4.0);
        circle1.printCharacteristics();
        System.out.printf("Площадь: %.2f%n", circle1.getArea());
        System.out.printf("Длина окружности: %.2f%n", circle1.getCircumference());
    }
    
    // ==================== ЗАДАНИЕ 2 - Класс Склад ====================
    static class Warehouse {
        private int quantity;
        private double pricePerUnit;
        
        // Конструкторы
        public Warehouse() {
            this.quantity = 0;
            this.pricePerUnit = 0.0;
        }
        
        public Warehouse(int quantity, double pricePerUnit) {
            this.quantity = quantity;
            this.pricePerUnit = pricePerUnit;
        }
        
        // Методы
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        
        public void setPricePerUnit(double pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
        }
        
        public double getTotalCost() {
            return quantity * pricePerUnit;
        }
        
        public boolean isMoreExpensiveThan(Warehouse other) {
            return this.pricePerUnit > other.pricePerUnit;
        }
        
        public static int getTotalQuantity(Warehouse... warehouses) {
            int total = 0;
            for (Warehouse wh : warehouses) {
                total += wh.quantity;
            }
            return total;
        }
        
        public void printInfo() {
            System.out.printf("Склад: количество=%d, цена за единицу=%.2f, общая стоимость=%.2f%n",
                            quantity, pricePerUnit, getTotalCost());
        }
    }
    
    private static void task2() {
        System.out.println("\n=== Задание 2: Класс 'Склад' ===");
        
        Warehouse wh1 = new Warehouse(100, 50.0);
        Warehouse wh2 = new Warehouse(200, 45.0);
        Warehouse wh3 = new Warehouse(150, 60.0);
        
        System.out.println("Созданные склады:");
        wh1.printInfo();
        wh2.printInfo();
        wh3.printInfo();
        
        // Сравнение стоимости
        System.out.println("\nСравнение цен:");
        System.out.println("wh1 дороже wh2: " + wh1.isMoreExpensiveThan(wh2));
        System.out.println("wh2 дороже wh3: " + wh2.isMoreExpensiveThan(wh3));
        
        // Общее количество товаров
        int total = Warehouse.getTotalQuantity(wh1, wh2, wh3);
        System.out.println("Общее количество товаров: " + total);
        
        // Изменение данных
        wh1.setQuantity(120);
        wh1.setPricePerUnit(55.0);
        System.out.println("\nПосле изменения:");
        wh1.printInfo();
    }
    
    // ==================== ЗАДАНИЕ 3 - Класс Книга ====================
    static class Book {
        private String author;
        private String title;
        private int year;
        private int pages;
        
        // Конструкторы
        public Book() {
            this.author = "Неизвестен";
            this.title = "Без названия";
            this.year = 0;
            this.pages = 0;
        }
        
        public Book(String author, String title, int year, int pages) {
            this.author = author;
            this.title = title;
            this.year = year;
            this.pages = pages;
        }
        
        // Методы изменения полей
        public void setAuthor(String author) {
            this.author = author;
        }
        
        public void setTitle(String title) {
            this.title = title;
        }
        
        public void setYear(int year) {
            this.year = year;
        }
        
        public void setPages(int pages) {
            this.pages = pages;
        }
        
        // Перегруженные методы для ввода с клавиатуры
        public void setAuthor() {
            System.out.print("Введите автора: ");
            this.author = scanner.nextLine();
        }
        
        public void setTitle() {
            System.out.print("Введите название: ");
            this.title = scanner.nextLine();
        }
        
        public void setYear() {
            System.out.print("Введите год издания: ");
            this.year = scanner.nextInt();
            scanner.nextLine();
        }
        
        public void setPages() {
            System.out.print("Введите количество страниц: ");
            this.pages = scanner.nextInt();
            scanner.nextLine();
        }
        
        // Поиск по названию
        public void printInfoByTitle(String searchTitle) {
            if (this.title.equalsIgnoreCase(searchTitle)) {
                printInfo();
            }
        }
        
        public void printInfo() {
            System.out.printf("Книга: '%s' автор %s, %d год, %d стр.%n",
                            title, author, year, pages);
        }
    }
    
    private static void task3() {
        System.out.println("\n=== Задание 3: Класс 'Книга' ===");
        
        Book book1 = new Book("Толстой", "Война и мир", 1869, 1225);
        Book book2 = new Book("Достоевский", "Преступление и наказание", 1866, 672);
        
        System.out.println("Созданные книги:");
        book1.printInfo();
        book2.printInfo();
        
        // Поиск по названию
        System.out.println("\nПоиск книги 'Война и мир':");
        book1.printInfoByTitle("Война и мир");
        
        // Демонстрация ввода с клавиатуры
        System.out.println("\nИзменение данных книги через ввод с клавиатуры:");
        Book book3 = new Book();
        book3.setAuthor();
        book3.setTitle();
        book3.setYear();
        book3.setPages();
        book3.printInfo();
    }
    
    // ==================== ЗАДАНИЕ 4 - Класс Дробь ====================
    static class Fraction {
        private int numerator;
        private int denominator;
        
        // Конструкторы
        public Fraction() {
            this.numerator = 0;
            this.denominator = 1;
        }
        
        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть нулем");
            }
            this.numerator = numerator;
            this.denominator = denominator;
            reduce();
        }
        
        // Методы арифметических операций
        public Fraction add(Fraction other) {
            int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
            int newDen = this.denominator * other.denominator;
            return new Fraction(newNum, newDen);
        }
        
        public static Fraction add(Fraction... fractions) {
            Fraction result = new Fraction(0, 1);
            for (Fraction f : fractions) {
                result = result.add(f);
            }
            return result;
        }
        
        public Fraction subtract(Fraction other) {
            int newNum = this.numerator * other.denominator - other.numerator * this.denominator;
            int newDen = this.denominator * other.denominator;
            return new Fraction(newNum, newDen);
        }
        
        public Fraction multiply(Fraction other) {
            int newNum = this.numerator * other.numerator;
            int newDen = this.denominator * other.denominator;
            return new Fraction(newNum, newDen);
        }
        
        public static Fraction multiply(Fraction... fractions) {
            Fraction result = new Fraction(1, 1);
            for (Fraction f : fractions) {
                result = result.multiply(f);
            }
            return result;
        }
        
        public Fraction divide(Fraction other) {
            int newNum = this.numerator * other.denominator;
            int newDen = this.denominator * other.numerator;
            return new Fraction(newNum, newDen);
        }
        
        // Сокращение дроби
        private void reduce() {
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
            
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }
        
        // Наибольший общий делитель
        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
        
        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
    
    // Метод для изменения массива дробей
    private static void modifyEvenIndexFractions(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i] = fractions[i].add(fractions[i + 1]);
        }
    }
    
    private static void task4() {
        System.out.println("\n=== Задание 4: Класс 'Дробь' ===");
        
        // Создание дробей
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        Fraction f3 = new Fraction(2, 3);
        
        System.out.println("Дроби: " + f1 + ", " + f2 + ", " + f3);
        
        // Арифметические операции
        System.out.println("\nАрифметические операции:");
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        
        // Операции с переменным числом параметров
        System.out.println("\nСумма всех дробей: " + Fraction.add(f1, f2, f3));
        System.out.println("Произведение всех дробей: " + Fraction.multiply(f1, f2, f3));
        
        // Работа с массивом дробей
        System.out.println("\nРабота с массивом дробей:");
        Fraction[] fractions = {
            new Fraction(1, 3),
            new Fraction(1, 4),
            new Fraction(1, 5),
            new Fraction(1, 6),
            new Fraction(2, 7)
        };
        
        System.out.print("Исходный массив: ");
        for (Fraction f : fractions) {
            System.out.print(f + " ");
        }
        
        modifyEvenIndexFractions(fractions);
        
        System.out.print("\nПосле модификации: ");
        for (Fraction f : fractions) {
            System.out.print(f + " ");
        }
        System.out.println();
    }
    
    // ==================== ЗАДАНИЕ 5 - Класс Double ====================
    private static void task5() {
        System.out.println("\n=== Задание 5: Работа с классом Double ===");
        
        // Создание объектов Double с помощью valueOf()
        Double d1 = Double.valueOf(3.14);
        Double d2 = Double.valueOf("2.718");
        Double d3 = Double.valueOf(42.0);
        
        System.out.println("Созданные Double объекты:");
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);
        
        // Преобразование String к double
        String numberStr = "123.456";
        double parsedDouble = Double.parseDouble(numberStr);
        System.out.println("\nПреобразование строки '" + numberStr + "' к double: " + parsedDouble);
        
        // Преобразование Double ко всем примитивным типам
        System.out.println("\nПреобразование Double d1 к примитивным типам:");
        byte b = d1.byteValue();
        short s = d1.shortValue();
        int i = d1.intValue();
        long l = d1.longValue();
        float f = d1.floatValue();
        double d = d1.doubleValue();
        
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        
        // Вывод значения на консоль
        System.out.println("\nВывод Double на консоль: " + d1);
        
        // Преобразование литерала к строке
        String dStr = Double.toString(3.14);
        System.out.println("Double литерал к строке: '" + dStr + "'");
    }
    
    // ==================== ЗАДАНИЕ 6 - Методы работы со строками ====================
    private static void analyzeString(String str) {
        System.out.println("Анализируемая строка: \"" + str + "\"");
        
        // Последний символ строки
        if (!str.isEmpty()) {
            char lastChar = str.charAt(str.length() - 1);
            System.out.println("Последний символ: '" + lastChar + "'");
        }
        
        // Проверка окончания
        boolean endsWith = str.endsWith("!!!");
        System.out.println("Заканчивается на '!!!': " + endsWith);
        
        // Проверка начала
        boolean startsWith = str.startsWith("I like");
        System.out.println("Начинается с 'I like': " + startsWith);
        
        // Проверка содержания подстроки
        boolean contains = str.contains("Java");
        System.out.println("Содержит 'Java': " + contains);
        
        // Позиция подстроки
        int position = str.indexOf("Java");
        System.out.println("Позиция 'Java': " + position);
        
        // Замена символов
        String replaced = str.replace('a', 'o');
        System.out.println("После замены 'a' на 'o': \"" + replaced + "\"");
        
        // Верхний регистр
        String upper = str.toUpperCase();
        System.out.println("В верхнем регистре: \"" + upper + "\"");
        
        // Нижний регистр
        String lower = str.toLowerCase();
        System.out.println("В нижнем регистре: \"" + lower + "\"");
        
        // Вырезание подстроки
        if (position != -1) {
            String substring = str.substring(position, position + 4);
            System.out.println("Вырезанная подстрока: \"" + substring + "\"");
        }
    }
    
    private static void task6() {
        System.out.println("\n=== Задание 6: Методы работы со строками ===");
        
        String testString = "I like Java!!!";
        analyzeString(testString);
        
        // Дополнительный пример
        System.out.println("\n" + "=".repeat(30));
        System.out.println("Дополнительный пример:");
        analyzeString("Hello Java World!!!");
    }
}