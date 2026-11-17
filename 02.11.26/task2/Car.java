import java.util.Objects;

public class Car extends Transport {
    private int seats;

    public Car(String brand, int maxSpeed, int year, int seats) {
        super(brand, maxSpeed, year);
        if (seats < 1 || seats > 9) {
            throw new IllegalArgumentException("Недопустимое число мест");
        }
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public double calculateTravelTime(double distance) {
        return distance / (getMaxSpeed() * 0.7);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", мест: " + seats;
    }

    @Override
    public String toString() {
        return "Car{brand='" + getBrand() + "', maxSpeed=" + getMaxSpeed() + ", year=" + getYear() + ", seats=" + seats + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return seats == car.seats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seats);
    }
}
