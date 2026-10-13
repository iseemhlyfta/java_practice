import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите N: ");
        int n = in.nextInt();
        double y = 0;
        for (int i = 1; i <= n; i++) {
            y = y + 1.0 / i;
        }
        System.out.println("y = " + y);
    }
}
