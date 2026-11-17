import java.util.Objects;

public class Athlete extends Person {
    private String sport;
    private int trainingsPerWeek;

    public Athlete(String name, double weight, double height, String sport, int trainingsPerWeek) {
        super(name, weight, height);
        if (sport == null || sport.trim().isEmpty()) {
            throw new IllegalArgumentException("Не указан вид спорта");
        }
        if (trainingsPerWeek < 1 || trainingsPerWeek > 14) {
            throw new IllegalArgumentException("Тренировок в неделю должно быть от 1 до 14");
        }
        this.sport = sport;
        this.trainingsPerWeek = trainingsPerWeek;
    }

    public String getSport() {
        return sport;
    }

    public int getTrainingsPerWeek() {
        return trainingsPerWeek;
    }

    @Override
    public String getCategory() {
        double bmi = getBmi();
        if (bmi >= 25 && bmi < 30 && trainingsPerWeek >= 3) {
            return "Норма (повышенный ИМТ из-за мышечной массы)";
        }
        return super.getCategory();
    }

    @Override
    public String toString() {
        return "Athlete{name='" + getName() + "', weight=" + getWeight() + ", height=" + getHeight()
                + ", sport='" + sport + "', trainingsPerWeek=" + trainingsPerWeek + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Athlete a = (Athlete) o;
        return trainingsPerWeek == a.trainingsPerWeek && sport.equals(a.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sport, trainingsPerWeek);
    }
}
