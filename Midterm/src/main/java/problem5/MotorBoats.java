package problem5;

import java.util.Objects;

public class MotorBoats extends AbstractCharterBoats{

  private static final Integer MANUFACTURED_YEAR = 2010;
  private static final Double MANUFACTURED_YEAR_INCREASE = 1.35;
  private Double enginePower;

  public MotorBoats(String boatID, Double boatLength, Double pricePerDay, Integer manufacturingYear,
      Integer numOfCabins, Boolean skipperNeeded, Double enginePower) {
    super(boatID, boatLength, pricePerDay, manufacturingYear, numOfCabins, skipperNeeded);
    this.enginePower = enginePower;
  }

  public Double getEnginePower() {
    return this.enginePower;
  }

  @Override
  public Double estimateAnnualBoatRevenue() {
    Double basicEstimation = super.estimateAnnualBoatRevenue();
    if (this.manufacturingYear >  MANUFACTURED_YEAR) {
      basicEstimation *= MANUFACTURED_YEAR_INCREASE;
    }
    return basicEstimation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MotorBoats that = (MotorBoats) o;
    return Objects.equals(this.enginePower, that.enginePower);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.enginePower);
  }

  @Override
  public String toString() {
    return "MotorBoats{" +
        "enginePower=" + this.enginePower +
        ", boatID='" + this.boatID + '\'' +
        ", boatLength=" + this.boatLength +
        ", pricePerDay=" + this.pricePerDay +
        ", manufacturingYear=" + this.manufacturingYear +
        ", numOfCabins=" + this.numOfCabins +
        ", skipperNeeded=" + this.skipperNeeded +
        '}';
  }
}
