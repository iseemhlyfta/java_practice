public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 180, 2018, 5);
        Bus bus = new Bus("ЛиАЗ", 90, 2015, 100, 12);
        Bicycle bike = new Bicycle("Stels", 30, 2022, 21);

        Transport t1 = car;
        Transport t2 = bus;
        Transport t3 = bike;

        double distance = 50;
        System.out.println("Расстояние: " + distance + " км");
        System.out.println(t1.getDescription());
        System.out.printf("Время в пути: %.2f ч%n", t1.calculateTravelTime(distance));
        System.out.println(t2.getDescription());
        System.out.printf("Время в пути: %.2f ч%n", t2.calculateTravelTime(distance));
        System.out.println(t3.getDescription());
        System.out.printf("Время в пути: %.2f ч%n", t3.calculateTravelTime(distance));
        System.out.println();

        System.out.println(car);
        System.out.println(bus);
        System.out.println(bike);
        System.out.println();

        Car car2 = new Car("Toyota", 180, 2018, 5);
        Car car3 = new Car("Toyota", 180, 2018, 7);
        System.out.println("car.equals(car2): " + car.equals(car2));
        System.out.println("car.equals(car3): " + car.equals(car3));
        System.out.println("car.equals(bus): " + car.equals(bus));
        System.out.println("hashCode car: " + car.hashCode());
        System.out.println("hashCode car2: " + car2.hashCode());
        System.out.println("hashCode car3: " + car3.hashCode());
    }
}
