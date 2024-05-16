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
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

    @FXML
    private TableColumn<?, ?> departmentCol;

    @FXML
    private TextField ects;

    @FXML
    private Button editBtn;

    @FXML
    private TextField firstname;

    @FXML
    private TableColumn<?, ?> firstnameCol;

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
       }catch(Exception e){
        System.out.println(e);
       }

    }

    @FXML
    private ComboBox<String> gender;
    initialize();

    @FXML
    private DatePicker birthdate;

    @FXML
    private TextField email;

    @FXML
    private TableColumn<?, ?> genderCol;

    @FXML
    private TextField id;

    @FXML
    private TextField id2;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> idCol2;

    @FXML
    private TextField idDearchField;

    @FXML
    private TextField lastname;

    @FXML
    private TableColumn<?, ?> lastnameCol;

    @FXML
    private TextField phone;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TextField score;

    @FXML
    private Button search;

    @FXML
    private ComboBox<Integer> semister;

    @FXML
    private TableColumn<?, ?> semisterCol;

    @FXML
    private TableView<?> studentInfoTable;

    @FXML
    private ComboBox<Integer> year;

    @FXML
    private TableColumn<?, ?> yearCol;

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
}