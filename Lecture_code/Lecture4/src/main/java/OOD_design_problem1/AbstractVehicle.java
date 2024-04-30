package OOD_design_problem1;

public abstract class AbstractVehicle implements Vehicle{

    protected String id;
    protected Integer manufacturingYear;
    protected MakeModel makeModel;
    protected Float msrp;

    public AbstractVehicle(String id, Integer manufacturingYear, MakeModel makeModel, Float msrp) {
        this.id = id;
        this.manufacturingYear = manufacturingYear;
        this.makeModel = makeModel;
        this.msrp = msrp;
    }

    public String getId() {
        return id;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public MakeModel getMakeModel() {
        return makeModel;
    }

    public Float getMsrp() {
        return msrp;
    }
}
