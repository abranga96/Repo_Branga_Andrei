/**
 * Created by abran on 18.12.2016.
 */
public class Calculator
{

    public Screen screen=new Screen();
    private Operation operation=new Operation();


    public Calculator()
    {}


    public void setOperand1(double operand1)
    {
        operation.setOperand1(operand1);
    }

    public void setOperand2(double operand2)
    {
        operation.setOperand2(operand2);
    }

    public void setSign(Character c)
    {
        operation.setSign(c);
    }


    public void getSum()
    {
        screen.setValue(operation.computeResult());
        operation.setSign('+');
    }

    public void getSubct()
    {
        screen.setValue(operation.computeResult());
        operation.setSign('-');
    }

    public void getMult()
    {
        screen.setValue(operation.computeResult());
        operation.setSign('*');
    }

    public void getDiv()
    {
        screen.setValue(operation.computeResult());
        operation.setSign('/');
    }

    public void getPower()
    {
        screen.setValue(operation.computeResult());
        operation.setSign('p');
    }

    public void getRad()
    {
        screen.setValue(operation.computeResult());
        operation.setSign('r');
    }

    public void equal()
    {
        screen.updateScreen(String.valueOf(operation.computeResult()),operation.opString());
    }

    public void delete()
    {
       operation.reset();
        screen.updateScreen("","");
    }
}
