package src;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboard implements Initializable {

    @FXML
    private Button bill_add_button;

    @FXML
    private Button bill_button;

    @FXML
    private Button bill_clear_button;

    @FXML
    private Button bill_delete_button;

    @FXML
    private AnchorPane bill_form;

    @FXML
    private TextField bill_insurance;

    @FXML
    private TableColumn<?, ?> bill_insurance_col;

    @FXML
    private TextField bill_medicine;

    @FXML
    private TableColumn<?, ?> bill_medicine_col;

    @FXML
    private TableColumn<?, ?> bill_no_col;

    @FXML
    private TableColumn<?, ?> bill_numberofday_col;

    @FXML
    private TextField bill_operation;

    @FXML
    private TableColumn<?, ?> bill_operation_col;

    @FXML
    private TextField bill_search;

    @FXML
    private TableView<?> bill_table;

    @FXML
    private Button bill_update_button;

    @FXML
    private Button close;

    @FXML
    private Button doctor_add_button;

    @FXML
    private TextField doctor_age;

    @FXML
    private Button doctor_button;

    @FXML
    private Button doctor_clear_button;

    @FXML
    private TableColumn<?, ?> doctor_col_age;

    @FXML
    private TableColumn<?, ?> doctor_col_id;

    @FXML
    private TableColumn<?, ?> doctor_col_name;

    @FXML
    private TableColumn<?, ?> doctor_col_password;

    @FXML
    private TableColumn<?, ?> doctor_col_username;

    @FXML
    private Button doctor_delete_button;

    @FXML
    private AnchorPane doctor_form;

    @FXML
    private TextField doctor_name;

    @FXML
    private TextField doctor_password;

    @FXML
    private TextField doctor_search;

    @FXML
    private TableView<?> doctor_table;

    @FXML
    private Button doctor_update_button;

    @FXML
    private TextField doctor_username;

    @FXML
    private StackedBarChart<?, ?> gender;

    @FXML
    private Label gender_difference;

    @FXML
    private Button home_button;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private Button patient_add_button;

    @FXML
    private TextField patient_address;

    @FXML
    private TableColumn<?, ?> patient_address_col;

    @FXML
    private TextField patient_age;

    @FXML
    private TableColumn<?, ?> patient_age_col;

    @FXML
    private TextField patient_bill;

    @FXML
    private TableColumn<?, ?> patient_bill_col;

    @FXML
    private Button patient_clear_button;

    @FXML
    private DatePicker patient_dateofadmission;

    @FXML
    private TableColumn<?, ?> patient_dateofadmission_col;

    @FXML
    private DatePicker patient_dateofdischarge;

    @FXML
    private TableColumn<?, ?> patient_dateofdischarge_col;

    @FXML
    private Button patient_delete_button;

    @FXML
    private AnchorPane patient_form;

    @FXML
    private ComboBox<?> patient_gender;

    @FXML
    private TableColumn<?, ?> patient_gender_col;

    @FXML
    private TextField patient_id;

    @FXML
    private TableColumn<?, ?> patient_id_col;

    @FXML
    private TextField patient_insurancenumber;

    @FXML
    private TableColumn<?, ?> patient_insurancenumber_col;

    @FXML
    private TextField patient_name;

    @FXML
    private TableColumn<?, ?> patient_name_col;

    @FXML
    private TextField patient_phonenumber;

    @FXML
    private TableColumn<?, ?> patient_phonenumber_col;

    @FXML
    private TextField patient_search;

    @FXML
    private TableView<?> patient_table;

    @FXML
    private Button patient_update_button;

    @FXML
    private Button patients_button;

    @FXML
    private BarChart<?, ?> revenue;

    @FXML
    private Label total_patients;

    @FXML
    private Label total_revenue;

    @FXML
    private Label user;

    private double x;
    private double y;

    public void close() {
        System.exit(0);
    }

    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeForm(ActionEvent event) {
        if (event.getSource() == home_button) {
            home_form.setVisible(true);
            patient_form.setVisible(false);
            bill_form.setVisible(false);
            doctor_form.setVisible(false);

            home_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            patients_button.setStyle("-fx-background-color:transparent");
            bill_button.setStyle("-fx-background-color:transparent");
            doctor_button.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == patients_button) {
            home_form.setVisible(false);
            patient_form.setVisible(true);
            bill_form.setVisible(false);
            doctor_form.setVisible(false);

            home_button.setStyle("-fx-background-color:transparent");
            patients_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            bill_button.setStyle("-fx-background-color:transparent");
            doctor_button.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == bill_button) {
            home_form.setVisible(false);
            patient_form.setVisible(false);
            bill_form.setVisible(true);
            doctor_form.setVisible(false);

            home_button.setStyle("-fx-background-color:transparent");
            patients_button.setStyle("-fx-background-color:transparent");
            bill_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            doctor_button.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == doctor_button) {
            home_form.setVisible(false);
            patient_form.setVisible(false);
            bill_form.setVisible(false);
            doctor_form.setVisible(true);

            home_button.setStyle("-fx-background-color:transparent");
            patients_button.setStyle("-fx-background-color:transparent");
            bill_button.setStyle("-fx-background-color:transparent");
            doctor_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");

        }

    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user.setText(App.userName);
    }

}
