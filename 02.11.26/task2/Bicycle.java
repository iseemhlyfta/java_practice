import java.util.Objects;

public class Bicycle extends Transport {
    private int gears;

    public Bicycle(String brand, int maxSpeed, int year, int gears) {
        super(brand, maxSpeed, year);
        if (gears < 1) {
            throw new IllegalArgumentException("Передач должно быть хотя бы 1");
        }
        this.gears = gears;
    }

    public int getGears() {
        return gears;
    }

    @Override
    public double calculateTravelTime(double distance) {
        double time = distance / (getMaxSpeed() * 0.6);
        int rests = (int) time;
        return time + rests * 10 / 60.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", передач: " + gears;
    }

    @Override
    public String toString() {
        return "Bicycle{brand='" + getBrand() + "', maxSpeed=" + getMaxSpeed() + ", year=" + getYear() + ", gears=" + gears + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Bicycle b = (Bicycle) o;
        return gears == b.gears;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gears);
    }
}
