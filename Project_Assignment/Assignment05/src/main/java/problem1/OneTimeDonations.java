package problem1;

import java.time.LocalDateTime;

/**
 * OneTimeDonations represents a one-time donation at a certain date/time.
 */
public class OneTimeDonations extends AbstractDonations {
  private static final Integer NO_DONATION = 0;

  /**
   * Constructs a new OneTimeDonations obj with amount and donation time attributes
   *
   * @param amount       the amount of the donation
   * @param donationTime the date and time of the donation
   */
  public OneTimeDonations(Integer amount, LocalDateTime donationTime) {
    super(amount, donationTime);
  }

  /**
   * Returns the total amount of donations for a certain year.
   * Regarding one-time donations, if the donation was made in the specified year, returns the donation amount;
   * otherwise, returns 0.
   *
   * @param year the year for which to calculate the total donations
   * @return the total amount of donations for the specified year
   */
  @Override
  public Integer getTotalDonationsForYear(Integer year) {
    if (this.donationTime.getYear() == year) {
      return this.amount;
    } else {
      return NO_DONATION;
    }
  }

  /**
   * Returns a string representation of the OneTimeDonations object.
   *
   * @return a string representation of the object
   */
  @Override
  public String toString() {
    return "OneTimeDonations{" +
        "amount=" + this.amount +
        ", donationTime=" + this.donationTime +
        '}';
  }
}