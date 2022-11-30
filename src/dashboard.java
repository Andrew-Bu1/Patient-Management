package src;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class dashboard implements Initializable {

    @FXML
    private Button doctors;

    @FXML
    private Button home;

    @FXML
    private Button patients;

    @FXML
    private Button room;

    @FXML
    private Label user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user.setText(App.userName);
    }

}
