import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите N: ");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("N должно быть больше 0");
            return;
        }
        while (n > 0) {
            System.out.println(n % 10);
            n = n / 10;
        }
    }
}
