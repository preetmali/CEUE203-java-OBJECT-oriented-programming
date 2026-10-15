import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passwordp4 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String pass = sc.next();

        boolean length = pass.length() >= 8;
        boolean uppercase = pass.matches(".*[A-Z].*");
        boolean digit = pass.matches(".*[0-9].*");
        boolean special = pass.matches(".*[!@#$%*|/~`].*");

        int count = 0;

        if (length) {
            System.out.println("Length >= 8: Passed");
            count++;
        } else {
            System.out.println("Length >= 8: Failed");
        }

        if (uppercase) {
            System.out.println("Uppercase: Passed");
            count++;
        } else {
            System.out.println("Uppercase: Failed");
        }

        if (digit) {
            System.out.println("Digit: Passed");
            count++;
        } else {
            System.out.println("Digit: Failed");
        }

        if (special) {
            System.out.println("Special character: Passed");
            count++;
        } else {
            System.out.println("Special character: Failed");
        }

        if (count <= 1) {
            System.out.println("Strength: Weak");
        } else if (count <= 3) {
            System.out.println("Strength: Medium");
        } else {
            System.out.println("Strength: Strong");
        }
        System.out.println("25CE057");
        sc.close();
    }
}