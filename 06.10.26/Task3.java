import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько элементов? ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        System.out.println("Вводи массив A:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int k = 0;
        for (int i = 1; i < n; i += 2) {
            b[k] = a[i];
            k++;
        }
        for (int i = 0; i < n; i += 2) {
            b[k] = a[i];
            k++;
        }

        System.out.print("Массив B: ");
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
