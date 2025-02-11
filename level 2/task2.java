import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);

        System.out.println("Password Strength: " + strength);

        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");
        boolean isLongEnough = password.length() >= 8;

        int strengthScore = 0;
        if (hasUppercase) strengthScore++;
        if (hasLowercase) strengthScore++;
        if (hasDigit) strengthScore++;
        if (hasSpecialChar) strengthScore++;
        if (isLongEnough) strengthScore++;

        if (strengthScore == 5) {
            return "Very Strong";
        } else if (strengthScore == 4) {
            return "Strong";
        } else if (strengthScore == 3) {
            return "Moderate";
        } else if (strengthScore == 2) {
            return "Weak";
        } else {
            return "Very Weak";
        }
    }
}