package zoowsome.models.employee;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by abran on 22.11.2016.
 */
public abstract class Employee
{
    String name;
    BigDecimal salary;
    Boolean isDead;
    UUID id;

    public  Employee()
    {
        this.name="Default";
        this.salary=BigDecimal.ZERO;
        this.isDead=false;
        id=UniqueID.getId();
    }

    public Employee(String name,BigDecimal salary,boolean isDead)
    {
        id=UniqueID.getId();
        this.name=name;
        this.salary=salary;
        this.isDead=isDead;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary=salary;
    }

    public boolean getIsDead()
    {
        return isDead;
    }

    public void setIsDead(boolean isDead)
    {
        this.isDead=isDead;
    }

    public void setID(UUID uis)
    {
        this.id=id;
    }

    public  UUID getID()
    {
        return this.id;
    }
}

