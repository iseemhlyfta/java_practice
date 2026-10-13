import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите X: ");
        double x = in.nextDouble();
        System.out.print("Введите N: ");
        int n = in.nextInt();
        if (Math.abs(x) >= 1 || n <= 0) {
            System.out.println("Неверные данные");
            return;
        }
        double sum = 0;
        double power = 1;
        int sign = 1;
        for (int i = 1; i <= n; i++) {
            power = power * x;
            sum = sum + sign * power / i;
            sign = -sign;
        }
        System.out.println("ln(X+1) = " + sum);
    }
}
