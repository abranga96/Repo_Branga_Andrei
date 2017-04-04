package Operations;

import Polynomial.IntegerMonom;
import Polynomial.IntegerPolynomial;

import java.util.SortedSet;

/**
 * Created by abran on 06.03.2017.
 */
public class PolynomialOperations
{
    public static IntegerPolynomial derivative(IntegerPolynomial poly)
    {
        SortedSet<IntegerMonom> set=poly.getMonomList();
        for (IntegerMonom m: set
             ) {
            if(m.getDegree().equals(Integer.valueOf(0)))
            {
                m.setCoefficient(Integer.valueOf(0));
            }
            else
            {
                m.setCoefficient(Integer.valueOf(m.getCoefficient().intValue()*m.getDegree().intValue()));
                m.setDegree(Integer.valueOf(m.getDegree().intValue()-1));
            }

        }
        return new IntegerPolynomial(set);
    }
}
