package HomeTask3;

public class TwoVehicle4 {

    public static void main(String[] args) {
        Vehicle4 minivan = new Vehicle4();
        Vehicle4 sportcar = new Vehicle4();
        double gallons;
        int dist=252;

        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;


        sportcar.passengers = 2;
        sportcar.fuelcap = 14;
        sportcar.mpg = 12;

        gallons = minivan.flueNeeded(dist);
        System.out.println("for " + dist +" needs " + gallons );


        gallons = sportcar.flueNeeded(dist);
        System.out.println("for " + dist +" needs " + gallons );



    }
}
