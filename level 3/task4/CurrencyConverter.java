import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static double getExchangeRate(String apiKey, String baseCurrency, String targetCurrency) {
        try {
            String urlString = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return extractExchangeRate(response.toString(), targetCurrency);
            
        } catch (Exception e) {
            System.out.println("Error: Unable to fetch exchange rates. " + e.getMessage());
            return -1;
        }
    }

    public static double extractExchangeRate(String response, String targetCurrency) {
        String searchKey = "\"" + targetCurrency + "\":";
        int index = response.indexOf(searchKey);

        if (index != -1) {
            int start = index + searchKey.length();
            int end = response.indexOf(",", start);
            if (end == -1) end = response.indexOf("}", start); 

            String rateStr = response.substring(start, end).trim();
            return Double.parseDouble(rateStr);
        } else {
            System.out.println("Error: Target currency '" + targetCurrency + "' not found.");
            return -1;
        }
    }

    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        String apiKey = "f0295d4a7d67dc46c711658a"; 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = getExchangeRate(apiKey, baseCurrency, targetCurrency);

        if (exchangeRate != -1) {
            double convertedAmount = convertCurrency(amount, exchangeRate);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Currency conversion failed.");
        }

        scanner.close();
    }
}
