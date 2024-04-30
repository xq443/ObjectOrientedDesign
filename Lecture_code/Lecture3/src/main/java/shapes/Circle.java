package shapes;

import java.util.Objects;

public class Circle extends AbstractShape{

    private Double radius;
    private static final Integer NUM_SIDES = 0;
    private static final Point ORIGIN = new Point(0.0, 0.0);

    public Circle(Double radius) {
        super(ORIGIN, NUM_SIDES);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void printShape() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Objects.equals(radius, circle.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
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
        return null;
    }
}
