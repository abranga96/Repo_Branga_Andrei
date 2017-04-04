package Frame;

/**
 The Main class
 Inside the FXML Scene is initialized
 All the program functionality is inside Controller Class
 */

import Factories.PolynomialFactory;
import Parsers.PolynomialParser;
import Polynomial.IntegerMonom;
import Polynomial.IntegerPolynomial;
import Polynomial.RealMonom;
import Polynomial.RealPolynomial;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class Main extends Application {

    @FXML
    private ImageView img;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Frame.fxml"));
        primaryStage.setTitle("Polynomial Operation Calculator");
        primaryStage.setScene(new Scene(root, 700, 546));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
