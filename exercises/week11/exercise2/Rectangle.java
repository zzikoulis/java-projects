package exercises.week11.exercise2;

public class Rectangle extends AbstractShape implements IRectangle {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public long getCircumference() {
        return (long) (2 * (width + height));
    }
}