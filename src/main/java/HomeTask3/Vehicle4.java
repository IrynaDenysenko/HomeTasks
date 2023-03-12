package HomeTask3;

public class Vehicle4 {

    int passengers; // the amount of passengers
    int fuelcap;// gas tank capacity
    int mpg;// mile per gallon

    int range(){
        return fuelcap * mpg;
    }

    double flueNeeded (int miles)
    {
        return (double) miles/mpg;
    }

}
