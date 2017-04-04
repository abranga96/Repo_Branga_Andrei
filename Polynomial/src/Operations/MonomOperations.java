package Operations;

import Polynomial.IntegerMonom;

/**
 * Created by abran on 06.03.2017.
 */
public class MonomOperations {
    public static IntegerMonom commonFactor(IntegerMonom a, IntegerMonom b) {
        if (a.getDegree().equals(b.getDegree()))
        {
            return new IntegerMonom(Integer.valueOf(a.getCoefficient().intValue()+b.getCoefficient().intValue()),a.getDegree());
        }
        return null;
    }
}
