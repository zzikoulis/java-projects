package exercises.week11.exercise1;

public class Rectangle extends AbstractShape implements TwoDimensional {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return width * height;
    }
}
