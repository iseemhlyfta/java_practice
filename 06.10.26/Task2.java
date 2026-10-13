import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько элементов? ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Вводи упорядоченный массив:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        if (n > 0) {
            count = 1;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                count++;
            }
        }
        System.out.println("Различных элементов: " + count);
    }
}
