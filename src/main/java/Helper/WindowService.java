package Helper;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class WindowService {
    private static WindowService ourInstance = new WindowService();
    public AnchorPane replaceableAnchor;

    public static WindowService getInstance() {
        return ourInstance;
    }

    private WindowService() {
    }

    public void loadFile(String fileName) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getClassLoader().getResource(fileName));
        this.replaceableAnchor.getChildren().clear();
        this.replaceableAnchor.getChildren().add(root);

    }
}

