package by.bsuir.travel.dao;

import by.bsuir.travel.entity.Travel;
import by.bsuir.travel.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO класс для работы с сущностью Travel (туристы/клиенты)
 */
public class TravelDAO extends AbstractDAO<Travel> {

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM tourists";

    private static final String SELECT_BY_ID_QUERY =
            "SELECT * FROM tourists WHERE id = ?";

    private static final String INSERT_QUERY =
            "INSERT INTO tourists (first_name, last_name, email, phone_number, destination, duration_days, price) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_QUERY =
            "UPDATE tourists SET first_name = ?, last_name = ?, email = ?, phone_number = ?, " +
            "destination = ?, duration_days = ?, price = ? WHERE id = ?";

    private static final String DELETE_QUERY =
            "DELETE FROM tourists WHERE id = ?";

    /**
     * Получает всех туристов из БД
     * @return список всех туристов
     */
    @Override
    public List<Travel> findAll() {
        List<Travel> tourists = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY)) {

            while (resultSet.next()) {
                tourists.add(extractTravelFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении всех туристов: " + e.getMessage());
            e.printStackTrace();
        }
        return tourists;
    }

    /**
     * Находит туриста по ID
     * @param id идентификатор туриста
     * @return найденный турист или null
     */
    @Override
    public Travel findEntityById(Integer id) {
        Travel tourist = null;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tourist = extractTravelFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при поиске туриста по ID: " + e.getMessage());
            e.printStackTrace();
        }
        return tourist;
    }

    /**
     * Удаляет туриста из БД по ID
     * @param id идентификатор туриста для удаления
     * @return true если удаление успешно, false иначе
     */
    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении туриста по ID: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Удаляет туриста из БД
     * @param tourist турист для удаления
     * @return true если удаление успешно, false иначе
     */
    @Override
    public boolean delete(Travel tourist) {
        if (tourist == null || tourist.getId() == null) {
            return false;
        }
        return delete(tourist.getId());
    }

    /**
     * Создает нового туриста в БД
     * @param tourist турист для создания
     * @return true если создание успешно, false иначе
     */
    @Override
    public boolean create(Travel tourist) {
        if (tourist == null) {
            return false;
        }

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, tourist.getFirstName());
            statement.setString(2, tourist.getLastName());
            statement.setString(3, tourist.getEmail());
            statement.setString(4, tourist.getPhoneNumber());
            statement.setString(5, tourist.getDestination());
            statement.setInt(6, tourist.getDurationDays());
            statement.setDouble(7, tourist.getPrice());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    tourist.setId(generatedKeys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при создании туриста: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Обновляет данные туриста в БД
     * @param tourist турист для обновления
     * @return обновленный турист
     */
    @Override
    public Travel update(Travel tourist) {
        if (tourist == null || tourist.getId() == null) {
            return null;
        }

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, tourist.getFirstName());
            statement.setString(2, tourist.getLastName());
            statement.setString(3, tourist.getEmail());
            statement.setString(4, tourist.getPhoneNumber());
            statement.setString(5, tourist.getDestination());
            statement.setInt(6, tourist.getDurationDays());
            statement.setDouble(7, tourist.getPrice());
            statement.setInt(8, tourist.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return tourist;
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении туриста: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Извлекает объект Travel из ResultSet
     * @param resultSet результат запроса
     * @return объект Travel
     * @throws SQLException если произошла ошибка при получении данных
     */
    private Travel extractTravelFromResultSet(ResultSet resultSet) throws SQLException {
        Travel tourist = new Travel();
        tourist.setId(resultSet.getInt("id"));
        tourist.setFirstName(resultSet.getString("first_name"));
        tourist.setLastName(resultSet.getString("last_name"));
        tourist.setEmail(resultSet.getString("email"));
        tourist.setPhoneNumber(resultSet.getString("phone_number"));
        tourist.setDestination(resultSet.getString("destination"));
        tourist.setDurationDays(resultSet.getInt("duration_days"));
        tourist.setPrice(resultSet.getDouble("price"));
        return tourist;
    }
}
