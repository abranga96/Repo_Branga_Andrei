package Frame;
/**
 Controlls the FXML GUI Scene build using Scene Builder
 */

import Factories.PolynomialFactory;
import Polynomial.IntegerPolynomial;
import Polynomial.Polynomial;
import Polynomial.RealPolynomial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField pol1;

    @FXML
    private Button division;

    @FXML
    private TextArea text_area_2;

    @FXML
    private TextField pol2;

    @FXML
    private Button process;

    @FXML
    private Button derivate;

    @FXML
    private Button subtraction;

    @FXML
    private Button multiplication;

    @FXML
    private TextArea text_area1;

    @FXML
    private Button integrate;

    @FXML
    private Button addition;

    @FXML
    void process_polynomials(ActionEvent event) {
        text_area1.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1= PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            IntegerPolynomial poly2= PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            text_area1.appendText("Your first polynomial:\n"+poly1.toString()+"\n\n"+"Your second polynomial:\n"+poly2.toString());
        }

    }

    @FXML
    void addition(ActionEvent event) {
        text_area_2.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1=PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            poly1.commonFactor();
            IntegerPolynomial poly2=PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            poly2.commonFactor();

            IntegerPolynomial pol=Polynomial.addition(poly1,poly2);

            text_area_2.appendText("\n\n\nPolymomial 1 added to Polynomial 2 equals:\n\n"+pol.toString()+"\n\n\n");
            //new Alert(Alert.AlertType.INFORMATION, "Not yet implemented!").showAndWait();
        }

    }

    @FXML
    void subtraction(ActionEvent event) {
        text_area_2.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1=PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            poly1.commonFactor();
            IntegerPolynomial poly2=PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            poly2.commonFactor();

            IntegerPolynomial pol=Polynomial.subtraction(poly1,poly2);

            text_area_2.appendText("\n\n\nPolymomial 2 subtracted from Polynomial 1 equals:\n\n"+pol.toString()+"\n\n\n");
            //new Alert(Alert.AlertType.INFORMATION, "Not yet implemented!").showAndWait();
        }

    }

    @FXML
    void multiplication(ActionEvent event) {
        text_area_2.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1=PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            poly1.commonFactor();
            IntegerPolynomial poly2=PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            poly2.commonFactor();

            IntegerPolynomial pol=Polynomial.multiply(poly1,poly2);

            text_area_2.appendText("\n\n\nPolymomial 1 multiplied with Polynomial 2 equals:\n\n"+pol.toString()+"\n\n\n");
            //new Alert(Alert.AlertType.INFORMATION, "Not yet implemented!").showAndWait();
        }

    }

    @FXML
    void division(ActionEvent event) {
        text_area_2.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1=PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            poly1.commonFactor();
            IntegerPolynomial poly2=PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            poly2.commonFactor();

            try {
                text_area_2.appendText("\n\n\nPolymomial 1 divided by Polynomial 2 equals:\n"+Polynomial.divide(poly1,poly2)[0].toString()+"\n"+"..rest:    "+Polynomial.divide(poly1,poly2)[1].toString()+"\n\n\n");

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
            }
            //new Alert(Alert.AlertType.INFORMATION, "Not yet implemented!").showAndWait();
        }

    }

    @FXML
    void derivative(ActionEvent event) {
        text_area_2.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1=PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            poly1.commonFactor();
            IntegerPolynomial poly2=PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            poly2.commonFactor();

            IntegerPolynomial polyder1=Polynomial.derivative(poly1);
            IntegerPolynomial polyder2=Polynomial.derivative(poly2);

            text_area_2.appendText("\n\n\n"+"First polynomial derivative:\n"+polyder1.toString()+"\n\n\n\n"+
            "Second polynomial derivative:\n"+polyder2.toString()+"\n");

           // new Alert(Alert.AlertType.INFORMATION, "Not yet implemented!").showAndWait();
        }

    }

    @FXML
    void integrate(ActionEvent event) {
        text_area_2.clear();
        if(pol1.getText().equals("") || pol2.getText().equals(""))
        {
            new Alert(Alert.AlertType.INFORMATION, "Please insert both polynomials according to the guidelines!").showAndWait();
        }
        else
        {
            IntegerPolynomial poly1=PolynomialFactory.buildIntegerPolynomialFromString(pol1.getText());
            poly1.commonFactor();
            IntegerPolynomial poly2=PolynomialFactory.buildIntegerPolynomialFromString(pol2.getText());
            poly2.commonFactor();


            RealPolynomial polyint1=Polynomial.integrate(poly1);
            RealPolynomial polyint2=Polynomial.integrate(poly2);

            text_area_2.appendText("\n\n\n"+"First polynomial integrated:\n"+polyint1.toString()+"\n\n\n\n"+
                    "Second polynomial integrated:\n"+polyint2.toString()+"\n");

            /*new Alert(Alert.AlertType.INFORMATION, "Not yet implemented!").showAndWait();*/
        }

    }

}
