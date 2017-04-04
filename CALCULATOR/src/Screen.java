/**
 * Created by abran on 18.12.2016.
 */
public class Screen
{
    private String mainScreen;
    private String secondScreen;

    public Screen()
    {
        this.mainScreen="0";
        this.secondScreen="";
    }

    public Screen(String mainScreen,String secondScreen)
    {
        this.secondScreen=secondScreen;
        this.mainScreen=mainScreen;
    }

    public void updateScreen(String mainScreen,String secondScreen)
    {
        this.secondScreen=secondScreen;
        this.mainScreen=mainScreen;
    }

    public String getMainScreen()
    {
        return mainScreen;
    }

    public String getSecondScreen()
    {
        return secondScreen;
    }

    public void divisionByZeroError()
    {
        this.mainScreen="ERROR: DIVISION BY ZERO";
    }

    public double getValue()
    {
        return Double.valueOf(mainScreen);
    }

    public void setValue(Double value)
    {
        mainScreen=value.toString();
    }
}
