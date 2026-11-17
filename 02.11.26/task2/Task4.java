public class Task4 {
    public static void main(String[] args) {
        Transport[] transports = {
                new Car("Toyota", 180, 2018, 5),
                new Car("Lada", 150, 2012, 5),
                new Bus("ЛиАЗ", 90, 2015, 100, 12),
                new Bus("ПАЗ", 80, 2010, 40, 6),
                new Bicycle("Stels", 30, 2022, 21),
                new Bicycle("Forward", 25, 2020, 7)
        };

        double distance = 30;
        double sum = 0;
        Transport fastest = transports[0];
        for (Transport t : transports) {
            double time = t.calculateTravelTime(distance);
            System.out.println(t);
            System.out.printf("  время на %.0f км: %.2f ч%n", distance, time);
            sum += time;
            if (time < fastest.calculateTravelTime(distance)) {
                fastest = t;
            }
        }

        System.out.println();
        System.out.printf("Среднее время в пути: %.2f ч%n", sum / transports.length);
        System.out.println("Быстрее всех: " + fastest.getDescription());
    }
}
