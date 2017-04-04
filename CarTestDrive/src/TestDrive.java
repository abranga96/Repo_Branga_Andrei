import java.awt.Color;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

/**
 * TestDrive demonstrates creating and calling
 * methods on Car  object.
 *
 * @author Laboratory Team
 */
public class TestDrive
{
    Car cars[];
    /**
     * Default number of cars in a test drive
     */
    public static final int NUM_CARS=5;
    /**
     * Constuctor for class TestDrive
     * makes a test drive for NUM_CARS cars
     */
    TestDrive()
    {
        this(NUM_CARS);
    }

    /**
     * Constuctor for class TestDrive
     * makes a test drive for numCars cars
     * @param numCars number of cars in atest drive
     */

    TestDrive(int numCars)
    {
        if (numCars > 0)
            cars = new Car[numCars];
        else
            cars = new Car[NUM_CARS];
    }
    //The Java virtual machine (JVM) always starts
    //execution with the 'main' method of the class passed
    //as a argument to the java command
    public static void main(String []args)
    {
        TestDrive td = new TestDrive();
        try {
            td.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //exit TestDrive
    }
    public void start() throws IOException {
        //Create a Volkswagen beetle Car
        Car beetle = new Car("Volskwagen Beetle", Color.orange, 80, 160, 10,80, (float) 0.2);
        //Take it for a drive
        System.out.println("Starting beetle test drive!");
        driveCarKeyboatd(beetle);
       /* //Create a Ferrari
        Car ferrari = new Car("Ferrari Testarosa", Color.red, 300, 280, 30,80,(float)0.2);
        //Take it for a drive
        System.out.println("Starting ferrari test drive!");
        driveCar(ferrari);
        //Create a Nissan car
        Car nissan=new Car("Nissan GTR",Color.black, 300, 250, 20,80,(float)0.2);
        //Take it for a drive
        System.out.println("Starting nissan test drive!");
        driveCar(nissan);**/
    }
    /**
     * Factory method to create a Car object with valid parameters
     * @param brand name or manufacturer.
     * @param color color of the Car object - one of Java color constants
     * @param power engine power
     * @param accelerationStep increase in speed when gas pedal pushed
     */
    private Car createCar(String brand, Color color, int power, int maxSpeed, int accelerationStep,float capacity,float level)
    {
        // TODO validate parameters. If wrong, then give message and create a default configured car
        Car c = new Car(brand, color, power, maxSpeed, accelerationStep,capacity,level);
        return c;
    }
    /**
     * Displays a list of known cars
     * and allows user to select one using a text-based menu
     * @return the id of the car, nonnegative integer
     */
    private int selectCar()
    {
        // TODO
        return 0;
    }
    /**
     * Asks for user input for a car identificated by carId
     * and shows the effect of controlling it
     * @param carId id of car; noinnegative integer
     */
    private void driveCar(Car c)
    {
        // TODO: change to get input from the user
        // TODO: show effect of commands from user
        // former contents

        System.out.print("Car is a " + c.getBrandName());
        System.out.println(" colored  " + c.getColor());
        System.out.print("\t engine power is " + c.getPower());
        System.out.println(" speeding step is " +c.getAcceleration());
        System.out.println("Current tank level is: "+ c.f.getLevel());
        System.out.println("Filling the tank.");
        c.f.fill((float)50);
        System.out.println("New tank level is: "+ c.f.getLevel());
        //press the accelerator 15 "times"
        for(int i = 0; i < 15; i++) {
            System.out.println("accelerating: " + c.accelerate());
            c.f.releaseFuel((float)(0.5));
            c.changeGear();
            c.getGear();
        }
        //Press the break softly
        c.breakCar("soft");
        c.changeGear();
        c.getGear();
        //Press the break hard
        c.breakCar("hard");
        c.changeGear();
        c.getGear();
        //release the accelerator 5 "times"
        for(int i = 0; i < 5; i++)
        {

            System.out.println("decelerating: " + c.decelerate());
            c.changeGear();
            c.getGear();
        }
        System.out.println("Final cruising speed: " + c.getSpeed());
        System.out.println("Final tank level is: "+ c.f.getLevel());
    }
    private void driveCarKeyboatd(Car c) throws IOException {


        System.out.print("Car is a " + c.getBrandName());
        System.out.println(" colored  " + c.getColor());
        System.out.print("\t engine power is " + c.getPower());
        System.out.println(" speeding step is " +c.getAcceleration());
        System.out.println("Current tank level is: "+ c.f.getLevel());
        System.out.println("Filling the tank.");
        c.f.fill((float)50);
        System.out.println("New tank level is: "+ c.f.getLevel());

        Scanner sc = new Scanner(System.in);
        int comm = sc.nextInt();
        switch (comm)
        {

            case 1:System.out.println("accelerating: " + c.accelerate());
                c.f.releaseFuel((float)(0.5));
                c.changeGear();
                c.getGear();
                comm = sc.nextInt();
                break;
            case 2:System.out.println("decelerating: " + c.decelerate());
                c.changeGear();
                c.getGear();
                comm = sc.nextInt();
                break;
            case 3:c.breakCar("soft");
                c.changeGear();
                c.getGear();
                comm = sc.nextInt();
                break;
            case 4:c.breakCar("hard");
                c.changeGear();
                c.getGear();
                comm = sc.nextInt();
                break;
            case 5:System.exit(0);
                break;
            default: sc.nextInt();
                break;

        }

        System.out.println("Final cruising speed: " + c.getSpeed());
        System.out.println("Final tank level is: "+ c.f.getLevel());
}
    /**
     * Provides for controlling what operation to be performed
     * createCar, selectCar, driveCar
     * TODO: decide on parameters and return value
     */

}
