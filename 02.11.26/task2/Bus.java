import java.util.Objects;

public class Bus extends Transport {
    private int capacity;
    private int stops;

    public Bus(String brand, int maxSpeed, int year, int capacity, int stops) {
        super(brand, maxSpeed, year);
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть больше 0");
        }
        if (stops < 0) {
            throw new IllegalArgumentException("Число остановок не может быть отрицательным");
        }
        this.capacity = capacity;
        this.stops = stops;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStops() {
        return stops;
    }

    @Override
    public double calculateTravelTime(double distance) {
        return distance / (getMaxSpeed() * 0.5) + stops * 2 / 60.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", вместимость: " + capacity + ", остановок: " + stops;
    }

    @Override
    public String toString() {
        return "Bus{brand='" + getBrand() + "', maxSpeed=" + getMaxSpeed() + ", year=" + getYear()
                + ", capacity=" + capacity + ", stops=" + stops + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return capacity == bus.capacity && stops == bus.stops;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, stops);
    }
}
