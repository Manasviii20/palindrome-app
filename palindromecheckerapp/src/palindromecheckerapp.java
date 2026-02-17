public class palindromecheckerapp {
    static void main() { // Hardcoded string (String Literal)
        String word = "madam";

        // Reverse the string
        String reversedWord = "";

        for (int i =0;i<word.length() / 2; i++) {
            reversedWord = reversedWord + word.charAt(i);
        }


        if (word.equals(reversedWord)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is not a Palindrome.");
        }
    }
}
