import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("M (строк): ");
        int m = sc.nextInt();
        System.out.print("N (столбцов): ");
        int n = sc.nextInt();
        System.out.print("D: ");
        double d = sc.nextDouble();

        double[][] matr = new double[m][n];
        System.out.println("Вводи " + n + " чисел:");
        for (int j = 0; j < n; j++) {
            matr[0][j] = sc.nextDouble();
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matr[i][j] = matr[i - 1][j] * d;
            }
        }

        System.out.println("Матрица:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
