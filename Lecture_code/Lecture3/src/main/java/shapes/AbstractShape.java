package shapes;

import java.util.Objects;

public abstract class AbstractShape implements Shape{

    protected Point origin;
    protected Integer numSides;

    public AbstractShape(Point origin, Integer numSides) {
        this.origin = origin;
        this.numSides = numSides;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Integer getNumSides() {
        return numSides;
    }

    public void setNumSides(Integer numSides) {
        this.numSides = numSides;
    }

    public abstract void printShape();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractShape that = (AbstractShape) o;
        return Objects.equals(origin, that.origin) && Objects.equals(numSides, that.numSides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, numSides);
    }
}
