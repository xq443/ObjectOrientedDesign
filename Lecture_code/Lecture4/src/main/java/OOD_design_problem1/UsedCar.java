package OOD_design_problem1;

import java.util.Objects;

public class UsedCar extends Car{

    private Integer mileage;
    private Integer numPreviousOwner;
    private Integer numOfTrafficAccidents;
    private Boolean certifiedPreowned;

    public UsedCar(String id, Integer manufacturingYear, MakeModel makeModel, Float msrp, BodyType bodyType, Integer
            mileage, Integer numPreviousOwner, Integer numOfTrafficAccidents, Boolean certifiedPreowned) {
        super(id, manufacturingYear, makeModel, msrp, bodyType);
        this.mileage = mileage;
        this.numPreviousOwner = numPreviousOwner;
        this.numOfTrafficAccidents = numOfTrafficAccidents;
        this.certifiedPreowned = certifiedPreowned;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getNumPreviousOwner() {
        return numPreviousOwner;
    }

    public Integer getNumOfTrafficAccidents() {
        return numOfTrafficAccidents;
    }

    public Boolean getCertifiedPreowned() {
        return certifiedPreowned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsedCar usedCar = (UsedCar) o;
        return  Objects.equals(this.id, usedCar.id) && Objects.equals(this.manufacturingYear, usedCar.manufacturingYear) &&
                Objects.equals(this.makeModel, usedCar.makeModel) && Objects.equals(this.msrp, usedCar.msrp) &&
                Objects.equals(mileage, usedCar.mileage) && Objects.equals(numPreviousOwner, usedCar.numPreviousOwner)
                && Objects.equals(numOfTrafficAccidents, usedCar.numOfTrafficAccidents) &&
                Objects.equals(certifiedPreowned, usedCar.certifiedPreowned)
                && Objects.equals(this.bodyType, usedCar.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mileage, numPreviousOwner, numOfTrafficAccidents, certifiedPreowned);
    }

    @Override
    public String toString() {
        return "UsedCar{" +
                "mileage=" + mileage +
                ", numPreviousOwner=" + numPreviousOwner +
                ", numOfTrafficAccidents=" + numOfTrafficAccidents +
                ", certifiedPreowned=" + certifiedPreowned +
                ", bodyType=" + bodyType +
                ", id='" + id + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", makeModel=" + makeModel +
                ", msrp=" + msrp +
                '}';
    }
}
