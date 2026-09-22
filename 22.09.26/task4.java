import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Формула расчета: ИМТ = вес / (рост * рост)");
        System.out.println();

        System.out.print("Введите ваш вес в кг (например, 70): ");
        double weight = scanner.nextDouble();

        System.out.print("Введите ваш рост в метрах (например, 1,75): ");
        double height = scanner.nextDouble();

        if (weight <= 0) {
            System.out.println("Вес должен быть больше 0");
            return;
        }
        if (height <= 0) {
            System.out.println("Рост должен быть больше 0");
            return;
        }
        if (height > 3.0) {
            System.out.println("Введите рост в метрах (например, 1,75, а не 175)");
            return;
        }

        double imt = weight / (height * height);

        System.out.println();
        System.out.printf("Ваш индекс массы тела (ИМТ): %.2f%n", imt);

        if (imt < 18.5) {
            System.out.println("Категория: Недостаточная масса тела");
        } else if (imt < 25.0) {
            System.out.println("Категория: Норма");
        } else if (imt < 30.0) {
            System.out.println("Категория: Избыточная масса тела");
        } else if (imt < 35.0) {
            System.out.println("Категория: Ожирение I степени");
        } else if (imt < 40.0) {
            System.out.println("Категория: Ожирение II степени");
        } else {
            System.out.println("Категория: Ожирение III степени");
        }
    }
}