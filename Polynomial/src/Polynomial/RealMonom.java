package Polynomial;

/**
 * Created by abran on 05.03.2017.
 * Real Monom
 * Two operations defined : multiply and divide
 */
public class RealMonom extends Monom
{
    public RealMonom()
    {
        super();
    }

    public static RealMonom commonFactor(RealMonom a, RealMonom b) {
        if (a.getDegree().equals(b.getDegree()))
        {
            return new RealMonom(Double.valueOf(a.getCoefficient().doubleValue()+b.getCoefficient().doubleValue()),a.getDegree());
        }
        return null;
    }

    public RealMonom(Double coefficient,Integer degree)
    {
        this.coefficient=Double.valueOf(coefficient);
        this.degree=Integer.valueOf(degree);
    }

    public static RealMonom divide(RealMonom m1,RealMonom m2)
    {
        return new RealMonom(Double.valueOf(m1.getCoefficient().doubleValue()/m2.getCoefficient().doubleValue()),Integer.valueOf(m1.getDegree().intValue()-m2.getDegree().intValue()));
    }

    public static RealMonom multiply(RealMonom a,RealMonom b)
    {
        return new RealMonom(Double.valueOf(a.coefficient.doubleValue()*b.coefficient.doubleValue()),Integer.valueOf(a.degree.intValue()+b.degree.intValue()));
    }

}
