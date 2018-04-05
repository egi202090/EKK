package Controller;

import Helper.DBconnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    Statement stmt = DBconnection.getInstance().createStatement();

    @FXML
    private Text title;
    @FXML
    public Button login;
    @FXML
    public Button register;
    @FXML
    public Label benutzername;
    @FXML
    public TextField benutzerTF;
    @FXML
    public Label passwort;
    @FXML
    public TextField passwortTF;
    @FXML
    public VBox navigation;
    @FXML
    public Button home;
    @FXML
    public Button kategorie;

    public Controller() throws SQLException {
    }


    @FXML
    public void testButton(){
        System.out.println("hallo");
    }
}
