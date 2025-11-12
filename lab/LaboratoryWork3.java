import java.util.*;
import java.util.regex.Pattern;

public class LaboratoryWork3 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Выберите задание (1-5) или 0 для выхода: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера
            
            switch (choice) {
                case 0 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                case 1 -> task1();
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    private static void printMenu() {
        System.out.println("Лабораторная работа 3 - Меню заданий:");
        System.out.println("1. Наследование - Student и Magistracy");
        System.out.println("2. Композиция - Car, Lorry, SportCar");
        System.out.println("3. Абстрактные классы - Фрукты");
        System.out.println("4. Интерфейсы - Printable");
        System.out.println("5. Пользовательские исключения");
    }
    
    // ==================== ЗАДАНИЕ 1 - Наследование Student и Magistracy ====================
    static class Student {
        protected String firstName;
        protected String lastName;
        protected String group;
        protected double averageMark;
        
        public Student() {}
        
        public Student(String firstName, String lastName, String group, double averageMark) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
            this.averageMark = averageMark;
        }
        
        public double getScholarship() {
            return averageMark >= 8 ? 100 : 80;
        }
        
        @Override
        public String toString() {
            return String.format("Студент: %s %s, группа: %s, средний балл: %.1f, стипендия: %.0f руб.",
                    firstName, lastName, group, averageMark, getScholarship());
        }
    }
    
    static class Magistracy extends Student {
        private String scientificWork;
        
        public Magistracy(String firstName, String lastName, String group, double averageMark, String scientificWork) {
            super(firstName, lastName, group, averageMark);
            this.scientificWork = scientificWork;
        }
        
        @Override
        public double getScholarship() {
            return averageMark >= 8 ? 200 : 180;
        }
        
        @Override
        public String toString() {
            return String.format("Магистрант: %s %s, группа: %s, научная работа: '%s', средний балл: %.1f, стипендия: %.0f руб.",
                    firstName, lastName, group, scientificWork, averageMark, getScholarship());
        }
    }
    
    private static void task1() {
        System.out.println("\n=== Задание 1: Наследование - Student и Magistracy ===");
        
        // Переменная типа Student, которая ссылается на объект типа Magistracy
        Student studentAsMagistracy = new Magistracy("Анна", "Иванова", "М-101", 8.5, 
                                                    "Исследование алгоритмов машинного обучения");
        
        // Массив типа Student, содержащий объекты класса Student и Magistracy
        Student[] students = {
            new Student("Иван", "Петров", "Б-201", 7.9),
            new Student("Мария", "Сидорова", "Б-202", 8.2),
            new Magistracy("Алексей", "Кузнецов", "М-101", 8.7, "Анализ больших данных"),
            new Magistracy("Елена", "Смирнова", "М-102", 7.8, "Разработка мобильных приложений"),
            studentAsMagistracy
        };
        
        System.out.println("Информация о студентах и магистрантах:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        System.out.println("\nСтипендии каждого учащегося:");
        for (Student student : students) {
            System.out.printf("%s %s: %.0f руб.%n", 
                student.firstName, student.lastName, student.getScholarship());
        }
    }
    
    // ==================== ЗАДАНИЕ 2 - Композиция Car, Lorry, SportCar ====================
    // Вложенные пакеты эмулируются через статические вложенные классы
    
    static class Person {
        protected String fullName;
        
        public Person(String fullName) {
            this.fullName = fullName;
        }
        
        @Override
        public String toString() {
            return fullName;
        }
    }
    
    static class Driver extends Person {
        private int drivingExperience;
        
        public Driver(String fullName, int drivingExperience) {
            super(fullName);
            this.drivingExperience = drivingExperience;
        }
        
        @Override
        public String toString() {
            return String.format("Водитель: %s, стаж: %d лет", fullName, drivingExperience);
        }
    }
    
    static class Engine {
        private int power;
        private String manufacturer;
        
        public Engine(int power, String manufacturer) {
            this.power = power;
            this.manufacturer = manufacturer;
        }
        
        @Override
        public String toString() {
            return String.format("Двигатель: %s, мощность: %d л.с.", manufacturer, power);
        }
    }
    
    static class Car {
        protected String brand;
        protected String carClass;
        protected double weight;
        protected Driver driver;
        protected Engine engine;
        
        public Car(String brand, String carClass, double weight, Driver driver, Engine engine) {
            this.brand = brand;
            this.carClass = carClass;
            this.weight = weight;
            this.driver = driver;
            this.engine = engine;
        }
        
        public void start() {
            System.out.println("Поехали");
        }
        
        public void stop() {
            System.out.println("Останавливаемся");
        }
        
        public void turnRight() {
            System.out.println("Поворот направо");
        }
        
        public void turnLeft() {
            System.out.println("Поворот налево");
        }
        
        @Override
        public String toString() {
            return String.format("Автомобиль: %s, класс: %s, вес: %.1f кг\n%s\n%s", 
                    brand, carClass, weight, driver, engine);
        }
    }
    
    static class Lorry extends Car {
        private double loadCapacity;
        
        public Lorry(String brand, String carClass, double weight, Driver driver, 
                    Engine engine, double loadCapacity) {
            super(brand, carClass, weight, driver, engine);
            this.loadCapacity = loadCapacity;
        }
        
        @Override
        public String toString() {
            return super.toString() + String.format("\nГрузоподъемность: %.1f тонн", loadCapacity);
        }
    }
    
    static class SportCar extends Car {
        private int maxSpeed;
        
        public SportCar(String brand, String carClass, double weight, Driver driver, 
                       Engine engine, int maxSpeed) {
            super(brand, carClass, weight, driver, engine);
            this.maxSpeed = maxSpeed;
        }
        
        @Override
        public String toString() {
            return super.toString() + String.format("\nМаксимальная скорость: %d км/ч", maxSpeed);
        }
    }
    
    private static void task2() {
        System.out.println("\n=== Задание 2: Композиция - Car, Lorry, SportCar ===");
        
        // Создаем водителей
        Driver driver1 = new Driver("Петров Иван Сидорович", 5);
        Driver driver2 = new Driver("Сидорова Мария Ивановна", 3);
        Driver driver3 = new Driver("Козлов Алексей Петрович", 10);
        
        // Создаем двигатели
        Engine engine1 = new Engine(150, "Volkswagen");
        Engine engine2 = new Engine(400, "Cummins");
        Engine engine3 = new Engine(650, "Ferrari");
        
        // Создаем автомобили
        Car car1 = new Car("Volkswagen Golf", "B", 1200, driver1, engine1);
        Lorry lorry = new Lorry("Volvo FH", "Грузовой", 8000, driver2, engine2, 20);
        SportCar sportCar = new SportCar("Ferrari 488", "S", 1470, driver3, engine3, 330);
        
        Car[] cars = {car1, lorry, sportCar};
        
        System.out.println("Информация об автомобилях:");
        for (Car car : cars) {
            System.out.println(car);
            System.out.println("Демонстрация методов:");
            car.start();
            car.turnLeft();
            car.turnRight();
            car.stop();
            System.out.println("-".repeat(30));
        }
    }
    
    // ==================== ЗАДАНИЕ 3 - Абстрактные классы Фрукты ====================
    static abstract class Fruit {
        protected double weight;
        
        public Fruit(double weight) {
            this.weight = weight;
        }
        
        public final void printManufacturerInfo() {
            System.out.print("Made in RB");
        }
        
        public abstract double getCost();
        
        public double getWeight() {
            return weight;
        }
    }
    
    static class Apple extends Fruit {
        private static final double PRICE_PER_KG = 2.5;
        
        public Apple(double weight) {
            super(weight);
        }
        
        @Override
        public double getCost() {
            return weight * PRICE_PER_KG;
        }
        
        @Override
        public String toString() {
            return String.format("Яблоко: вес=%.2f кг, стоимость=%.2f руб.", weight, getCost());
        }
    }
    
    static class Pear extends Fruit {
        private static final double PRICE_PER_KG = 3.0;
        
        public Pear(double weight) {
            super(weight);
        }
        
        @Override
        public double getCost() {
            return weight * PRICE_PER_KG;
        }
        
        @Override
        public String toString() {
            return String.format("Груша: вес=%.2f кг, стоимость=%.2f руб.", weight, getCost());
        }
    }
    
    static class Plum extends Fruit {
        private static final double PRICE_PER_KG = 4.0;
        
        public Plum(double weight) {
            super(weight);
        }
        
        @Override
        public double getCost() {
            return weight * PRICE_PER_KG;
        }
        
        @Override
        public String toString() {
            return String.format("Слива: вес=%.2f кг, стоимость=%.2f руб.", weight, getCost());
        }
    }
    
    private static void task3() {
        System.out.println("\n=== Задание 3: Абстрактные классы - Фрукты ===");
        
        // Создаем фрукты
        Fruit[] fruits = {
            new Apple(1.5),
            new Apple(2.0),
            new Pear(1.2),
            new Plum(0.8),
            new Apple(1.8),
            new Pear(1.5),
            new Plum(1.0)
        };
        
        System.out.println("Проданные фрукты:");
        double totalCost = 0;
        double appleCost = 0;
        double pearCost = 0;
        double plumCost = 0;
        
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
            totalCost += fruit.getCost();
            
            if (fruit instanceof Apple) {
                appleCost += fruit.getCost();
            } else if (fruit instanceof Pear) {
                pearCost += fruit.getCost();
            } else if (fruit instanceof Plum) {
                plumCost += fruit.getCost();
            }
            
            // Демонстрация завершенного метода
            System.out.print("Производитель: ");
            fruit.printManufacturerInfo();
            System.out.println("\n" + "-".repeat(40));
        }
        
        System.out.println("\nИтоговая стоимость:");
        System.out.printf("Общая стоимость всех фруктов: %.2f руб.%n", totalCost);
        System.out.printf("Стоимость яблок: %.2f руб.%n", appleCost);
        System.out.printf("Стоимость груш: %.2f руб.%n", pearCost);
        System.out.printf("Стоимость слив: %.2f руб.%n", plumCost);
    }
    
    // ==================== ЗАДАНИЕ 4 - Интерфейсы Printable ====================
    interface Printable {
        void print();
        String getTitle();
    }
    
    static class Book implements Printable {
        private String title;
        private String author;
        
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
        
        @Override
        public void print() {
            System.out.printf("Книга: '%s', автор: %s%n", title, author);
        }
        
        @Override
        public String getTitle() {
            return title;
        }
    }
    
    static class Magazine implements Printable {
        private String title;
        private int issueNumber;
        
        public Magazine(String title, int issueNumber) {
            this.title = title;
            this.issueNumber = issueNumber;
        }
        
        @Override
        public void print() {
            System.out.printf("Журнал: '%s', номер: %d%n", title, issueNumber);
        }
        
        @Override
        public String getTitle() {
            return title;
        }
        
        public static void printMagazines(Printable[] printable) {
            System.out.println("Список журналов:");
            for (Printable item : printable) {
                if (item instanceof Magazine) {
                    System.out.println("- " + item.getTitle());
                }
            }
        }
    }
    
    static class BookStatic {
        public static void printBooks(Printable[] printable) {
            System.out.println("Список книг:");
            for (Printable item : printable) {
                if (item instanceof Book) {
                    System.out.println("- " + item.getTitle());
                }
            }
        }
    }
    
    private static void task4() {
        System.out.println("\n=== Задание 4: Интерфейсы - Printable ===");
        
        // Создаем массив типа Printable
        Printable[] printableItems = {
            new Book("Война и мир", "Л. Толстой"),
            new Magazine("Наука и техника", 45),
            new Book("Преступление и наказание", "Ф. Достоевский"),
            new Magazine("Компьютерный мир", 123),
            new Book("Мастер и Маргарита", "М. Булгаков"),
            new Magazine("Автомобили", 78)
        };
        
        System.out.println("Все элементы массива:");
        for (Printable item : printableItems) {
            item.print();
        }
        
        System.out.println();
        // Вызов статических методов
        Magazine.printMagazines(printableItems);
        System.out.println();
        BookStatic.printBooks(printableItems);
    }
    
    // ==================== ЗАДАНИЕ 5 - Пользовательские исключения ====================
    static class WrongLoginException extends Exception {
        public WrongLoginException() {
            super();
        }
        
        public WrongLoginException(String message) {
            super(message);
        }
    }
    
    static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
            super();
        }
        
        public WrongPasswordException(String message) {
            super(message);
        }
    }
    
    private static boolean validateCredentials(String login, String password, String confirmPassword) {
        // Паттерн для проверки латинских букв, цифр и подчеркивания
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        
        try {
            // Проверка логина
            if (login.length() >= 20) {
                throw new WrongLoginException("Логин должен быть меньше 20 символов");
            }
            if (!pattern.matcher(login).matches()) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания");
            }
            
            // Проверка пароля
            if (password.length() >= 20) {
                throw new WrongPasswordException("Пароль должен быть меньше 20 символов");
            }
            if (!pattern.matcher(password).matches()) {
                throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
            }
            
            return true;
            
        } catch (WrongLoginException e) {
            System.out.println("Ошибка логина: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка пароля: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
            return false;
        }
    }
    
    private static void task5() {
        System.out.println("\n=== Задание 5: Пользовательские исключения ===");
        
        // Тестовые случаи
        String[][] testCases = {
            // login, password, confirmPassword
            {"user_123", "password_123", "password_123"}, // правильные данные
            {"user@123", "password_123", "password_123"}, // неверный логин (спецсимвол)
            {"very_long_login_name_here", "pass", "pass"}, // длинный логин
            {"user123", "pass word", "pass word"}, // неверный пароль (пробел)
            {"user123", "password", "different"} // несовпадающие пароли
        };
        
        for (int i = 0; i < testCases.length; i++) {
            String[] testCase = testCases[i];
            System.out.printf("\nТест %d:%n", i + 1);
            System.out.printf("Логин: '%s', Пароль: '%s', Подтверждение: '%s'%n",
                    testCase[0], testCase[1], testCase[2]);
            
            boolean isValid = validateCredentials(testCase[0], testCase[1], testCase[2]);
            System.out.println("Результат валидации: " + (isValid ? "УСПЕХ" : "ОШИБКА"));
            System.out.println("-".repeat(50));
        }
        
        // Интерактивный тест
        System.out.println("\nИнтерактивный тест:");
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();
        
        boolean result = validateCredentials(login, password, confirmPassword);
        System.out.println("Результат: " + (result ? "Данные корректны" : "Данные неверны"));
    }
}