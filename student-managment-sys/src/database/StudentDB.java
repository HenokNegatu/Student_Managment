package database;
import java.sql.*;

public class StudentDB {
    static final String DB_URL = "jdbc:mysql://localhost:3307/StudentManagment";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            // insert(conn);
            update(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insert(Connection conn) {
        String QUERY = "INSERT INTO test " + "VALUES(?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, "henok");

            int res = stmt.executeUpdate();
            System.out.println(res);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void update(Connection conn) {
        String QUERY = "UPDATE test set name = ? WHERE name = ? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, "kirubel");
            stmt.setString(2, "person1");

            int res = stmt.executeUpdate();
            System.out.println(res);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void delete(Connection conn) {
        String QUERY = "DELETE FROM test WHERE name = ? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, "kirubel");
            stmt.setString(2, "person1");

            int res = stmt.executeUpdate();
            System.out.println(res);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
