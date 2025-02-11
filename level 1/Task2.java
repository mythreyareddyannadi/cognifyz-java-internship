import java.util.Scanner;
public class Task2 {

    public static String reverse(String str) {
        String rev = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    public static String isPalindrome(String str) {
        String rev = reverse(str);
        if(str.equals(rev)) {
            return " is a Palindrome";
        } else {
            return " is not a Palindrome";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.next();
        System.out.println(str + isPalindrome(str));
    }
}
