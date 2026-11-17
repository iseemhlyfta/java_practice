public class Main {
    public static void main(String[] args) {
        Person p = new Athlete("Иван", 90, 1.85, "Регби", 5);
        System.out.println("Переменная типа Person: " + p);
        System.out.printf("ИМТ = %.1f, категория: %s%n", p.getBmi(), p.getCategory());
        System.out.println();

        Person[] people = {
                new Person("Анна", 55, 1.68),
                new Person("Олег", 95, 1.75),
                new Athlete("Иван", 90, 1.85, "Регби", 5),
                new Athlete("Маша", 48, 1.70, "Бег", 4),
                new Senior("Пётр Ильич", 63, 1.72, 70),
                new Senior("Галина", 75, 1.65, 68)
        };

        System.out.println("Все люди:");
        for (Person person : people) {
            System.out.printf("%-12s ИМТ = %5.1f  %s%n", person.getName(), person.getBmi(), person.getCategory());
        }
        System.out.println();

        System.out.println("toString():");
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println();

        Person a1 = new Athlete("Иван", 90, 1.85, "Регби", 5);
        Person a2 = new Athlete("Иван", 90, 1.85, "Регби", 5);
        Person a3 = new Athlete("Иван", 90, 1.85, "Плавание", 5);
        Person a4 = new Person("Иван", 90, 1.85);
        System.out.println("a1.equals(a2): " + a1.equals(a2));
        System.out.println("a1.equals(a3): " + a1.equals(a3));
        System.out.println("a1.equals(a4): " + a1.equals(a4));
        System.out.println("hashCode a1: " + a1.hashCode());
        System.out.println("hashCode a2: " + a2.hashCode());
        System.out.println("hashCode a3: " + a3.hashCode());
        System.out.println();

        try {
            new Person("Ошибка", 70, 175);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            new Senior("Ошибка", 70, 1.75, 40);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
