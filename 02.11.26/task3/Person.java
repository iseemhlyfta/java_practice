import java.util.Objects;

public class Person {
    private String name;
    private double weight;
    private double height;

    public Person(String name, double weight, double height) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустое имя");
        }
        if (weight <= 0 || weight > 500) {
            throw new IllegalArgumentException("Вес должен быть от 0 до 500 кг");
        }
        if (height <= 0 || height > 3.0) {
            throw new IllegalArgumentException("Рост должен быть в метрах (например, 1.75)");
        }
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBmi() {
        return weight / (height * height);
    }

    public String getCategory() {
        double bmi = getBmi();
        if (bmi < 18.5) {
            return "Недостаточный вес";
        } else if (bmi < 25) {
            return "Норма";
        } else if (bmi < 30) {
            return "Избыточный вес";
        } else {
            return "Ожирение";
        }
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', weight=" + weight + ", height=" + height + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(weight, person.weight) == 0
                && Double.compare(height, person.height) == 0
                && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, height);
    }
}
