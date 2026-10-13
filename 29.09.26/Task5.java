import java.util.Scanner;

public class Task5 {
    static Scanner in = new Scanner(System.in);

    public static void printMenu() {
        System.out.println();
        System.out.println("1 - Выполнить расчёт");
        System.out.println("2 - Информация о программе");
        System.out.println("3 - Информация о разработчике");
        System.out.println("0 - Выход");
        System.out.print("Выберите пункт: ");
    }

    public static double readNumber(String text) {
        while (true) {
            System.out.print(text);
            String s = in.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода, нужно ввести число. Попробуйте ещё раз.");
            }
        }
    }

    public static double perimeter(double x1, double y1, double x2, double y2) {
        double width = Math.abs(x2 - x1);
        double height = Math.abs(y1 - y2);
        return 2 * (width + height);
    }

    public static void calculate() {
        double x1 = readNumber("Введите x1 (левая верхняя вершина): ");
        double y1 = readNumber("Введите y1 (левая верхняя вершина): ");
        double x2 = readNumber("Введите x2 (правая нижняя вершина): ");
        double y2 = readNumber("Введите y2 (правая нижняя вершина): ");
        while (x1 >= x2 || y1 <= y2) {
            System.out.println("Первая точка должна быть левее и выше второй. Введите координаты заново.");
            x1 = readNumber("Введите x1 (левая верхняя вершина): ");
            y1 = readNumber("Введите y1 (левая верхняя вершина): ");
            x2 = readNumber("Введите x2 (правая нижняя вершина): ");
            y2 = readNumber("Введите y2 (правая нижняя вершина): ");
        }
        System.out.println("Периметр прямоугольника = " + perimeter(x1, y1, x2, y2));
    }

    public static void aboutProgram() {
        System.out.println("Программа считает периметр прямоугольника");
        System.out.println("по координатам левой верхней и правой нижней вершин.");
    }

    public static void aboutDeveloper() {
        System.out.println("Разработчик: студент 1 курса");
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1":
                    calculate();
                    break;
                case "2":
                    aboutProgram();
                    break;
                case "3":
                    aboutDeveloper();
                    break;
                case "0":
                    running = false;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Нет такого пункта, попробуйте ещё раз.");
            }
        }
    }
}
