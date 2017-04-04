package zoowsome.services.factories;

/**
 * Created by abran on 12.11.2016.
 */
public final class Constants
{
    public static final class Species {
        public static final String Mammal = "Mammal";
        public static final String Reptile = "Reptile";
        public static final String Bird = "Bird";
        public static final String Aquatic = "Aquatic";
        public static final String Insect = "Insect";
    }

    public static final class Animal {

        public static final class Mammal {
            public static final String Tiger = "TIGER";
            public static final String Dog = "DOG";
            public static final String Cow = "COW";
        }

        public static final class Reptile {
            public static final String Snake = "SNAKE";
            public static final String Crocodile = "CROCODILE";
            public static final String Camaleon = "CAMALEON";
        }

        public static final class Bird {
            public static final String Canary = "CANARY";
            public static final String Eagle = "EAGLE";
            public static final String Pigeon = "PIGEON";
        }

        public static final class Aquatic {
            public static final String Shark = "SHARK";
            public static final String Dolphin = "Dolphin";
            public static final String Whale = "WHALE";
        }

        public static final class Insect {
            public static final String Butterfly = "BUTTERFLY";
            public static final String Cockroach = "COCKROACH";
            public static final String Spider = "SPIDER";
        }
    }

    public static final class Employee{

        public  static final class Caretakers{
            public static  final String TCO_SUCCESS = "SUCCESS";
            public static  final String TCO_KILLED = "KILLED";
            public static  final String TCO_NO_TIME = "NO_TIME";
        }
    }


    public class XML_TAGS {
        public static final String ANIMAL="ANIMAL";
        public static  final String DISCRIMINANT="DISCRIMINANT";
        public static final String CARETAKER="CARETAKER";
    }
}
