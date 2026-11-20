package util;
import java.util.Scanner;
/* Reads a number and repeats the question if the input is not numeric. */
public class InputHelper {
    public static int readNumber(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
