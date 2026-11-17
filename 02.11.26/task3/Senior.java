import java.util.Objects;

public class Senior extends Person {
    private int age;

    public Senior(String name, double weight, double height, int age) {
        super(name, weight, height);
        if (age < 65 || age > 120) {
            throw new IllegalArgumentException("Возраст пожилого человека от 65 до 120 лет");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getCategory() {
        double bmi = getBmi();
        if (bmi < 22) {
            return "Недостаточный вес";
        } else if (bmi < 27) {
            return "Норма";
        } else if (bmi < 30) {
            return "Избыточный вес";
        } else {
            return "Ожирение";
        }
    }

    @Override
    public String toString() {
        return "Senior{name='" + getName() + "', weight=" + getWeight() + ", height=" + getHeight() + ", age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Senior s = (Senior) o;
        return age == s.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}
