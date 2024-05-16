import java.sql.*;
import java.sql.DriverManager;

public class StudentDB {
    static final String DB_URL = "jdbc:mysql://localhost:3307/StudentManagment";
    static final String USER = "root";
    static final String PASSWORD = "";

    

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            // insert(conn);
            // update(conn);
            isStaff(conn, "jhon", "pwd");
            insertCourse(conn, 2, "Mathematics NS", 0, 5, 0, "-", 1, 1);
            insertCourse(conn, 3, "Geography", 0, 5, 0, "-", 1, 1);
            insertCourse(conn, 4, "Physics", 0, 5, 0, "-", 1, 1);
            insertCourse(conn, 5, "Critical Thinking", 0, 5, 0, "-", 1, 1);
            insertCourse(conn, 6, "English 1", 0, 5, 0, "-", 1, 1);
            insertCourse(conn, 7, "Physical Fitness", 0, 5, 0, "-", 1, 1);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insert(Connection conn) {
        String QUERY = "INSERT INTO student_info " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, "henok");

            int res = stmt.executeUpdate();
            System.out.println(res);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
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
            System.out.println(e);
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
            System.out.println(e);
        }
    }

    public static void isStaff(Connection conn, String username, String passwd) {
        String QUERY = "SELECT password FROM staff_users WHERE username = ? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, username);

            ResultSet res = stmt.executeQuery();
            String password = null;
            while (res.next()) {
                password = res.getString("password");
            }

            if (passwd.equals(password)){
                System.out.println("you can login");
            }else{ System.out.println("incorrect credential!");}

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }
    public static void insertCourse(Connection conn, int id,String courseName, int creditHour, int ects, int score, String grade, int year, int semester) {
        String QUERY = "INSERT INTO courses (id ,courseName, creditHour, ects, score, grade, year, semester) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setInt(1, id);
            stmt.setString(2, courseName);
            stmt.setInt(3, creditHour);
            stmt.setInt(4, ects);
            stmt.setInt(5, score);
            stmt.setString(6, grade);
            stmt.setInt(7, year);
            stmt.setInt(8, semester);



            int res = stmt.executeUpdate();
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
