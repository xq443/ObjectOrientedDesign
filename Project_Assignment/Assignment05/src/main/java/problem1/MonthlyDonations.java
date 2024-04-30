package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * MonthlyDonations represents a monthly donation with an amount, donation time, and optional cancellation time.
 * which extends the AbstractDonations class.
 */
public class MonthlyDonations extends AbstractDonations {
  private static final Integer NO_DONATION = 0;
  private static final Integer MONTH_OF_YEAR = 12;
  private static final Integer START_MONTH = 1;
  private static final Integer START_DAY = 1;
  private static final Integer START_HOUR = 0;
  private static final Integer START_MIN = 0;



  /** The cancellation date and time for the monthly donation. */
  private LocalDateTime cancellationTime;

  /**
   * Constructs a new MonthlyDonations object with a certain amount and donation time.
   *
   * @param amount       the amount of the donation
   * @param donationTime the date and time of the donation
   */
  public MonthlyDonations(Integer amount, LocalDateTime donationTime) {
    super(amount, donationTime);
    this.cancellationTime = null;
  }

  /**
   * Retrieves the cancellation date and time for the monthly donation.
   *
   * @return the cancellation date and time: LocalDateTime obj
   */
  public LocalDateTime getCancellationTime() {
    return this.cancellationTime;
  }

  /**
   * Checks if the proposed cancellation time is valid.
   *
   * @param cancellationTime the proposed cancellation date/time
   * @return true if the cancellation is valid, false otherwise
   */
  private boolean validCancellation(LocalDateTime cancellationTime) {
    return (cancellationTime != null && !cancellationTime.isBefore(this.donationTime));
  }

  /**
   * Sets the cancellation date/time for the monthly donation.
   *
   * @param cancellationTime the cancellation date/time to be set
   * @throws NoCancellationTimeException if the proposed cancellation time is not valid
   */
  public void setCancellationTime(LocalDateTime cancellationTime)
      throws NoCancellationTimeException {
    if (validCancellation(cancellationTime)) {
      this.cancellationTime = cancellationTime;
    } else {
      throw new NoCancellationTimeException("Not a valid cancellation time");
    }
  }

  /**
   * Calculates the total amount of donations for the specified year, considering any cancellations.
   *
   * @param year the year for which to calculate the total donations
   * @return the total amount of donations for the specified year: Integer
   */
  @Override
  public Integer getTotalDonationsForYear(Integer year) {
    int totalAmount = 0;
    LocalDateTime currentDonationTime = this.donationTime;

    // Condition 1: If current donation year matches the given year and there's no cancellation time
//    if (currentDonationTime.getYear() == year && cancellationTime == null) {
//      while (currentDonationTime.getYear() == year) {
//        totalAmount += this.amount;
//        currentDonationTime = currentDonationTime.plusMonths(1);
//      }
//      return totalAmount;
//    }

    // Condition 2: If current donation year matches the given year and there's a valid cancellation time
    if (currentDonationTime.getYear() == year && this.cancellationTime.getYear() == year) {
      while (currentDonationTime.isBefore(this.cancellationTime)) {
        totalAmount += this.amount;
        currentDonationTime = currentDonationTime.plusMonths(1);
      }
      return totalAmount;
    }

    // Condition 3: If current donation year doesn't match the given year but cancellation time is in the given year
    else if (currentDonationTime.getYear() != year && this.cancellationTime != null && this.cancellationTime.getYear() == year) {
      currentDonationTime = LocalDateTime.of(year, START_MONTH, START_DAY, START_HOUR, START_MIN);
      while (currentDonationTime.isBefore(this.cancellationTime)) {
        totalAmount += this.amount;
        currentDonationTime = currentDonationTime.plusMonths(1);
      }
      return totalAmount;
    }

    // Condition 4: If current donation year doesn't match the given year and cancellation time is in a later year
    else if (currentDonationTime.getYear() < year && this.cancellationTime != null && this.cancellationTime.getYear() > year) {
      return MONTH_OF_YEAR * this.amount;
    }

    // Condition 5: If current donation year matches the given year but cancellation time is set for a different year
    else if (currentDonationTime.getYear() == year && this.cancellationTime.getYear() != year) {
      while (currentDonationTime.getYear() == year) {
        totalAmount += this.amount;
        currentDonationTime = currentDonationTime.plusMonths(1);
      }
      return totalAmount;
    }
    return NO_DONATION;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonthlyDonations that = (MonthlyDonations) o;
    return Objects.equals(this.cancellationTime, that.cancellationTime) &&
        Objects.equals(this.amount, that.amount) &&
        Objects.equals(this.donationTime, that.donationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.cancellationTime);
  }

  @Override
  public String toString() {
    return "MonthlyDonations{" +
        "cancellationTime=" + this.cancellationTime +
        ", amount=" + this.amount +
        ", donationTime=" + this.donationTime +
        '}';
  }
}
