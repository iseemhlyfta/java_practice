import java.util.Scanner;

public class Task5 {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println();
        System.out.println("===== Калькулятор ИМТ =====");
        System.out.println("1 - Выполнить расчёт");
        System.out.println("2 - Информация о программе");
        System.out.println("3 - Информация о разработчике");
        System.out.println("0 - Выход");
        System.out.print("Выберите пункт меню: ");
    }

    public static double readNumber(String text, double min, double max, String errorText) {
        while (true) {
            System.out.print(text);
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("q")) {
                return -1;
            }
            line = line.replace(',', '.');
            double number;
            try {
                number = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число. Попробуйте ещё раз (q - выход в меню).");
                continue;
            }
            if (number <= min || number > max) {
                System.out.println(errorText + " Попробуйте ещё раз (q - выход в меню).");
                continue;
            }
            return number;
        }
    }

    public static double calculateImt(double weight, double height) {
        return weight / (height * height);
    }

    public static String getCategory(double imt) {
        if (imt < 18.5) {
            return "Недостаточная масса тела";
        } else if (imt < 25.0) {
            return "Норма";
        } else if (imt < 30.0) {
            return "Избыточная масса тела";
        } else if (imt < 35.0) {
            return "Ожирение I степени";
        } else if (imt < 40.0) {
            return "Ожирение II степени";
        } else {
            return "Ожирение III степени";
        }
    }

    public static void printResult(double imt) {
        System.out.println();
        System.out.printf("Ваш индекс массы тела (ИМТ): %.2f%n", imt);
        System.out.println("Категория: " + getCategory(imt));
    }

    public static void calculate() {
        System.out.println();
        System.out.println("Формула расчета: ИМТ = вес / (рост * рост)");
        System.out.println();

        double weight = readNumber("Введите ваш вес в кг (например, 70): ", 0, 500,
                "Вес должен быть больше 0 и не больше 500 кг.");
        if (weight == -1) {
            return;
        }

        double height = readNumber("Введите ваш рост в метрах (например, 1,75): ", 0, 3.0,
                "Рост должен быть больше 0 и не больше 3 м (например, 1,75, а не 175).");
        if (height == -1) {
            return;
        }

        double imt = calculateImt(weight, height);
        printResult(imt);
    }

    public static void printAboutProgram() {
        System.out.println();
        System.out.println("Программа считает индекс массы тела (ИМТ)");
        System.out.println("по весу и росту и определяет категорию массы тела.");
        System.out.println("При вводе данных можно ввести q, чтобы вернуться в меню.");
    }

    public static void printAboutDeveloper() {
        System.out.println();
        System.out.println("Разработчик: студент 1 курса");
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    calculate();
                    break;
                case "2":
                    printAboutProgram();
                    break;
                case "3":
                    printAboutDeveloper();
                    break;
                case "0":
                    running = false;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Такого пункта нет. Попробуйте ещё раз.");
            }
        }
    }
}
