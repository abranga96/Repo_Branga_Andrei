import com.intellij.psi.PsiReferenceBase;

/**
 * Created by abran on 01.11.2016.
 */
public class Polynomial
{
    private int degree;
    private final int MIN_DEGREE=1;
    public int[] coefficients;

    public Polynomial(int[] coeff)
    {/**
     Automatically constructs the polynomial with the user's given parameter*/
        degree=coeff.length-1;
        coefficients=coeff;
    }

    public Polynomial()
    {
        degree=0;
    }

    public void constructPolynomial(int[] coeff)
    {
        degree=coeff.length-1;
        coefficients=coeff;
    }

    public void displayPolynomial()
    {
        if (degree>=MIN_DEGREE)
        {
            System.out.println("Degree: "+degree);
            for (int i=0; i<coefficients.length; i++)
            {
                if(i==coefficients.length-1)
                {
                    if (coefficients[i]<0)
                    {
                        System.out.print(coefficients[i]);
                    }
                    else
                    {
                        if (coefficients[i]>0)
                        {
                            System.out.print("+"+coefficients[i]);
                        }
                    }
                }
                else
                {
                    switch (coefficients[i])
                    {
                        case 0:break;
                        case 1:if (i==0)
                        {System.out.print("X^"+ (degree-i));}
                        else
                        {System.out.print("+X^"+ (degree-i));}
                            break;
                        case -1:System.out.print("-X^"+ (degree-i));
                            break;
                        default: if(coefficients[i]<0)
                        {
                            System.out.print(coefficients[i]+"X^"+ (degree-i));
                        }
                        else
                        {
                            if (i==0)
                            {
                                System.out.print(coefficients[i]+"X^"+ (degree-i));
                            }
                            else
                            {
                                System.out.print("+"+coefficients[i] + "X^" + (degree - i));
                            }
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("Polynomial has degree 0!.");
        }
        System.out.println();
    }

    public int getDegree()
    {
        return degree;
    }

    public void multiplyScal(int m)
    {
        if (m==0)
        {
            degree=0;
            return;
        }
        for (int i=0; i<coefficients.length; i++)
        {
            coefficients[i]=coefficients[i]*m;
        }
    }

    public void  evalPoly(double n)
    {
        double res=0;
        if (degree==0)
        {
            System.out.println("Evaluating the polynomial with the value "+n+" we obtain the result: "+res);
            return;
        }
        else
        {
            for (int i=0; i<coefficients.length; i++)
            {
                res=  (res+(coefficients[i]*(Math.pow(n,coefficients.length-i))));
            }
        }
        System.out.println("Evaluating the polynomial with the value "+n+" we obtain the result: "+res);
    }

    public void addPoly(Polynomial q)
    {
        Polynomial p=new Polynomial(q.coefficients.clone());
        if (p.getDegree()<=degree)
        {
            int k=coefficients.length-1;
            for (int i=p.coefficients.length-1; i>=0; i--)
            {
                coefficients[k]=coefficients[k]+p.coefficients[i];
                k--;
            }
        }
        else
        {
            int w=p.coefficients.length-1;
            for (int i=coefficients.length-1; i>=0; i--)
            {
                p.coefficients[w]=p.coefficients[w]+coefficients[i];
                w--;
            }
            coefficients=p.coefficients;
            degree=p.degree;
        }
    }

    public void subtPoly(Polynomial q)
    {
        Polynomial p=new Polynomial(q.coefficients.clone());
        if (p.getDegree()<=degree)
        {
            int k=coefficients.length-1;
            for (int i=p.coefficients.length-1; i>=0; i--)
            {
                coefficients[k]=coefficients[k]-p.coefficients[i];
                k--;
            }
            int ok=1;
            for (int j=0; j<coefficients.length-1; j++)
            {
                if (coefficients[j]!=0)
                {
                    ok=0;
                    break;
                }
            }
            if (ok==1)
            {
                degree=0;
            }
        }
        else
        {
            int w=p.coefficients.length-1;
            for (int i=coefficients.length-1; i>=0; i--)
            {
                p.coefficients[w]=coefficients[i]-p.coefficients[w];
                w--;
            }
            int l=p.coefficients.length-coefficients.length;
            coefficients=p.coefficients;
            for (int i=0; i<l; i++)
            {
                coefficients[i]=coefficients[i]*(-1);
            }
            degree=p.degree;
        }
    }

    private static int[] reverse(int[] a)
    {
        int[] x = new int[a.length];
        int j=a.length-1;
        for (int i=0; i<a.length; i++)
        {
            x[i]=a[j];
            j--;
        }
        return x;
    }

    public static Polynomial multiply(Polynomial a,Polynomial b)
    {
        int[] newCoef=new int[a.getDegree()+b.getDegree()+1];
        for (int i=0; i<a.coefficients.length; i++)
        {
            for (int j=0; j<b.coefficients.length; j++)
            {
                newCoef[(a.getDegree()-i)+(b.getDegree()-j)]+=a.coefficients[i]*b.coefficients[j];
            }
        }
        newCoef=reverse(newCoef);
         Polynomial x = new Polynomial(newCoef);
        return x;
    }
}
