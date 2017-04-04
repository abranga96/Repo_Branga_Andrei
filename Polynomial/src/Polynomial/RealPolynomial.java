package Polynomial;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by abran on 07.03.2017.
 */
public class RealPolynomial
{
    SortedSet<RealMonom> monomList;

    public RealPolynomial()
    {
        super();
        this.monomList=null;
    }

    public RealPolynomial(SortedSet<RealMonom> monomSortedSet)
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
        RealMonom[] array=new RealMonom[100];
        int length=0;
        for (RealMonom m:monomList
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
                    array[i] = RealMonom.commonFactor(array[i], array[i + 1]);

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


    public SortedSet<RealMonom> getMonomList() {
        return monomList;
    }

    public void setMonomList(SortedSet<RealMonom> monomList) {
        this.monomList = monomList;
    }

    public int getPolynomialDegree()
    {
        if (monomList.isEmpty())
        {
            return 0;
        }
        return monomList.first().getDegree();
    }

    private boolean isZero()
    {
        for (RealMonom m:monomList
             ) {
            if(m.getCoefficient().doubleValue()!=0)
            {
                return false;
            }
        }
        return true;
    }

    public boolean getIsZero()
    {
        return isZero();
    }

    public void simplify()
    {
        if(monomList.isEmpty())
        {
            return;
        }
        SortedSet<RealMonom> setnew=new TreeSet<RealMonom>();
        for (RealMonom m:monomList
             ) {
            if(m.coefficient.doubleValue()!=Double.valueOf(0))
            {
                setnew.add(m);
            }

        }
        this.monomList=setnew;
    }
}
