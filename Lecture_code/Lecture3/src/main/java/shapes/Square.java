package shapes;

import java.util.Objects;

public class Square extends AbstractShape{

    private Double length;
    private static final Integer NUM_SIDES = 4;
    private static final Point ORIGIN = new Point(0.0, 0.0);

    public Square( Double length) {
        super(ORIGIN, NUM_SIDES);
        this.length = length;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Override
    public void printShape() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Objects.equals(length, square.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public double distanceFromOrigin() {
        return 0;
    }

    @Override
    public double area() {
        return this.length*this.length;
    }

    @Override
    public double perimeter() {
        return 4*this.length;
    }

    @Override
    public Shape resize(double factor) {
        if(factor > 0 && factor <= 1)
            return new Square(this.length*factor);
        else return null;
    }
}
