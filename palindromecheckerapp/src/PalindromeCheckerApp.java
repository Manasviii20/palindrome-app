import java.util.Scanner;

public class PalindromeCheckerApp {
    static void main() { // Hardcoded string (String Literal)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it is a palindrome:");
        String originalString = scanner.nextLine();

        String reversedString = "";

        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i);
        }
        if (originalString.equals(reversedString)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
