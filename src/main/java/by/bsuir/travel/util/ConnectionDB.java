package by.bsuir.travel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Класс для управления соединениями с базой данных
 */
public class ConnectionDB {
    private static final String DB_PROPERTIES = "database";
    private static ResourceBundle resource = ResourceBundle.getBundle(DB_PROPERTIES);

    private static final String DB_URL = resource.getString("db.url");
    private static final String DB_USER = resource.getString("db.user");
    private static final String DB_PASSWORD = resource.getString("db.password");

    private ConnectionDB() {
    }

    /**
     * Создает и возвращает соединение с базой данных
     * @return Connection объект соединения
     * @throws SQLException если произошла ошибка при подключении
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
