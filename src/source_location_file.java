import java.util.Scanner;

public class source_location_file {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter session ID: ");
        int sessionId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter timestamp (YYYY-MM-DD HH:MM:SS): ");
        String timestamp = scanner.nextLine();

        System.out.print("Enter latitude: ");
        double latitude = scanner.nextDouble();

        System.out.print("Enter longitude: ");
        double longitude = scanner.nextDouble();

        System.out.print("Enter speed: ");
        double speed = scanner.nextDouble();

        // ✅ Insert location data into database
        db_connection.insertLocationLog(sessionId, timestamp, latitude, longitude, speed);
    }
}
