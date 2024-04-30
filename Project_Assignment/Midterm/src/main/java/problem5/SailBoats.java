package problem5;

public class SailBoats extends AbstractCharterBoats{
  private static final Integer BOAT_LENGTH_BENCHMARK = 45;
  private static final Double BOAT_LENGTH_INCREASE = 1.15;

  public SailBoats(String boatID, Double boatLength, Double pricePerDay, Integer manufacturingYear,
      Integer numOfCabins, Boolean skipperNeeded) {
    super(boatID, boatLength, pricePerDay, manufacturingYear, numOfCabins, skipperNeeded);
  }
  @Override
  public Double estimateAnnualBoatRevenue() {
    Double basicEstimation = super.estimateAnnualBoatRevenue();
    if (this.boatLength > BOAT_LENGTH_BENCHMARK) {
      basicEstimation *= BOAT_LENGTH_INCREASE;
    }
    return basicEstimation;
  }

  @Override
  public String toString() {
    return "SailBoats{" +
        "boatID='" + this.boatID + '\'' +
        ", boatLength=" + this.boatLength +
        ", pricePerDay=" + this.pricePerDay +
        ", manufacturingYear=" + this.manufacturingYear +
        ", numOfCabins=" + this.numOfCabins +
        ", skipperNeeded=" + this.skipperNeeded +
        '}';
  }
}
