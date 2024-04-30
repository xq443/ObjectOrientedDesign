package inheritance_furniture;

public class Bed extends BedroomFurniture{

    public Bed(Double lenght, Double height, Double width) {
        super(lenght, height, width);
    }

    @Override
    public String print() {
        return "The best bed ever!";
    }
}
