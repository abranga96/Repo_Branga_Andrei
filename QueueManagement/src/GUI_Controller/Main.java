package GUI_Controller;

import Logger.LoggerManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalTime;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Queue management system simulator");
        primaryStage.setScene(new Scene(root, 768, 686));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);



    }
}
