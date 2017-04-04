package Parsers;


import Polynomial.IntegerMonom;
import Polynomial.RealMonom;

/**
 * Created by abran on 05.03.2017.
 * This is used for parsing an correct input string in order to build the polynomials and to offer a correct way of describing
 * the polynomials
 * The methods reformat the input string in order not to treat every input case differently
 */
public class PolynomialParser
{
    public static String[] getPolynomialTokens(String input)
    {/**
     the tokens represent monoms
     for example: a*x^b
     it returns a string of monom tokens
     */
        String replace=input;
        if(replace.charAt(0)=='x')
        {
            replace="1*"+replace;
        }
        replace=replace.replace("-x","-1*x");
        replace=replace.replace("+x","+1*x");
        replace=replace.replace("-","+-");
        String[] tokens=replace.split("\\+");

        return tokens;
    }

    public static IntegerMonom getMonomFromToken(String token)
    /**
     parses the monom token and builds an integer monom from token
     */
    {   String replace=token;
        if (token.length()==0)
        {
            return new IntegerMonom(Integer.valueOf(0),Integer.valueOf(0));
        }
        if(token.length()!=0 && replace.charAt(0)=='x')
        {
            replace="1*"+replace;
        }
        if(token.length()!=0 && replace.charAt(replace.length()-1)=='x')
        {
            replace=replace+"^1";
        }
        replace=replace.replace("-x","-1*x");
        replace=replace.replace("+x","+1*x");
        replace=replace.replace("*x^"," ");
        replace=replace.replace("*x"," ");
        String[] values=replace.split(" ");
        if(values.length==2)
        {
            return new IntegerMonom(Integer.valueOf(values[0]),Integer.valueOf(values[1]));
        }
        return new IntegerMonom(Integer.valueOf(values[0]),Integer.valueOf(0));
    }

    public static RealMonom getRealMonomFromToken(String token)
    /**
     parses the monom token and builds an real monom from token
     */
    {   String replace=token;
        if (token.length()==0)
        {
            return new RealMonom(Double.valueOf(0),Integer.valueOf(0));
        }
        if(token.length()!=0 && replace.charAt(0)=='x')
        {
            replace="1*"+replace;
        }
        if(token.length()!=0 && replace.charAt(replace.length()-1)=='x')
        {
            replace=replace+"^1";
        }
        replace=replace.replace("-x","-1*x");
        replace=replace.replace("+x","+1*x");
        replace=replace.replace("*x^"," ");
        replace=replace.replace("*x"," ");
        String[] values=replace.split(" ");
        if(values.length==2)
        {
            return new RealMonom(Double.valueOf(values[0]),Integer.valueOf(values[1]));
        }
        return new RealMonom(Double.valueOf(values[0]),Integer.valueOf(0));
    }
}
