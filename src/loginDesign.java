package src;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class loginDesign {

    @FXML
    private Button close;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginForm;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    public void close() {
        System.exit(0);
    }
}
