package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class login {

    @FXML
    private Button Signup;

    @FXML
    private Button close;

    @FXML
    private Button closeSignup;

    @FXML
    private Hyperlink createAccount;

    @FXML
    private Hyperlink loginAccount;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginform;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordSignup;

    @FXML
    private AnchorPane signupform;

    @FXML
    private TextField username;

    @FXML
    private TextField usernameSignup;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void loginAdmin() {
        String sql = "SELECT * FROM adminlogin WHERE username = ? and password = ?";

        connect = database.connectDatabase();

        try {
            Alert alert;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill your Password or Username");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();

                    loginButton.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username or Password! Please try again");
                    alert.showAndWait();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeForm(ActionEvent event) {

        if (event.getSource() == createAccount) {

            signupform.setVisible(true);
            loginform.setVisible(false);

            usernameSignup.setText("");
            passwordSignup.setText("");

        } else if (event.getSource() == loginAccount) {

            loginform.setVisible(true);
            signupform.setVisible(false);

            username.setText("");
            password.setText("");
        }

    }

    public void close() {
        System.exit(0);
    }
}
