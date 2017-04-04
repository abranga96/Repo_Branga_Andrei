/**
 * Created by abran on 17.11.2016.
 */
public class Date
{
    private int day,month,year;

    public Date()
    {
        day=1;
        month=1;
        year=1991;
    }

    public Date(int day, int month, int year)
    {
        if ((day>0 && day <=31) && (month>0 && month<=12) && (year>=1991 && year<=2999))
        {
            this.year=year;
            this.month=month;
            this.day=day;
        }
    }

    public void getDate()
    {
        System.out.println(day + "/" + month + "/" + year);
    }

    public void setDate(int day, int month, int year)
    {
        if ((day>0 && day <=31) && (month>0 && month<=12) && (year>=1991 && year<=2999))
        {
            this.year=year;
            this.month=month;
            this.day=day;
        }
    }
}
