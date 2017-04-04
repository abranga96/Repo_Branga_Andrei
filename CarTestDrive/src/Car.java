import java.awt.Color;
/**
 *  Represents a car.
 *  The attributes are speed, engine power and color.
 *  The methods are accelerate,
 *  decelerate, getSpeed, getColor, getPower,
 *  getAcceleration, and getMaxSpeed.
 *
 * @author Laboratory Team
 */
public class Car
{
    private String brandName;
    private int speed = 0;  // current car speed
    private Color color;
    private int power;
    private int accelerationStep=0; // speed increase when gas pedal pushed
    private int maxSpeed;           // maximum speed for this car
    public static final int MIN_SPEED = 0; // minimum speed for all cars; km/h
    public static final int MAX_SPEED = 300; // speed limit on all cars; km/h
    public static final int MIN_POWER = 4; // minimum power for all cars; no less than 4 bhp
    public static final int MAX_POWER = 500; // maximum power for all cars.no more than 500 bhp
    public static final int ACCELERATION_MIN_STEP = 1; // minimum speed increase per second when gas pedal pushed
    // TODO integrate fuel tank
    private static final int ACCELERATION_MAX_STEP = 30; // maximum speed increase per second
//  when gas pedal pushed
    private int gear=1; //current car's gear
    public FuelTank f;
    /**
     * Constructor to create a new Car object
     * @param brand name or manufacturer.
     * @param color color of the Car object - one of Java color constants
     * @param power engine power
     * @param accelerationStep increase in speed when gas pedal pushed
     */
    public Car(String brand, Color color, int power, int maxSpeed, int accelerationStep,float capacity,float level)
    {
        //creates a new Car object with specified brand name, color, engine power, and maximum speed
        this.brandName = brand;
        this.color = color;
        this.power = (power > 4)? power: 4;
        if (maxSpeed < 0) this.maxSpeed = MIN_SPEED; // this car wil never move
        else
        if (maxSpeed < MAX_SPEED) this.maxSpeed = maxSpeed;
        else maxSpeed = MAX_SPEED;
        if (power < MIN_POWER) this.power = MIN_POWER;
        else
        if (power > MAX_POWER) this.power=MAX_POWER;
        if (accelerationStep < ACCELERATION_MIN_STEP)
            this.accelerationStep = ACCELERATION_MIN_STEP;
        else
        if (accelerationStep > ACCELERATION_MAX_STEP)
            this.accelerationStep = ACCELERATION_MIN_STEP;
        else
            this.accelerationStep = accelerationStep;
        f=new FuelTank(capacity,level);
    }

    /**
     * Simulates pressing the accelerator.
     * @return the new speed
     */
    public int accelerate()
    {
        int newSpeed = speed + getAcceleration();
        if(newSpeed <= maxSpeed)
        {
            speed = newSpeed;
        }
        else
        {
            speed = maxSpeed;
        }
        return speed;
    }
    /**
     * Simulates releasing the accelerator.
     * @return the new speed
     */
    public int decelerate()
    {
        if(speed > MIN_SPEED)
        {
            speed--;
        }
        return speed;
    }

    /**
     * @return the current speed
     */
    public int getSpeed()
    {
        return speed;
    }
    /**
     * @return the max speed
     */
    public int getMaxSpeed()
    {
        return MAX_SPEED;
    }
    /**
     * @return the color of the car
     */
    public Color getColor()
    {
        return color;
    }
    /**
     * @return the brand name of the car
     */
    public String getBrandName()
    {
        return brandName;
    }

    /**
     * @return the car's acceleration step
     */
    public int getAcceleration()
    {
        return accelerationStep;
    }
    /**
     * @return the power of the car
     */
    public int getPower()
    {
        return power;
    }
    // TODO: add a toString method

    public void breakCar(String how)
    {
        if (how=="soft")
        {
            if (speed <=10)
            {
                speed=0;
            }
            if (speed>10)
            {
                speed-=10;
            }
            System.out.println("You pressed the break soft. Your new speed is: "+speed);
        }
        if (how=="hard")
        {
            if (speed <=50)
            {
                speed=0;
            }
            if (speed>50)
            {
                speed-=50;
            }
            System.out.println("You pressed the break hard. Your new speed is: "+speed);
        }
    }
    public void changeGear()
    {
        switch ((int)(speed/10))
        {
            case 0: gear=1;
                break;
            case 1: gear=1;
                break;
            case 2: gear=2;
                break;
            case 3: gear=2;
                break;
            case 4: gear=3;
                break;
            case 5: gear=3;
                break;
            case 6: gear=4;
                break;
            case 7: gear=4;
                break;
            case 8: gear=5;
                break;
            case 9: gear=5;
                break;
            case 10: gear=5;
                break;
            case 11: gear=6;
                break;
            default: gear=6;
                break;
        }
    }
    public void getGear()
    {
        System.out.println("Current gear is: "+gear);
    }
}
