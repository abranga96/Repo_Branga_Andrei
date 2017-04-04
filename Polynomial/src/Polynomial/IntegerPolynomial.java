package Polynomial;

import java.util.SortedSet;

/**
 * Created by abran on 06.03.2017.
 * Integer polynomial
 */
public class IntegerPolynomial extends Polynomial
{
    SortedSet<IntegerMonom> monomList;

    public IntegerPolynomial()
    {
        super();
        this.monomList=null;
    }

    public IntegerPolynomial(SortedSet<IntegerMonom> monomSortedSet)
    {
        this.monomList=monomSortedSet;
    }

    @Override
    public String toString() {
        String poly="";
        boolean first=true;
        if(isZero())
        {
            return "0";
        }
        for (Monom mon:monomList
                ) {
            poly=poly+mon.toString(first);
            if(first)
            {
                first=false;
            }

        }
        return poly;
    }


    public void commonFactor()
    {
        /**
         * As the name suggests
         */
        IntegerMonom[] array=new IntegerMonom[100];
        int length=0;
        for (IntegerMonom m:monomList
             ) {
            array[length]=m;
            length++;

        }
        monomList.clear();
        boolean cont=true;
        while(cont)
        {
            cont=false;
            int i=0;
            while(i<length-1)
            {
                if(array[i].getDegree().equals(array[i+1].getDegree()))
                {
                    array[i] = IntegerMonom.commonFactor(array[i], array[i + 1]);

                    for (int j = i + 1; j < length - 1; j++)
                    {
                        array[j] = array[j + 1];
                    }
                    length--;
                    cont=true;
                }


                i++;
            }
        }

        for(int i=0; i<length; i++)
        {
            monomList.add(array[i]);
        }
    }


    public SortedSet<IntegerMonom> getMonomList() {
        return monomList;
    }

    public void setMonomList(SortedSet<IntegerMonom> monomList) {
        this.monomList = monomList;
    }

    public int getPolynomialDegree()
    {
        return monomList.first().getDegree();
    }

    private boolean isZero()
    {
        /**
         * tells wether the polynomial is equal to zero or not
         */
        for (IntegerMonom  m:monomList
                ) {
            if(m.getCoefficient().intValue()!=0)
            {
                return false;
            }
        }
        return true;
    }
}
