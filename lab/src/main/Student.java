public class Student {
    private int id;
    private String name;
    private int age;

    // Конструкторы
    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // ИСПРАВЛЕННЫЙ геттер для age
    public int getAge() {
        return age;  // ← Должно возвращать age, а не id!
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Студент [Личный номер=" + id + ", Имя=" + name + ", Возраст: " + age + "]";
    }
}