package Polynomial;

/**
 * Created by abran on 05.03.2017.
 * Monom parent class
 */
public abstract class Monom implements Comparable<Monom>
{
    protected Number coefficient;
    protected Integer degree;

    public Monom()
    {
        this.coefficient=0;
        this.degree=0;
    }

    public String toString(boolean first) {
        if(coefficient.equals(0))
        {
            return "";
        }
        else
        {
            if (coefficient.doubleValue()<0)
            {
                if(first)
                {
                    return coefficient.toString()+"*x^"+degree.toString();
                }
                else
                {
                    return coefficient.toString()+"*x^"+degree.toString();
                }
            }
            else
            {
                if(first)
                {
                    return coefficient.toString()+"*x^"+degree.toString();
                }
                else
                {
                    return "+"+coefficient.toString()+"*x^"+degree.toString();
                }
            }
        }
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public int compareTo(Monom o)
    {
        if (this.degree.intValue()<o.getDegree().intValue())
        {
            return 1;
        }
        if (this.degree.intValue()>o.getDegree().intValue())
        {
            return -1;
        }
        return 1;
    }

}
