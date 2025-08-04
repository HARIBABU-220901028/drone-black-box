import java.util.Scanner;

public class source_flight_file {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter pilot name: ");
        String pilot = scanner.nextLine();

        System.out.print("Enter start time (YYYY-MM-DD HH:MM:SS): ");
        String start = scanner.nextLine();

        System.out.print("Enter end time (YYYY-MM-DD HH:MM:SS): ");
        String end = scanner.nextLine();
        db_connection.insertFlightData(pilot, start, end);
    }
}