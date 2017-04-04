package Polynomial;

/**
 * Created by abran on 05.03.2017.
 * the class represents an integer monom
 */
public class IntegerMonom extends Monom
{
    public IntegerMonom()
    {
        super();
    }



    public IntegerMonom(Integer coefficient,Integer degree)
    {
        this.degree=Integer.valueOf(degree);
        this.coefficient=Integer.valueOf(coefficient);
    }

    public static IntegerMonom commonFactor(IntegerMonom a, IntegerMonom b) {
        /**
         if two monoms have the same degree the method joins them (addition)
         */
        if (a.getDegree().equals(b.getDegree()))
        {
            return new IntegerMonom(Integer.valueOf(a.getCoefficient().intValue()+b.getCoefficient().intValue()),a.getDegree());
        }
        return null;
    }

    public static IntegerMonom multiply(IntegerMonom a,IntegerMonom b)
    /**
     multiplies two integer monoms
     */
    {
        return new IntegerMonom(Integer.valueOf(a.coefficient.intValue()*b.coefficient.intValue()),Integer.valueOf(a.degree.intValue()+b.degree.intValue()));
    }

}
