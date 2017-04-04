import Factories.PolynomialFactory;
import Parsers.PolynomialParser;
import Polynomial.IntegerMonom;
import Polynomial.IntegerPolynomial;
import Polynomial.RealMonom;
import org.junit.jupiter.api.Test;

/**
 * Created by abran on 11.03.2017.
 */
public class TestSuite {

    @Test
    public void TestGetPolynomialTokens()
    {
        System.out.println("Testing GetPolynomialTokens");
        String input="5*x^3+2*x^2+3*x+4*x^2+3";
        for (String s: PolynomialParser.getPolynomialTokens(input)
             ) {
            System.out.println(s.toString());
        }
    }

    @Test
    public void TestMonomToString()
    {
        RealMonom m=new RealMonom(Double.valueOf(2.34),Integer.valueOf(4));
        System.out.println("Testing monom toString 1: first; 2: not first");
        System.out.println(m.toString(true));
        System.out.println(m.toString(false));
    }

    @Test
    public void TestGetMonomFromToken()
    {
        IntegerMonom m=PolynomialParser.getMonomFromToken("2*x^4");
        System.out.println(m.toString(false) );
    }

    @Test
    public void TestGetRealMonomFromToken()
    {
        RealMonom m=PolynomialParser.getRealMonomFromToken("2*x^4");
        System.out.println(m.toString(false) );
    }

    @Test
    public void TestbuildIntegerPolynomialFromString()
    {
        System.out.println("Testing the build of IntegerPolynomial:");
        System.out.println("First case:");
        IntegerPolynomial pol= PolynomialFactory.buildIntegerPolynomialFromString("5*x^3+2*x^2+3*x+4*x^2+3");
        System.out.println(pol.toString());

      /*
        System.out.println("Second case:");
        pol= PolynomialFactory.buildIntegerPolynomialFromString("5x^2+3x+5");
        System.out.println(pol.toString());
      */
    }
}
