import java.util.Scanner;

public class L5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 3-digit number: ");
        int number = sc.nextInt();

        int origNumber = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += (digit * digit * digit);
            number = number / 10;
        }
        System.out.println("Is the number an Armstrong number? " + (sum == origNumber));
        sc.close();
    }
}