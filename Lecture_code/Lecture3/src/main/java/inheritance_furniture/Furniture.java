package inheritance_furniture;

import java.util.Objects;

public abstract class Furniture {

    protected Double length;
    protected Double height;
    protected Double width;

    public Furniture(Double length, Double height, Double width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public abstract String print();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(length, furniture.length) && Objects.equals(height, furniture.height) && Objects.equals(width, furniture.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height, width);
    }
}
