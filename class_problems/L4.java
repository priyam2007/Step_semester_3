import java.util.Scanner;

public class L4  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number1 and number2: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        int orig1 = number1;
        int orig2 = number2;

        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        System.out.println("The GCD of " + orig1 + " and " + orig2 + " is " + number1);
        sc.close();
    }
}