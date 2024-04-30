package OOD_design_problem1;

public abstract class Car extends AbstractVehicle{

    protected BodyType bodyType;

    public Car(String id, Integer manufacturingYear,
               MakeModel makeModel, Float msrp, BodyType bodyType) {
        super(id, manufacturingYear, makeModel, msrp);
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }
}
