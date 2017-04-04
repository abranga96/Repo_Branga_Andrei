import com.intellij.psi.PsiReferenceBase;

public class Main {

    public static void main(String[] args)
    {
        int[] a={1,3,4,4};
        int[] b={1,5,3};
        Polynomial pa=new Polynomial(a);
        Polynomial pb=new Polynomial(b);

        Polynomial mult = Polynomial.multiply(pa,pb);
        mult.displayPolynomial();
    }
}
