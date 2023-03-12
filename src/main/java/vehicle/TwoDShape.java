package vehicle;

abstract class TwoDShape {
    private double width;
    private double height;
    private String name;

    //конструктор по умолчанию
    TwoDShape(){
        width = height = 0.0;
        name = "none";
    }

    TwoDShape(double w, double h, String n){
        width = w;
        height = h;
        name = n;

    }

    TwoDShape(double x,  String n){
        width = height = x;
        name = n;
    }

    TwoDShape(TwoDShape ob){
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }
    //abstract method
    abstract double area();

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }
}
