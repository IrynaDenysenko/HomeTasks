package vehicle;

public class Vehicle {
    private  int passengers;// amount of passengers
    private int fuelcap;//volume of petrol tank
    private int mpg;// how much gallons needs on 1 mile

    Vehicle (int p, int f, int m){
        passengers =  p;
        fuelcap = f;
        mpg = m;
    }
    int range(){
        return fuelcap * mpg;
    }
    double fuelNeeded (int miles){
        return (double) miles / mpg;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
    public void setFuelcap(int fuelcap) {
        this.fuelcap = fuelcap;
    }
    public void setMpg(int mpg) {
        this.mpg = mpg;
    }
    public int getPassengers() {
        return passengers;
    }
    public int getFuelcap() {
        return fuelcap;
    }
    public int getMpg() {
        return mpg;
    }
}
