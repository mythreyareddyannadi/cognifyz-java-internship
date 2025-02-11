import java.io.*;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose operation:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try {
            if (choice == 1) {
                String encryptedText = encrypt(readFile(filePath));
                writeFile(filePath + "_encrypted.txt", encryptedText);
                System.out.println("File encrypted successfully!");
            } else if (choice == 2) {
                String decryptedText = decrypt(readFile(filePath));
                writeFile(filePath + "_decrypted.txt", decryptedText);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }

    public static String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (base + (c - base + 3) % 26);
            }
            encryptedText.append(c);
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (base + (c - base - 3 + 26) % 26);
            }
            decryptedText.append(c);
        }
        return decryptedText.toString();
    }
}