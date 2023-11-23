import java.util.Scanner;

public class recursion_fibonacci {
    static int fibonacci(int n) {
        // base condition
        if (n < 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Fibonacci formula
    }

    public static void main(String[] args) {
        System.out.println("Enter the value of n to find the nth Fibonacci number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");

        }
    }
}
