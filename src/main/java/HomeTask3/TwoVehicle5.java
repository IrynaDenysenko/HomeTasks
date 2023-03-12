package HomeTask3;

public class TwoVehicle5 {
    public static void main(String[] args) {
        Vehicle5 minivan = new Vehicle5(5,7,10);
        Vehicle5 sportcar = new Vehicle5(2,4,7);

        double gallons;
        int dist=252;

        gallons = minivan.flueNeeded(dist);
        System.out.println("for " + dist +" needs " + gallons );


        gallons = sportcar.flueNeeded(dist);
        System.out.println("for " + dist +" needs " + gallons );



    }
}
