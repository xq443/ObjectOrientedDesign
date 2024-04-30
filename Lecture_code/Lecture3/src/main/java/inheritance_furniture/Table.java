package inheritance_furniture;

public class Table extends DinningFurniture{

    public Table(Double lenght, Double height, Double width) {
        super(lenght, height, width);
    }

    @Override
    public String print() {
        return "Table for six, please...";
    }
}
