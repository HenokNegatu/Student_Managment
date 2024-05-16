import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

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
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);){
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setString(1, username.getText());

            ResultSet res = stmt.executeQuery();
            String password = null;
            while (res.next()) {
                password = res.getString("password");
            }

            if (passwd.getText().equals(password)){
                System.out.println("you can login");
                root = FXMLLoader.load(getClass().getResource("./MainDashboardScene.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); 
            }else{ System.out.println("incorrect credential!");}

    }catch(Exception e){
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
    private ComboBox<?> course;

    @FXML
    private TextField creditHr;

    @FXML
    private Button deleteBtn;

    @FXML
    private ComboBox<?> department;

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
    private ComboBox<?> gender;

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
    private ComboBox<?> semister;

    @FXML
    private TableColumn<?, ?> semisterCol;

    @FXML
    private TableView<?> studentInfoTable;

    @FXML
    private ComboBox<?> year;

    @FXML
    private TableColumn<?, ?> yearCol;

    @FXML
    void addCourse(ActionEvent event) {

    }

    @FXML
    void addStudentInfo(ActionEvent event) {

    }

    @FXML
    void deleteStudentInfo(ActionEvent event) {

    }

    @FXML
    void editStudentInfo(ActionEvent event) {

    }
}