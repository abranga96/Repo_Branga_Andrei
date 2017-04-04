import com.intellij.ide.projectWizard.ModuleTypeCategory;

/**
 * Created by abran on 18.12.2016.
 */
public class Operation
{
    private Character sign;
    private double operand1;
    private double operand2;


    public Operation()
    {
        this.operand1=0;
        this.operand2=0;
        this.sign=null;
    }

    public void setOperand1(double operand1)
    {
        this.operand1=operand1;
    }

    public void setOperand2(double operand2)
    {
        this.operand2=operand2;
    }

    public void setSign(Character c)
    {
        sign=c;
    }

    public double computeResult()
    {
        if (this.sign==null)
        {
            return 0;
        }

        switch(sign)
        {
            case '+': return operand1+operand2;
            case '-': return operand1-operand2;
            case '*':return operand2*operand1;
            case '/':return operand1/operand2;
            case 'p':return Math.pow(operand1,operand2);
            case 'r':return Math.sqrt(operand1);
            default:return 0;
        }
    }

    public String opString()
    {
        String str=String.valueOf(operand1);
        str+=String.valueOf(sign);
        str+=String.valueOf(operand2);
        return str;
    }

    public void reset()
    {
        this.operand1=0;
        this.operand2=0;
        this.sign=null;
    }
}
