package Polynomial;

import Factories.PolynomialFactory;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abran on 05.03.2017.
 * Polynomial parent class
 * Here the polynomial operations are defined
 */
public abstract class Polynomial
{
    public Polynomial(){};
    
    @Override
    public abstract String toString();

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


    public static RealPolynomial integrate(IntegerPolynomial poly)
    {

        SortedSet<RealMonom> set=new TreeSet<RealMonom>();

        for (IntegerMonom im:poly.getMonomList()
             ) {
            set.add(new RealMonom(Double.valueOf(im.getCoefficient().intValue()),Integer.valueOf(im.getDegree().intValue())));
        }

        for (RealMonom m: set
                ) {
            if(m.getDegree().equals(Integer.valueOf(0)))
            {
                m.setDegree(Integer.valueOf(1));
            }
            else
            {
                m.setDegree(Integer.valueOf(m.getDegree()+Integer.valueOf(1)));
                m.setCoefficient(Double.valueOf(m.getCoefficient().doubleValue()/m.getDegree().doubleValue()));
            }

        }
        return new RealPolynomial(set);
    }

    public static IntegerPolynomial addition(IntegerPolynomial poly1,IntegerPolynomial poly2)
    {
        SortedSet<IntegerMonom> list=new TreeSet<IntegerMonom>();

        for (IntegerMonom m:poly1.getMonomList()
             ) {
            list.add(m);

        }
        for (IntegerMonom m:poly2.getMonomList()
                ) {
            list.add(m);

        }

        IntegerPolynomial pol= new IntegerPolynomial(list);
        pol.commonFactor();
        return pol;
    }

    public static IntegerPolynomial subtraction(IntegerPolynomial poly1,IntegerPolynomial poly2)
    {
        SortedSet<IntegerMonom> list=new TreeSet<IntegerMonom>();

        for (IntegerMonom m:poly1.getMonomList()
                ) {
            list.add(m);

        }
        for (IntegerMonom m:poly2.getMonomList()
                ) {
            m.setCoefficient(Integer.valueOf(m.getCoefficient().intValue()*(-1)));
            list.add(m);

        }

        IntegerPolynomial pol= new IntegerPolynomial(list);
        pol.commonFactor();
        return pol;
    }

    public static RealPolynomial subtraction(RealPolynomial poly1,RealPolynomial poly2)
    {
        SortedSet<RealMonom> list=new TreeSet<RealMonom>();

        for (RealMonom m:poly1.getMonomList()
                ) {
            list.add(m);

        }
        for (RealMonom m:poly2.getMonomList()
                ) {
            m.setCoefficient(Double.valueOf(m.getCoefficient().doubleValue()*(-1)));
            list.add(m);

        }

        RealPolynomial pol= new RealPolynomial(list);
        pol.commonFactor();
        return pol;
    }
    
    public static IntegerPolynomial multiply(IntegerPolynomial poly1,IntegerPolynomial poly2)
    {
        IntegerMonom[] list1=new IntegerMonom[100];
        IntegerMonom[] list2=new IntegerMonom[100];
        int len1=0;
        int len2=0;

        for (IntegerMonom m:poly1.getMonomList()
             ) {
            list1[len1]=m;
            len1++;
        }

        for (IntegerMonom m:poly2.getMonomList()
                ) {
            list2[len2]=m;
            len2++;
        }

        SortedSet<IntegerMonom> set=new TreeSet<IntegerMonom>();

        for (int i=0; i<len1; i++)
        {
            for (int j=0; j<len2; j++)
            {
                set.add(IntegerMonom.multiply(list1[i],list2[j]));
            }
        }

        IntegerPolynomial pol=new IntegerPolynomial(set);
        pol.commonFactor();
        return pol;
    }

    public static RealPolynomial multiply(RealPolynomial poly1,RealPolynomial poly2)
    {
        RealMonom[] list1=new RealMonom[100];
        RealMonom[] list2=new RealMonom[100];
        int len1=0;
        int len2=0;

        for (RealMonom m:poly1.getMonomList()
                ) {
            list1[len1]=m;
            len1++;
        }

        for (RealMonom m:poly2.getMonomList()
                ) {
            list2[len2]=m;
            len2++;
        }

        SortedSet<RealMonom> set=new TreeSet<RealMonom>();

        for (int i=0; i<len1; i++)
        {
            for (int j=0; j<len2; j++)
            {
                set.add(RealMonom.multiply(list1[i],list2[j]));
            }
        }

        RealPolynomial pol=new RealPolynomial(set);
        pol.commonFactor();
        return pol;
    }

    public static RealPolynomial getRealPolyFromInteger(IntegerPolynomial poly)
    {
        /**
         * returns an real polynomial from integer polynomial
         */
        SortedSet<RealMonom> set=new TreeSet<RealMonom>();

        for (IntegerMonom m:poly.getMonomList()
             ) {
            set.add(new RealMonom(Double.valueOf(m.getCoefficient().intValue()),Integer.valueOf(m.getDegree().intValue())));

        }
        return new RealPolynomial(set);
    }


    public static RealPolynomial[] divide(IntegerPolynomial p1,IntegerPolynomial p2) throws Exception {
        RealPolynomial[] polQandR = new RealPolynomial[2];

        RealPolynomial poly1=getRealPolyFromInteger(p1);
        RealPolynomial poly2=getRealPolyFromInteger(p2);

        SortedSet<RealMonom> set=new TreeSet<RealMonom>();
        set.add(new RealMonom(Double.valueOf(0),Integer.valueOf(0)));
        polQandR[1]=new RealPolynomial(set);
        polQandR[0]=new RealPolynomial(set);
        set.clear();


        if(poly2.getIsZero())
        {
            throw new Exception("Error: Division by 0 !");
        }
        else
        {
                if(poly2.getPolynomialDegree()>poly1.getPolynomialDegree())
                {
                    polQandR[1]=poly1;
                    return polQandR;
                }
                else
                {
                    //****************HERE THE DIVISION ALGORITHM*******************************
                    SortedSet<RealMonom> quotient=new TreeSet<RealMonom>();
                    SortedSet<RealMonom> remainder;

                    SortedSet<RealMonom> aux=new TreeSet<RealMonom>();

                    while((poly1.getPolynomialDegree()>=poly2.getPolynomialDegree()) &&(poly1.getIsZero()==false))
                    {


                        RealMonom term=RealMonom.divide(poly1.getMonomList().first(),poly2.getMonomList().first());
                        quotient.add(term);
                        aux.clear();
                        aux.add(term);
                        RealPolynomial auxpoly=new RealPolynomial(aux);
                        RealPolynomial desc=poly1;
                        RealPolynomial sca=Polynomial.multiply(poly2,auxpoly);
                        poly1=Polynomial.subtraction(desc,sca);
                        poly1.simplify();

                    }
                    remainder=poly1.getMonomList();
                    polQandR[0]=new RealPolynomial(quotient);
                    polQandR[1]=new RealPolynomial(remainder);
                    //************************END************************************************
                }


        }

        return polQandR;
    }
}
