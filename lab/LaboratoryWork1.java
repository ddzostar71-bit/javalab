import java.util.*;

public class LaboratoryWork1 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Выберите задание (1-13) или 0 для выхода: ");
            int choice = scanner.nextInt();
            
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
                case 6 -> task6();
                case 7 -> task7();
                case 8 -> task8();
                case 9 -> task9();
                case 10 -> task10();
                case 11 -> task11();
                case 12 -> task12();
                case 13 -> task13();
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    private static void printMenu() {
        System.out.println("Лабораторная работа 1 - Меню заданий:");
        System.out.println("1. Степени числа");
        System.out.println("2. Проверка пароля");
        System.out.println("3. Сумма n-значных чисел");
        System.out.println("4. Угадай число");
        System.out.println("5. Последовательность чисел");
        System.out.println("6. Последовательность Фибоначчи");
        System.out.println("7. Счастливые билеты");
        System.out.println("8. Проверка попадания в интервал");
        System.out.println("9. Конвертер секунд");
        System.out.println("10. Максимальный элемент массива");
        System.out.println("11. Массивы с четными элементами");
        System.out.println("12. Примеры из таблицы умножения");
        System.out.println("13. Матрица с заменой элементов");
    }
    
    // Задание 1
    private static void task1() {
        System.out.println("\n=== Задание 1: Степени числа ===");
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= 4; i++) {
            System.out.println(n + "^" + i + " = " + (int)Math.pow(n, i));
        }
    }
    
    // Задание 2
    private static void task2() {
        System.out.println("\n=== Задание 2: Проверка пароля ===");
        final int CORRECT_PASSWORD = 1234;
        int enteredPassword;
        
        do {
            System.out.print("Введите пароль (4-значное число): ");
            enteredPassword = scanner.nextInt();
        } while (enteredPassword != CORRECT_PASSWORD);
        
        System.out.println("Пароль верный! Доступ разрешен.");
    }
    
    // Задание 3
    private static void task3() {
        System.out.println("\n=== Задание 3: Сумма n-значных чисел ===");
        System.out.print("Введите n (1-4): ");
        int n = scanner.nextInt();
        
        if (n < 1 || n > 4) {
            System.out.println("n должно быть от 1 до 4");
            return;
        }
        
        int start = (int)Math.pow(10, n - 1);
        int end = (int)Math.pow(10, n) - 1;
        int sum = 0;
        
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        
        System.out.println("Сумма " + n + "-значных чисел: " + sum);
    }
    
    // Задание 4
    private static void task4() {
        System.out.println("\n=== Задание 4: Угадай число ===");
        int secretNumber = random.nextInt(10) + 1;
        int userGuess;
        
        System.out.println("Я загадал число от 1 до 10. Попробуйте угадать!");
        
        do {
            System.out.print("Ваш вариант: ");
            userGuess = scanner.nextInt();
            
            if (userGuess < secretNumber) {
                System.out.println("Загаданное число больше");
            } else if (userGuess > secretNumber) {
                System.out.println("Загаданное число меньше");
            }
        } while (userGuess != secretNumber);
        
        System.out.println("Поздравляю! Вы угадали число " + secretNumber);
    }
    
    // Задание 5
    private static void task5() {
        System.out.println("\n=== Задание 5: Последовательность чисел ===");
        int count = 0;
        int number = 1000;
        
        System.out.println("Первые четырехзначные числа последовательности:");
        while (number < 10000) {
            System.out.print(number + " ");
            number += 3;
            count++;
            
            if (count % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    // Задание 6
    private static void task6() {
        System.out.println("\n=== Задание 6: Последовательность Фибоначчи ===");
        int a = 1, b = 1;
        
        System.out.print("Первые 11 членов Фибоначчи: ");
        System.out.print(a + " " + b + " ");
        
        for (int i = 3; i <= 11; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }
    
    // Задание 7
    private static void task7() {
        System.out.println("\n=== Задание 7: Счастливые билеты ===");
        System.out.println("Подсчет счастливых билетов...");
        
        int count = 0;
        for (int i = 0; i <= 999999; i++) {
            String ticket = String.format("%06d", i);
            
            int sum1 = Character.getNumericValue(ticket.charAt(0)) + 
                      Character.getNumericValue(ticket.charAt(1)) + 
                      Character.getNumericValue(ticket.charAt(2));
            int sum2 = Character.getNumericValue(ticket.charAt(3)) + 
                      Character.getNumericValue(ticket.charAt(4)) + 
                      Character.getNumericValue(ticket.charAt(5));
            
            if (sum1 == sum2) {
                count++;
            }
        }
        
        System.out.println("Количество счастливых билетов в одном рулоне: " + count);
    }
    
    // Задание 8
    private static void task8() {
        System.out.println("\n=== Задание 8: Проверка попадания в интервал ===");
        int number = random.nextInt(151) + 5; // [5;155]
        
        System.out.println("Случайное число: " + number);
        
        if (number > 25 && number < 100) {
            System.out.println("Число " + number + " попадает в интервал (25;100)");
        } else {
            System.out.println("Число " + number + " НЕ попадает в интервал (25;100)");
        }
    }
    
    // Задание 9
    private static void task9() {
        System.out.println("\n=== Задание 9: Конвертер секунд ===");
        int n = random.nextInt(28801); // [0;28800]
        
        System.out.println("Секунд осталось: " + n);
        
        int hours = n / 3600;
        
        if (hours == 0) {
            System.out.println("осталось менее часа");
        } else if (hours == 1) {
            System.out.println("остался 1 час");
        } else if (hours >= 2 && hours <= 4) {
            System.out.println("осталось " + hours + " часа");
        } else {
            System.out.println("осталось " + hours + " часов");
        }
    }
    
    // Задание 10
    private static void task10() {
        System.out.println("\n=== Задание 10: Максимальный элемент массива ===");
        int[] array = new int[12];
        
        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(31) - 15; // [-15;15]
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        int max = array[0];
        int lastIndex = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
                lastIndex = i;
            }
        }
        
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Индекс последнего вхождения: " + lastIndex);
    }
    
    // Задание 11
    private static void task11() {
        System.out.println("\n=== Задание 11: Массивы с четными элементами ===");
        int n;
        do {
            System.out.print("Введите натуральное число больше 3: ");
            n = scanner.nextInt();
        } while (n <= 3);
        
        // Первый массив
        int[] array1 = new int[n];
        System.out.print("Первый массив: ");
        for (int i = 0; i < n; i++) {
            array1[i] = random.nextInt(n + 1);
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        
        // Подсчет четных элементов
        int evenCount = 0;
        for (int num : array1) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }
        
        // Второй массив
        if (evenCount > 0) {
            int[] array2 = new int[evenCount];
            int index = 0;
            for (int num : array1) {
                if (num % 2 == 0) {
                    array2[index++] = num;
                }
            }
            
            System.out.print("Второй массив (четные): ");
            for (int num : array2) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("В первом массиве нет четных элементов");
        }
    }
    
    // Задание 12
    private static void task12() {
        System.out.println("\n=== Задание 12: Примеры из таблицы умножения ===");
        HashSet<String> examples = new HashSet<>();
        
        System.out.println("15 случайных примеров из таблицы умножения:");
        int count = 1;
        
        while (examples.size() < 15) {
            int a = random.nextInt(8) + 2; // [2;9]
            int b = random.nextInt(8) + 2; // [2;9]
            
            // Создаем уникальный ключ для пары
            String key = Math.min(a, b) + "*" + Math.max(a, b);
            
            if (!examples.contains(key)) {
                examples.add(key);
                System.out.printf("%2d. %d * %d = ?\n", count++, a, b);
            }
        }
    }
    
    // Задание 13
    private static void task13() {
        System.out.println("\n=== Задание 13: Матрица с заменой элементов ===");
        int N = 4, M = 5;
        int[][] matrix = new int[N][M];
        
        // Заполнение матрицы
        System.out.println("Исходная матрица:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        
        // Обработка каждой строки
        for (int i = 0; i < N; i++) {
            int minIndex = 0, maxIndex = 0;
            int minVal = matrix[i][0], maxVal = matrix[i][0];
            
            // Находим min и max в строке
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minIndex = j;
                }
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                    maxIndex = j;
                }
            }
            
            // Меняем min с последним элементом
            int temp = matrix[i][M - 1];
            matrix[i][M - 1] = matrix[i][minIndex];
            matrix[i][minIndex] = temp;
            
            // Меняем max с первым элементом
            temp = matrix[i][0];
            matrix[i][0] = matrix[i][maxIndex];
            matrix[i][maxIndex] = temp;
        }
        
        // Вывод результата
        System.out.println("\nМатрица после преобразования:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}