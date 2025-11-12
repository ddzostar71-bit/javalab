import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    // Инициализация - создание таблицы, если она не существует
    static {
        createTableIfNotExists();
    }

    private static void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" + 
             "id SERIAL PRIMARY KEY, " +
             "name VARCHAR(100) NOT NULL, " +
             "age INT)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица students создана или уже существует");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблицы students: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Найти студента по ID
    public Student findEntityById(int id) {
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Получить всех студентов
   public List<Student> findAll() {
    List<Student> students = new ArrayList<>();
    // Добавляем ORDER BY name для сортировки
    String sql = "SELECT * FROM students ORDER BY name"; 

    try (Connection connection = getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {

        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(Integer.parseInt(resultSet.getString("age")));
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return students;
}

    // Удалить студента по ID
    public boolean delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        int rowsAffected = 0;

        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected > 0;
    }

    // Удалить студента по объекту
    public boolean delete(Student student) {
        return delete(student.getId());
    }

    // Создать нового студента
    public boolean create(Student student) {
    String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
    int rowsAffected = 0;

    System.out.println("=== DEBUG CREATE METHOD ===");
    System.out.println("SQL: " + sql);
    System.out.println("Student data - Name: '" + student.getName() + "', Age: " + student.getAge());

    try (Connection connection = getConnection();
         PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        
        System.out.println("Executing update...");
        rowsAffected = statement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                student.setId(generatedId);
                System.out.println("Generated ID: " + generatedId);
            } else {
                System.out.println("No generated keys returned!");
            }
        }
    } catch (SQLException e) {
        System.out.println("SQL ERROR: " + e.getMessage());
        e.printStackTrace();
    }
    
    System.out.println("Method returning: " + (rowsAffected > 0));
    return rowsAffected > 0;
}

    // Обновить студента
    public Student update(Student student) {
    String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
    
    try (Connection connection = getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        statement.setInt(3, student.getId());
        
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            return student;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}