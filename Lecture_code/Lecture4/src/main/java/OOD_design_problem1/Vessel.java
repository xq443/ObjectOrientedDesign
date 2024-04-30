package OOD_design_problem1;

public abstract class Vessel extends AbstractVehicle{

    public Vessel(String id, Integer manufacturingYear, MakeModel makeModel, Float msrp) {
        super(id, manufacturingYear, makeModel, msrp);
    }
}
