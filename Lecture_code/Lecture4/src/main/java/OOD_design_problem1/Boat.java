package OOD_design_problem1;

import java.util.Objects;

public class Boat extends Vessel{

    private Float length;
    private Integer numPassengers;
    private Boolean trailable;
    private PropulsionType propulsionType;
    private BodyType bodyType;

    public Boat(String id, Integer manufacturingYear, MakeModel makeModel, Float msrp, Float length, Integer numPassengers,
                Boolean trailable, PropulsionType propulsionType, BodyType bodyType) {
        super(id, manufacturingYear, makeModel, msrp);
        this.length = length;
        this.numPassengers = numPassengers;
        this.trailable = trailable;
        this.propulsionType = propulsionType;
        this.bodyType = bodyType;
    }

    public Float getLength() {
        return length;
    }

    public Integer getNumPassengers() {
        return numPassengers;
    }

    public Boolean getTrailable() {
        return trailable;
    }

    public PropulsionType getPropulsionType() {
        return propulsionType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return Objects.equals(this.id, boat.id) && Objects.equals(this.manufacturingYear, boat.manufacturingYear) &&
                Objects.equals(this.makeModel, boat.makeModel) && Objects.equals(this.msrp, boat.msrp) &&
                Objects.equals(length, boat.length) && Objects.equals(numPassengers, boat.numPassengers)
                && Objects.equals(trailable, boat.trailable) && propulsionType == boat.propulsionType
                && bodyType == boat.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, numPassengers, trailable, propulsionType, bodyType);
    }

    @Override
    public String toString() {
        return "Boat{" +
                "length=" + length +
                ", numPassengers=" + numPassengers +
                ", trailable=" + trailable +
                ", propulsionType=" + propulsionType +
                ", bodyType=" + bodyType +
                ", id='" + id + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", makeModel=" + makeModel +
                ", msrp=" + msrp +
                '}';
    }
}
