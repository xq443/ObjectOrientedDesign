package OOD_design_problem1;

import java.util.Objects;

public class NewCar extends Car{

    private Integer numVehiclesAvailable;

    public NewCar(String id, Integer manufacturingYear, MakeModel makeModel,
                  Float msrp, BodyType bodyType, Integer numVehiclesAvailable) {
        super(id, manufacturingYear, makeModel, msrp, bodyType);
        this.numVehiclesAvailable = numVehiclesAvailable;
    }

    public Integer getNumVehiclesAvailable() {
        return numVehiclesAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewCar newCar = (NewCar) o;
        return Objects.equals(this.id, newCar.id) && Objects.equals(this.manufacturingYear, newCar.manufacturingYear)
        && Objects.equals(this.makeModel, newCar.makeModel) && Objects.equals(this.msrp, newCar.msrp)
        && Objects.equals(this.bodyType, newCar.bodyType) && Objects.equals(numVehiclesAvailable, newCar.numVehiclesAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.manufacturingYear,
                this.makeModel, this.msrp, this.bodyType, this.numVehiclesAvailable);
    }

    @Override
    public String toString() {
        return "NewCar{" +
                "numVehiclesAvailable=" + numVehiclesAvailable +
                ", bodyType=" + bodyType +
                ", id='" + id + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", makeModel=" + makeModel +
                ", msrp=" + msrp +
                '}';
    }
}
