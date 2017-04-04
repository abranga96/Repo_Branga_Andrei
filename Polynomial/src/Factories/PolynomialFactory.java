package Factories;

import Parsers.PolynomialParser;
import Polynomial.*;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abran on 06.03.2017.
 *
 * Polynomial factories
 */
public class PolynomialFactory {

    public  static IntegerPolynomial buildIntegerPolynomialFromString(String input)
    {/**
        Creates an instance of IntegerPolynomial from an corectly formatted input string
    */
        SortedSet<IntegerMonom> monomList= new TreeSet<IntegerMonom>();
        String[] tokens= PolynomialParser.getPolynomialTokens(input);
        for (int i=0; i<tokens.length; i++)
        {
            monomList.add(PolynomialParser.getMonomFromToken(tokens[i]));
        }


        IntegerPolynomial pol=new IntegerPolynomial(monomList);
        pol.commonFactor();
        return pol;
    }

    public static  RealPolynomial buildRealPolynomialFromString(String input)
    {
        /**
         Creates an instance of RealPolynomial from an corectly formatted input string
         */
        SortedSet<RealMonom> monomList= new TreeSet<RealMonom>();
        String[] tokens= PolynomialParser.getPolynomialTokens(input);
        for (int i=0; i<tokens.length; i++)
        {
            monomList.add(PolynomialParser.getRealMonomFromToken(tokens[i]));
        }

        RealPolynomial pol=new RealPolynomial(monomList);
        pol.commonFactor();
        return pol;
    }
}
