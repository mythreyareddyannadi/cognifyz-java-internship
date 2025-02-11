import java.util.Scanner;

public class Task3 {

    public static void grade(int marks) {
        if(marks >= 90) {
            System.out.println("oocupied A grade");
        } else if(marks >= 80) {
            System.out.println("occupied B grade");
        } else if(marks >= 70) {
            System.out.println("occupied C grade");
        } else if(marks >= 60) {
            System.out.println("occupied D grade");
        } else {
            System.out.println("occupied F grade");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int marks = 0;
        System.out.println("Enter number of subjects:");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.print("Enter marks in sub " + (i + 1) + ":");
            marks += sc.nextInt();
        }
        grade(marks/n);
    }
    
}
