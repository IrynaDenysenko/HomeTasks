package HomeTask3;

public class TwoVehicle {
    public static void main(String[] args) {
        Vehicle minivan = new Vehicle(1,1,1);
        Vehicle sportcar = new Vehicle(2,2,2);
        int range1, range2;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;
        range1 = minivan.fuelcap * minivan.mpg;


        sportcar.passengers = 2;
        sportcar.fuelcap = 14;
        sportcar.mpg = 12;
        range2 = sportcar.fuelcap * sportcar.mpg;

        System.out.println("Minivan can bring " + minivan.passengers +" passengers on " + range1 + " miles" );

        System.out.println("Sportcar can bring " + sportcar.passengers +" passengers on " + range2 + " miles" );


    }
}
