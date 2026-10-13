import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько элементов? ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Вводи элементы:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Нечётные номера: ");
        for (int i = 0; i < n; i += 2) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.print("Чётные номера с конца: ");
        for (int i = n / 2 * 2 - 1; i > 0; i -= 2) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
