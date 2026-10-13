import java.util.Scanner;

public class Task5 {
    static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println();
        System.out.println("--- Калькулятор ИМТ ---");
        System.out.println("1. Посчитать ИМТ");
        System.out.println("2. О программе");
        System.out.println("3. О разработчике");
        System.out.println("0. Выход");
        System.out.print("Твой выбор: ");
    }

    public static boolean check(double x, double min, double max) {
        return x > min && x <= max;
    }

    public static double readOne(String text, double min, double max) {
        while (true) {
            System.out.print(text);
            String s = sc.nextLine().trim();
            if (s.equals("q")) {
                return -1;
            }
            try {
                double x = Double.parseDouble(s.replace(',', '.'));
                if (check(x, min, max)) {
                    return x;
                }
                System.out.println("Число должно быть от " + min + " до " + max + ", давай ещё раз (q - в меню)");
            } catch (NumberFormatException e) {
                System.out.println("Это не число, давай ещё раз (q - в меню)");
            }
        }
    }

    public static double[] input() {
        double[] data = new double[2];
        data[0] = readOne("Вес в кг (например 70): ", 0, 500);
        if (data[0] == -1) {
            return null;
        }
        data[1] = readOne("Рост в метрах (например 1,75): ", 0, 3);
        if (data[1] == -1) {
            return null;
        }
        return data;
    }

    public static double calc(double[] data) {
        return data[0] / (data[1] * data[1]);
    }

    public static void output(double[] data, double imt) {
        double[] borders = {18.5, 25, 30, 35, 40};
        String[] names = {"Недостаточная масса тела", "Норма", "Избыточная масса тела",
                "Ожирение I степени", "Ожирение II степени", "Ожирение III степени"};

        int k = 0;
        while (k < borders.length && imt >= borders[k]) {
            k++;
        }

        System.out.println();
        System.out.println("Вес: " + data[0] + " кг, рост: " + data[1] + " м");
        System.out.printf("ИМТ = %.2f%n", imt);
        System.out.println("Категория: " + names[k]);
    }

    public static void about() {
        System.out.println("Программа считает индекс массы тела: ИМТ = вес / (рост * рост)");
        System.out.println("Во время ввода можно написать q и вернуться в меню");
    }

    public static void developer() {
        System.out.println("Разработчик: Кнутарев Тимофей, РИ-250931");
    }

    public static void main(String[] args) {
        String choice = "";
        while (!choice.equals("0")) {
            menu();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    double[] data = input();
                    if (data != null) {
                        output(data, calc(data));
                    }
                    break;
                case "2":
                    about();
                    break;
                case "3":
                    developer();
                    break;
                case "0":
                    System.out.println("Пока!");
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
    }
}
