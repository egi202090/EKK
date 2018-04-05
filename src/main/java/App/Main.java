package App;

import Helper.DBseed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/sample.fxml"));
        primaryStage.setTitle("Egzons Kartei Karten - EKK");
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add("../Assets/css/styles.css");
        primaryStage.setScene(scene);
        DBseed.DBtables();
        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }
}
