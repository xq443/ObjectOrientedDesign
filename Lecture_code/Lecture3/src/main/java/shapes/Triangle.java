package shapes;

public class Triangle extends AbstractShape{

    private static final Point ORIGIN = new Point(0.0, 0.0);
    private static final Integer NUM_SIDES = 3;

    public Triangle() {

        super(ORIGIN, NUM_SIDES);
    }

    @Override
    public double distanceFromOrigin() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public Shape resize(double factor) {
        return new Triangle();
    }

    @Override
    public void printShape() {

    }
}
