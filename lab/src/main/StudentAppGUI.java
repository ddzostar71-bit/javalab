import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentAppGUI {
    private StudentDAO studentDAO;
    private JFrame frame;
    private JTextArea outputArea;
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;

    public StudentAppGUI() {
        studentDAO = new StudentDAO();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Управление студентами");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Панель ввода данных
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("ID студента:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Имя студента:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        ageField = new JTextField();
        inputPanel.add(new JLabel("Возраст студента:"));
        inputPanel.add(ageField);

        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton("Добавить", this::addStudent));
        buttonPanel.add(createButton("Найти по ID", this::findStudent));
        buttonPanel.add(createButton("Обновить", this::updateStudent));
        buttonPanel.add(createButton("Удалить", this::deleteStudent));
        buttonPanel.add(createButton("Показать всех", this::showAllStudents));

        // Область вывода
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPanel = new JScrollPane(outputArea);

        // Добавляем компоненты на форму
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void addStudent(ActionEvent e) {
        String name = nameField.getText();
        if (name.isEmpty()) {
            showMessage("Введите имя студента");
            return;
        }
        String age = ageField.getText();
        if (age.isEmpty()) {
            showMessage("Введите возраст студента");
            return;
        }

        Student student = new Student();
        student.setName(name);
        int age1 = Integer.parseInt(age);
        System.out.println(age1);
        student.setAge(age1);
        System.out.println(student.toString());
        if (studentDAO.create(student)) {
            showMessage(student.getName()+" добавлен с ID: " + student.getId());
        } else {
            showMessage("Ошибка при добавлении студента");
        }
    }

    private void findStudent(ActionEvent e) {
        try {
            int id = Integer.parseInt(idField.getText());
            Student student = studentDAO.findEntityById(id);
            if (student != null) {
                outputArea.setText(student.toString());
            } else {
                showMessage("Студент с ID " + id + " не найден");
            }
        } catch (NumberFormatException ex) {
            showMessage("Введите корректный ID (число)");
        }
    }

private void updateStudent(ActionEvent e) {
    try {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        if (name.isEmpty()) {
            showMessage("Введите новое имя студента");
            return;
        }
        
        String ageText = ageField.getText();
        if (ageText.isEmpty()) {
            showMessage("Введите возраст студента");
            return;
        }
        
        int age = Integer.parseInt(ageText);

        Student student = new Student(id, name, age);
        student = studentDAO.update(student);
        showMessage("Студент обновлен: " + student);
        showAllStudents(e);
    } catch (NumberFormatException ex) {
        showMessage("Введите корректный ID или возраст (число)");
    }
}

    private void deleteStudent(ActionEvent e) {
        try {
            int id = Integer.parseInt(idField.getText());
            if (studentDAO.delete(id)) {
                showMessage("Студент с ID " + id + " удален");
                showAllStudents(e);
            } else {
                showMessage("Студент с ID " + id + " не найден");
            }
        } catch (NumberFormatException ex) {
            showMessage("Введите корректный ID (число)");
        }
    }

    private void showAllStudents(ActionEvent e) {
        List<Student> students = studentDAO.findAll();
        int totalStudents = students.size(); // Получаем общее количество студентов

        // Создаем модель таблицы
        String[] columnNames = {"ID", "Имя", "Возраст"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Student student : students) {
            model.addRow(new Object[] {student.getId(), student.getName(), student.getAge()});
        }

        // Создаем таблицу
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Создаем панель для таблицы и информации о количестве
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Добавляем метку с количеством студентов в нижнюю часть панели
        JLabel countLabel = new JLabel("Всего студентов: " + totalStudents);
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(countLabel, BorderLayout.SOUTH);

        // Показываем в диалоговом окне
        JOptionPane.showMessageDialog(frame, panel, "Список студентов", JOptionPane.PLAIN_MESSAGE);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentAppGUI());
    }
}