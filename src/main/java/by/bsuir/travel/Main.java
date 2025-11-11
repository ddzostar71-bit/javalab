package by.bsuir.travel;

import by.bsuir.travel.dao.TravelDAO;
import by.bsuir.travel.entity.Travel;

import java.util.List;

/**
 * Главный класс для демонстрации работы TravelDAO
 * Контрольная работа - Вариант 5
 */
public class Main {

    public static void main(String[] args) {
        TravelDAO travelDAO = new TravelDAO();

        System.out.println("=".repeat(80));
        System.out.println("КОНТРОЛЬНАЯ РАБОТА - ВАРИАНТ 5");
        System.out.println("Туристическое агентство - Управление клиентами");
        System.out.println("=".repeat(80));
        System.out.println();

        // 1. Тест метода findAll() - получение всех туристов
        System.out.println("1. ТЕСТ МЕТОДА findAll() - Получение всех туристов:");
        System.out.println("-".repeat(80));
        List<Travel> allTourists = travelDAO.findAll();
        if (allTourists.isEmpty()) {
            System.out.println("База данных пуста.");
        } else {
            allTourists.forEach(System.out::println);
        }
        System.out.println("Всего туристов: " + allTourists.size());
        System.out.println();

        // 2. Тест метода findEntityById() - поиск по ID
        System.out.println("2. ТЕСТ МЕТОДА findEntityById(int id) - Поиск туриста по ID:");
        System.out.println("-".repeat(80));
        Integer searchId = 1;
        Travel foundTourist = travelDAO.findEntityById(searchId);
        if (foundTourist != null) {
            System.out.println("Найден турист с ID = " + searchId + ":");
            System.out.println(foundTourist);
        } else {
            System.out.println("Турист с ID = " + searchId + " не найден.");
        }
        System.out.println();

        // 3. Тест метода create() - создание нового туриста
        System.out.println("3. ТЕСТ МЕТОДА create(Travel tourist) - Создание нового туриста:");
        System.out.println("-".repeat(80));
        Travel newTourist = new Travel();
        newTourist.setFirstName("Анна");
        newTourist.setLastName("Васильева");
        newTourist.setEmail("anna.vasilyeva@mail.ru");
        newTourist.setPhoneNumber("+375291234572");
        newTourist.setDestination("Венеция");
        newTourist.setDurationDays(8);
        newTourist.setPrice(1900.00);

        boolean created = travelDAO.create(newTourist);
        if (created) {
            System.out.println("Турист успешно создан:");
            System.out.println(newTourist);
        } else {
            System.out.println("Ошибка при создании туриста.");
        }
        System.out.println();

        // 4. Тест метода update() - обновление данных туриста
        System.out.println("4. ТЕСТ МЕТОДА update(Travel tourist) - Обновление данных туриста:");
        System.out.println("-".repeat(80));
        if (created && newTourist.getId() != null) {
            System.out.println("Данные ДО обновления:");
            System.out.println(newTourist);

            newTourist.setDestination("Милан");
            newTourist.setDurationDays(10);
            newTourist.setPrice(2100.00);

            Travel updatedTourist = travelDAO.update(newTourist);
            if (updatedTourist != null) {
                System.out.println("\nДанные ПОСЛЕ обновления:");
                System.out.println(updatedTourist);
            } else {
                System.out.println("Ошибка при обновлении туриста.");
            }
        }
        System.out.println();

        // 5. Тест метода delete(Travel tourist) - удаление туриста по объекту
        System.out.println("5. ТЕСТ МЕТОДА delete(Travel tourist) - Удаление по объекту:");
        System.out.println("-".repeat(80));
        if (created && newTourist.getId() != null) {
            System.out.println("Удаляем туриста: " + newTourist.getFirstName() + " " +
                             newTourist.getLastName() + " (ID: " + newTourist.getId() + ")");
            boolean deleted = travelDAO.delete(newTourist);
            if (deleted) {
                System.out.println("Турист успешно удален.");
            } else {
                System.out.println("Ошибка при удалении туриста.");
            }
        }
        System.out.println();

        // 6. Тест метода delete(int id) - удаление туриста по ID
        System.out.println("6. ТЕСТ МЕТОДА delete(int id) - Удаление по ID:");
        System.out.println("-".repeat(80));
        Integer deleteId = 3;
        // Проверим существование туриста перед удалением
        Travel touristToDelete = travelDAO.findEntityById(deleteId);
        if (touristToDelete != null) {
            System.out.println("Найден турист для удаления (ID = " + deleteId + "):");
            System.out.println(touristToDelete);
            boolean deletedById = travelDAO.delete(deleteId);
            if (deletedById) {
                System.out.println("Турист с ID " + deleteId + " успешно удален.");
            } else {
                System.out.println("Ошибка при удалении туриста по ID.");
            }
        } else {
            System.out.println("Турист с ID = " + deleteId + " не найден в базе данных.");
        }
        System.out.println();

        // 7. Финальный список всех туристов
        System.out.println("7. ФИНАЛЬНЫЙ СПИСОК ВСЕХ ТУРИСТОВ:");
        System.out.println("-".repeat(80));
        List<Travel> finalList = travelDAO.findAll();
        if (finalList.isEmpty()) {
            System.out.println("База данных пуста.");
        } else {
            finalList.forEach(System.out::println);
        }
        System.out.println("Всего туристов: " + finalList.size());
        System.out.println();

        System.out.println("=".repeat(80));
        System.out.println("ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ УСПЕШНО!");
        System.out.println("=".repeat(80));
    }
}
