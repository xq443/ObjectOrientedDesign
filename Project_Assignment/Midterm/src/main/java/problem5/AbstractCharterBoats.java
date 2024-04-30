package problem5;

import java.util.Objects;

public abstract class AbstractCharterBoats implements CharterBoats{

  private static final Integer CHARTERED_DAYS_BENCHMARK = 80;
  protected String boatID;
  protected Double boatLength;
  protected Double pricePerDay;
  protected Integer manufacturingYear;
  protected Integer numOfCabins;
  protected Boolean skipperNeeded;

  public AbstractCharterBoats(String boatID, Double boatLength, Double pricePerDay,
      Integer manufacturingYear, Integer numOfCabins, Boolean skipperNeeded) {
    this.boatID = boatID;
    this.boatLength = boatLength;
    this.pricePerDay = pricePerDay;
    this.manufacturingYear = manufacturingYear;
    this.numOfCabins = numOfCabins;
    this.skipperNeeded = skipperNeeded;
  }

  public String getBoatID() {
    return this.boatID;
  }

  public Double getBoatLength() {
    return this.boatLength;
  }

  public Double getPricePerDay() {
    return this.pricePerDay;
  }

  public Integer getManufacturingYear() {
    return this.manufacturingYear;
  }

  public Integer getNumOfCabins() {
    return this.numOfCabins;
  }

  public Boolean getSkipperNeeded() {
    return this.skipperNeeded;
  }

  @Override
  public Double estimateAnnualBoatRevenue() {
    return CHARTERED_DAYS_BENCHMARK * this.pricePerDay;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractCharterBoats that = (AbstractCharterBoats) o;
    return Objects.equals(this.boatID, that.boatID) && Objects.equals(this.boatLength,
        that.boatLength) && Objects.equals(this.pricePerDay, that.pricePerDay)
        && Objects.equals(this.manufacturingYear, that.manufacturingYear)
        && Objects.equals(this.numOfCabins, that.numOfCabins) && Objects.equals(
        this.skipperNeeded, that.skipperNeeded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.boatID, this.boatLength, this.pricePerDay, this.manufacturingYear, this.numOfCabins,
        this.skipperNeeded);
  }

  @Override
  public String toString() {
    return "AbstractCharterBoats{" +
        "boatID='" + this.boatID + '\'' +
        ", boatLength=" + this.boatLength +
        ", pricePerDay=" + this.pricePerDay +
        ", manufacturingYear=" + this.manufacturingYear +
        ", numOfCabins=" + this.numOfCabins +
        ", skipperNeeded=" + this.skipperNeeded +
        '}';
  }
}
