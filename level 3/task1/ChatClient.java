import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(username + " has joined the chat.");

            new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from the server.");
                }
            }).start();

            String userInput;
            while ((userInput = scanner.nextLine()) != null) {
                out.println(username + ": " + userInput);
            }
        } catch (IOException e) {
            System.out.println("Unable to connect to the server.");
        }
    }
}