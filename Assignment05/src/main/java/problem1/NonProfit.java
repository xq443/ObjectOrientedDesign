package problem1;

import java.util.List;
import java.util.Objects;

public class NonProfit {
  private String organizationName;
  private List<AbstractDonations> nonProfitDonations;

  public NonProfit(String organizationName, List<AbstractDonations> nonProfitDonations) {
    this.organizationName = organizationName;
    this.nonProfitDonations = nonProfitDonations;
  }
  public String getOrganizationName() {
    return this.organizationName;
  }

  public List<AbstractDonations> getNonProfitDonations() {
    return this.nonProfitDonations;
  }

  /**
   * returns the sum of all donations processed in the specified year: Integer
   * @param year
   */
  public Integer getTotalDonationsForYear(Integer year) {
    Integer total = 0;
    for (AbstractDonations donation : this.nonProfitDonations) {
      total += donation.getTotalDonationsForYear(year);
    }
    return total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(this.organizationName, nonProfit.organizationName)
        && Objects.equals(this.nonProfitDonations, nonProfit.nonProfitDonations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.organizationName, this.nonProfitDonations);
  }

  @Override
  public String toString() {
    return "NonProfit{" +
        "organizationName='" + this.organizationName + '\'' +
        ", nonProfitDonations=" + this.nonProfitDonations +
        '}';
  }
}
