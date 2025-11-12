import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Создание нового студента
        Student newStudent = new Student();
        newStudent.setName("Иван Иванов");
        studentDAO.create(newStudent);

        // Получение всех студентов
        List<Student> students = studentDAO.findAll();
        System.out.println("Все студенты:");
        students.forEach(System.out::println);

        // Обновление студента
        if (!students.isEmpty()) {
            Student toUpdate = students.get(0);
            toUpdate.setName("Петр Иванов");
            studentDAO.update(toUpdate);
            System.out.println("Студент обновлен");
        }
    }
}