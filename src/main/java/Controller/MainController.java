package Controller;



import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainController extends Controller {
    @FXML
    AnchorPane replaceableAnchor;

    public MainController() throws SQLException {
    }

    @FXML
    public void initialize() {
        this.windowService.replaceableAnchor = this.replaceableAnchor;
    }
}