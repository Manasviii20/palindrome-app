// UC13: Performance Comparison of Palindrome Algorithms
// Compile: javac UseCase13PalindromeCheckerApp.java
// Run:     java UseCase13PalindromeCheckerApp

import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
    String getName();
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return normalized.equals(reversed.toString());
    }

    @Override
    public String getName() {
        return "Stack Strategy";
    }
}

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Deque Strategy";
    }
}

// Simple Two-Pointer Strategy
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public String getName() {
        return "Two-Pointer Strategy";
    }
}

// Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (Performance Comparison) ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // List of strategies to compare
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        // Run each strategy and measure execution time
        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean result = strategy.checkPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(strategy.getName() + ": "
                    + (result ? "Palindrome" : "Not Palindrome")
                    + " | Time: " + duration + " ns");
        }

        scanner.close();
    }
}