import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = 3 * Math.pow(x, 6) - 6 * Math.pow(x, 2) - 5;
        System.out.println(y);
    }
}