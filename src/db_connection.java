import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class db_connection {


    public static void insertFlightData(String pilotName, String startTime, String endTime) {
        String url = "jdbc:mysql://localhost:3306/drone_black_box";
        String user = "root";
        String password = "haribabu2004";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO FlightSession (pilot_name, start_time, end_time) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, pilotName);
            stmt.setString(2, startTime);
            stmt.setString(3, endTime);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Flight session inserted successfully.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertLocationLog(int sessionId, String timestamp, double latitude, double longitude, double speed) {
        String url = "jdbc:mysql://localhost:3306/drone_black_box";
        String user = "root";
        String password = "haribabu2004";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO LocationLog (session_id, timestamp, latitude, longitude, speed) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, sessionId);
            stmt.setString(2, timestamp);
            stmt.setDouble(3, latitude);
            stmt.setDouble(4, longitude);
            stmt.setDouble(5, speed);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Location log inserted successfully.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAllData() {
        String url = "jdbc:mysql://localhost:3306/drone_black_box";
        String user = "root";
        String password = "haribabu2004";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database...");

            String sql = "SELECT * FROM LocationLog";  // <- Adjust table name if needed
            Statement stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(sql);

            while (rs2.next()) {
                System.out.println("Log ID: " + rs2.getInt("log_id") +
                        ", Session ID: " + rs2.getInt("session_id") +
                        ", Time: " + rs2.getString("timestamp") +
                        ", Lat: " + rs2.getDouble("latitude") +
                        ", Long: " + rs2.getDouble("longitude") +
                        ", Speed: " + rs2.getDouble("speed"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
         // create object
        //db.insertFlightData("Test Pilot", "2025-08-04 09:00:00", "2025-08-04 09:30:00");
    }
}




