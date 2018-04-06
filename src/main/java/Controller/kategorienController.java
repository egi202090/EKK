package Controller;

import Helper.DBconnection;
import Helper.WindowService;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class kategorienController {
    protected Connection connection = DBconnection.getInstance();
    protected WindowService windowService = WindowService.getInstance();

    public kategorienController() throws SQLException {
    }

    @FXML
    public void loadPage(String fielname) throws IOException {
        this.windowService.loadFile(fielname);
    }

    @FXML
    void kategorienKartenLoad() throws IOException {
        this.loadPage("FXML/kategorienKarten.fxml");

    }

}
