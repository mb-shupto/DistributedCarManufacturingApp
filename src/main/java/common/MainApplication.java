package common;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/supto/manageDefects.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Car Manufacturing App");
        primaryStage.setScene(new Scene(root, 600, 525));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}