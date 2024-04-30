package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Pledges represents a donation pledge with a specified amount, donation time, and processing time,
 * which extends AbstractDonations.
 */
public class Pledges extends AbstractDonations {
  private  static final Integer NO_DONATION = 0;
  private LocalDateTime processingDateTime;

  /**
   * Constructs a new Pledges object with the specified amount, donation time, and processing time.
   *
   * @param amount             the amount of the donation pledge
   * @param donationTime       the date and time of the donation pledge
   * @param processingDateTime the date and time when the pledge is processed
   */
  public Pledges(Integer amount, LocalDateTime donationTime, LocalDateTime processingDateTime) {
    super(amount, donationTime);
    this.processingDateTime = processingDateTime;
  }

  /**
   * Returns the processing date/time of the pledge.
   *
   * @return the processing date/time of the pledge
   */
  public LocalDateTime getProcessingDateTime() {
    return this.processingDateTime;
  }

  /**
   * Sets the processing date/time for the pledge.
   * Ensures that the new processing date/time is not prior to the creation date and time.
   *
   * @param processingDateTime the new processing date/time to be set
   * @throws NoProcessingTimeException if the new processing date/time is not valid
   */
  public void setProcessingDateTime(LocalDateTime processingDateTime)
      throws NoProcessingTimeException {
    if (validNewProcessingTime(processingDateTime)) {
      this.processingDateTime = processingDateTime;
    } else {
      throw new NoProcessingTimeException("Not a valid new processing date");
    }
  }

  /**
   * Checks if the proposed new processing date/time is not prior to the creation date and time.
   *
   * @param processingDateTime the proposed new processing date/time
   * @return true if the new processing date/time is valid, false otherwise
   */
  private boolean validNewProcessingTime(LocalDateTime processingDateTime) {
    return processingDateTime != null && !processingDateTime.isBefore(this.donationTime);
  }

  /**
   * Returns the total amount of donations for the specified year.
   * For pledges, if the processing date/time matches the specified year, returns the donation amount;
   * otherwise, returns 0.
   *
   * @param year the year for which to calculate the total donations
   * @return the total amount of donations for the specified year
   */
  @Override
  public Integer getTotalDonationsForYear(Integer year) {
    if (validNewProcessingTime(this.processingDateTime) &&  this.processingDateTime.getYear() == year) {
      return this.amount;
    } else {
      return NO_DONATION;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pledges pledges = (Pledges) o;
    return Objects.equals(this.processingDateTime, pledges.processingDateTime) &&
        Objects.equals(this.amount, pledges.amount) &&
        Objects.equals(this.donationTime, pledges.donationTime);
  }


  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.processingDateTime);
  }

  @Override
  public String toString() {
    return "Pledges{" +
        "processingDateTime=" + this.processingDateTime +
        ", amount=" + this.amount +
        ", donationTime=" + this.donationTime +
        '}';
  }
}
