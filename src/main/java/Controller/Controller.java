package Controller;

import Helper.DBconnection;
import Helper.WindowService;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller {
    protected Connection connection = DBconnection.getInstance();
    protected WindowService windowService = WindowService.getInstance();

    public Controller() throws SQLException {
    }

    @FXML
    public void loadPage(String fielname) throws IOException {
        this.windowService.loadFile(fielname);
    }

    @FXML
    void loginLoad() throws IOException {
        this.loadPage("FXML/login.fxml");
    }

    @FXML
    void kategorienLoad() throws IOException {
        this.loadPage("FXML/kategorien.fxml");

    }

    @FXML
    public void testButton()throws IOException{
        System.out.println("hallo");
    }
}
