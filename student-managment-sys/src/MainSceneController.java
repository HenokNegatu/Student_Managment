import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import database.Course;
import database.Student;

public class MainSceneController {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    static final String DB_URL = "jdbc:mysql://localhost:3307/StudentManagment";
    static final String USER = "root";
    static final String PASSWORD = "";

    @FXML
    private PasswordField passwd;

    @FXML
    private TextField username;

    @FXML
    void toDashboard(ActionEvent event) throws IOException {

        String QUERY = "SELECT password FROM staff_users WHERE username = ? ";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, username.getText());

            ResultSet res = stmt.executeQuery();
            String password = null;
            while (res.next()) {
                password = res.getString("password");
            }

            if (passwd.getText().equals(password)) {
                System.out.println("you can login");
                root = FXMLLoader.load(getClass().getResource("./MainDashboardScene.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Login Error");
                alert.setContentText("Incorrect credentials!");

                alert.showAndWait();

                System.out.println("incorrect credential!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void toLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("./formScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button addBtn;

    @FXML
    private Button addCoursebtn;

    @FXML
    private ComboBox<String> course;

    @FXML
    private TextField creditHr;

    @FXML
    private Button deleteBtn;

    @FXML
    private ComboBox<String> department;

    // ******************student table******************
    @FXML
    private TableView<Student> studentInfoTable;

    @FXML
    private TableColumn<Student, Integer> idCol;

    @FXML
    private TableColumn<Student, String> firstnameCol;

    @FXML
    private TableColumn<Student, String> lastnameCol;

    @FXML
    private TableColumn<Student, String> genderCol;

    @FXML
    private TableColumn<Student, String> phoneCol;

    @FXML
    private TableColumn<Student, String> departmentCol;

    @FXML
    private TableColumn<Student, String> emailCol;

    @FXML
    private TableColumn<Student, Date> birthdateCol;

    public static ObservableList<Student> getStudnetInfo() {

        ObservableList<Student> students = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student_info");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                students.add(new Student(Integer.parseInt(rs.getString("id")), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("gender"), rs.getString("phone"),
                        rs.getString("department"), rs.getString("email"), Date.valueOf(rs.getString("birthdate"))));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return students;
    }

    public static ObservableList<Course> getCourse() {

        ObservableList<Course> courses = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                courses.add(new Course(Integer.parseInt(rs.getString("id")), rs.getString("courseName"),
                        Integer.parseInt(rs.getString("creditHour")), Integer.parseInt(rs.getString("ects")), Integer.parseInt(rs.getString("score")),
                        rs.getString("grade"), Integer.parseInt(rs.getString("year")), Integer.parseInt(rs.getString("semester"))));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return courses;
    }



    // ******************course table *********************

    @FXML
    private TableView<Course> course_table;

    @FXML
    private TableColumn<Course, Integer> idCol2;

    @FXML
    private TableColumn<Course, String> courseCol;

    @FXML
    private TableColumn<Course, Integer> credit_hrCol;

    @FXML
    private TableColumn<Course, Integer> ectsCol;

    @FXML
    private TableColumn<Course, Integer> scoreCol;

    @FXML
    private TableColumn<Course, String> gradeCol;

    @FXML
    private TableColumn<Course, Integer> yearCol;

    @FXML
    private TableColumn<Course, Integer> semisterCol;

    // ********************** all combobox, table initializations ****

    ObservableList<Student> listStudent;
    ObservableList<Course> listCourse;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    @FXML
    public void initialize() {
        try {
            List<String> list = new ArrayList<String>();
            list.add("Male");
            list.add("Female");
            ObservableList obList = FXCollections.observableList(list);
            gender.getItems().clear();
            gender.setItems(obList);

            List<String> departmentList = new ArrayList<String>();
            departmentList.add("Computer");
            departmentList.add("Electrical");
            departmentList.add("Mechanical");
            departmentList.add("Hydrolics");
            departmentList.add("Archtecture");
            ObservableList departmentobList = FXCollections.observableList(departmentList);
            department.getItems().clear();
            department.setItems(departmentobList);

            List<Integer> yearList = new ArrayList<Integer>();
            yearList.add(1);
            yearList.add(2);
            yearList.add(3);
            yearList.add(4);
            yearList.add(5);
            ObservableList yearobList = FXCollections.observableList(yearList);
            year.getItems().clear();
            year.setItems(yearobList);

            List<Integer> semisterList = new ArrayList<Integer>();
            semisterList.add(1);
            semisterList.add(2);
            ObservableList semisterobList = FXCollections.observableList(semisterList);
            semister.getItems().clear();
            semister.setItems(semisterobList);

            List<String> courseList = new ArrayList<String>();
            courseList.add("General Psychology");
            courseList.add("Mathematics NS");
            courseList.add("Geography");
            courseList.add("Physics");
            courseList.add("Critical Thinking");
            courseList.add("English 1");
            courseList.add("Physical Fitness");
            courseList.add("");
            courseList.add("Applied Math 1");
            courseList.add("Emerging Tech");
            courseList.add("Enterpreneurship");
            courseList.add("Anthropology");
            courseList.add("English 2");
            courseList.add("Computer Programming");
            courseList.add("Moral and Civic");
            courseList.add("");
            courseList.add("Engineering Drawing");
            courseList.add("Mechanics 1");
            courseList.add("Probability and Statistics");
            courseList.add("Applied Math 2");
            courseList.add("Inclusiveness");
            courseList.add("Intro to Economics");
            courseList.add("");
            courseList.add("Intermidate Computer Programming");
            courseList.add("Fundamental of EE");
            courseList.add("Fundamental Lab");
            courseList.add("Mechanics 2");
            courseList.add("Applied Math 3");
            courseList.add("Modern Physics");
            courseList.add("Computational Methods");
            courseList.add("");
            courseList.add("Applied Electronics 1");
            courseList.add("Data Structure");
            courseList.add("Signal and System Analysis");
            courseList.add("Computer Network 1");
            courseList.add("Discrete Mathematics");
            courseList.add("Database");
            courseList.add("Electrical Workshop");
            courseList.add("");
            courseList.add("Algothim analysis and design");
            courseList.add("Basics Electrical Device");
            courseList.add("DLD");
            courseList.add("Applied Electronics 2");
            courseList.add("Computer Network 2");
            courseList.add("Network Analysis");
            courseList.add("");
            courseList.add("Internet Programming");
            courseList.add("Communication");
            courseList.add("Computer Architecture and Org");
            courseList.add("Advanced Programming");
            courseList.add("Control and Instrumentation");
            courseList.add("DSP");
            courseList.add("Computer Network Security");

            ObservableList courseobList = FXCollections.observableList(courseList);
            course.getItems().clear();
            course.setItems(courseobList);

            //table
            idCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
            firstnameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));
            lastnameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
            genderCol.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
            departmentCol.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
            emailCol.setCellValueFactory(new PropertyValueFactory <Student, String>("email"));
            birthdateCol.setCellValueFactory(new PropertyValueFactory<Student, Date>("birthdate"));

            listStudent = getStudnetInfo();
            studentInfoTable.setItems(listStudent);

            //table
            idCol2.setCellValueFactory(new PropertyValueFactory<Course, Integer>("id"));
            courseCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
            credit_hrCol.setCellValueFactory(new PropertyValueFactory<Course, Integer>("creditHour"));
            ectsCol.setCellValueFactory(new PropertyValueFactory<Course, Integer>("ects"));
            scoreCol.setCellValueFactory(new PropertyValueFactory<Course, Integer>("score"));
            gradeCol.setCellValueFactory(new PropertyValueFactory<Course, String>("grade"));
            yearCol.setCellValueFactory(new PropertyValueFactory <Course, Integer>("year"));
            semisterCol.setCellValueFactory(new PropertyValueFactory<Course, Integer>("semester"));

            listCourse = getCourse();
            course_table.setItems(listCourse);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private TextField ects;

    @FXML
    private Button editBtn;

    @FXML
    private TextField firstname;

    @FXML
    private ComboBox<String> gender;

    initialize();

    @FXML
    private DatePicker birthdate;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private TextField id2;

    @FXML
    private TextField idDearchField;

    @FXML
    private TextField lastname;

    @FXML
    private TextField phone;

    @FXML
    private TextField score;

    @FXML
    private Button search;

    @FXML
    private ComboBox<Integer> semister;

    @FXML
    private ComboBox<Integer> year;

    @FXML
    void addCourse(ActionEvent event) {

    }

    @FXML
    void addStudentInfo(ActionEvent event) {
        String QUERY = "INSERT INTO student_info " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setInt(1, Integer.parseInt(id.getText()));
            stmt.setString(2, firstname.getText());
            stmt.setString(3, lastname.getText());
            stmt.setString(4, gender.getValue());
            stmt.setString(5, phone.getText());
            stmt.setString(6, department.getValue());
            stmt.setString(7, email.getText());
            stmt.setDate(8, Date.valueOf(birthdate.getValue()));

            int res = stmt.executeUpdate();
            System.out.println(res);
            getStudnetInfo();
            initialize();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    @FXML
    void deleteStudentInfo(ActionEvent event) {

    }

    @FXML
    void editStudentInfo(ActionEvent event) {

    }

    public double calculateCGPA(List<Course> courses) {
        double totalScore = 0.0;
        int totalCreditHours = 0;

        for (Course course : courses) {
            double scoreOutOf4 = convertScoreTo4Scale(course.getScore());
            totalScore += scoreOutOf4 * course.getCreditHours();
            totalCreditHours += course.getCreditHours();
        }

        return totalScore / totalCreditHours;
    }

    public double convertScoreTo4Scale(int score) {
        if (score >= 85 && score <= 100) {
            return 4.0;
        } else if (score >= 70 && score < 85) {
            return 3.0;
        } else if (score >= 50 && score < 70) {
            return 2.0;
        } else if (score >= 25 && score < 50) {
            return 1.0;
        } else {
            return 0.0;
        }
    }


   
}