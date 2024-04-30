package inheritance_furniture;

public abstract class BedroomFurniture extends Furniture {

    protected Color color;
    protected Style style;

    public BedroomFurniture(Double lenght, Double height, Double width) {
        super(lenght, height, width);
    }
}
