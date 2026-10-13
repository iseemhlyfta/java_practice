import java.util.Scanner;

public class Task4 {
    public static double perimeter(double x1, double y1, double x2, double y2) {
        double width = Math.abs(x2 - x1);
        double height = Math.abs(y1 - y2);
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x1 y1 (левая верхняя вершина): ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        System.out.print("Введите x2 y2 (правая нижняя вершина): ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        System.out.println("Периметр = " + perimeter(x1, y1, x2, y2));
    }
}
