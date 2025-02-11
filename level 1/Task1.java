import java.util.Scanner;
class Task1 {

    public static float convertToFahrenheit(float celsius) {
        return (celsius * 9 / 5 )+ 32;
    }

    public static float convertToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature and its units: ");
        int temp = sc.nextInt();
        String unit = sc.next();
        if(unit.equals("C")) {
            System.out.println("Temperature in Fahrenheit: " + convertToFahrenheit(temp));
        } else if(unit.equals("F")) {
            System.out.println("Temperature in Celsius: " + convertToCelsius(temp));
        } else {
            System.out.println("Invalid unit");
        }
    }
}