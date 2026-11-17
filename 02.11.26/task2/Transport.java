import java.util.Objects;

public abstract class Transport {
    private String brand;
    private int maxSpeed;
    private int year;

    public Transport(String brand, int maxSpeed, int year) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустая марка");
        }
        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("Скорость должна быть больше 0");
        }
        if (year < 1885 || year > 2026) {
            throw new IllegalArgumentException("Недопустимый год выпуска");
        }
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getYear() {
        return year;
    }

    public abstract double calculateTravelTime(double distance);

    public String getDescription() {
        return getClass().getSimpleName() + " " + brand + ", " + year + " г., до " + maxSpeed + " км/ч";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{brand='" + brand + "', maxSpeed=" + maxSpeed + ", year=" + year + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport t = (Transport) o;
        return maxSpeed == t.maxSpeed && year == t.year && brand.equals(t.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, maxSpeed, year);
    }
}
