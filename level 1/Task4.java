import java.util.Random;
import java.util.Scanner;

public class Task4 {

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, 
                                           boolean includeUppercase, boolean includeSpecial) {
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String characterPool = "";
        if (includeNumbers) characterPool += numbers;
        if (includeLowercase) characterPool += lowercase;
        if (includeUppercase) characterPool += uppercase;
        if (includeSpecial) characterPool += special;

        if (characterPool.isEmpty()) {
            return "Error: Please select at least one character type for the password.";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Random Password Generator!");

        try {
            System.out.print("Enter the desired length of the password: ");
            int length = scanner.nextInt();
            scanner.nextLine(); 
            
            if (length <= 0) {
                System.out.println("Error: Password length must be a positive number.");
                return;
            }

            System.out.print("Include numbers? (yes/no): ");
            boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Include lowercase letters? (yes/no): ");
            boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Include uppercase letters? (yes/no): ");
            boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Include special characters? (yes/no): ");
            boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("yes");

            String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);
            System.out.println("\nGenerated Password: " + password);

        } catch (Exception e) {
            System.out.println("Error: Please enter valid inputs.");
        }
    } 
}
