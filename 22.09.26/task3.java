import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        if (a > b) {
            System.out.println(a);
            System.out.println(b);
        } else {
            System.out.println(b);
            System.out.println(a);
        }
    }
}

//import java.util.Scanner;
//
//import static java.lang.Math.*;
//
//public class task3 {
//    static void main() {
//        Scanner scanner = new Scanner(System.in);
//        double x = scanner.nextDouble();
//        double y = scanner.nextDouble();
//        if (x > y) {
//            System.out.printf("%8.2f;%8.2f", x, y);
//        } else {
//            System.out.printf("%8.2f;%8.2f", y, x);
//        }
//    }
//
//}