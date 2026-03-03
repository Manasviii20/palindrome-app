// File: UseCase10PalindromeCheckerApp.java

import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check palindrome ignoring case and spaces
    public static boolean isPalindrome(String input) {
        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Convert to char array for comparison
        char[] chars = normalized.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        // Check palindrome logic
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: The string is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("Result: The string is NOT a palindrome (ignoring case and spaces).");
        }

        scanner.close();
    }
}