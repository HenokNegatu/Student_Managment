import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainSceneController {

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
