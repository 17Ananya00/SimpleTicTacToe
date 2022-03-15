import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("X O X");
        System.out.println("O X O");
        System.out.println("X X O");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        String pup = scanner.nextLine();
        String[] enter = pup.split("");

        System.out.println("---------");
        System.out.println("|" + " " + enter[0]+" "+ enter[1]+" "+ enter[2]+  " " + "|");
        System.out.println("|" + " " + enter[3]+" "+ enter[4]+" "+ enter[5]+  " " + "|");
        System.out.println("|" + " " + enter[6]+" "+ enter[7]+" "+ enter[8]+  " " + "|");
        System.out.println("---------");
    }
}