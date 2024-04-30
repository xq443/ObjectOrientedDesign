package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * AbstractDonations is an abstract class representing a donation with an amount and a donation time.
 * It implements the Donations interface.
 */
public abstract class AbstractDonations implements Donations {
  private static final Integer NO_DONATION = 0;

  /** The amount of the donation. */
  protected Integer amount;

  /** The date and time of the donation. */
  protected LocalDateTime donationTime;

  /**
   * Constructs a new AbstractDonations object with the specified amount and donation time.
   *
   * @param amount       the amount of the donation
   * @param donationTime the date and time of the donation
   */
  public AbstractDonations(Integer amount, LocalDateTime donationTime) {
    this.amount = amount;
    this.donationTime = donationTime;
  }

  /**
   * Retrieves the amount of the donation.
   *
   * @return the amount of the donation
   */
  public Integer getAmount() {
    return this.amount;
  }

  /**
   * Retrieves the date and time of the donation.
   *
   * @return the date and time of the donation
   */
  public LocalDateTime getDonationTime() {
    return this.donationTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractDonations donations = (AbstractDonations) o;
    return Objects.equals(this.amount, donations.amount) && Objects.equals(
        this.donationTime, donations.donationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.amount, this.donationTime);
  }

  @Override
  public String toString() {
    return "Donations{" +
        "amount=" + this.amount +
        ", donationTime=" + this.donationTime +
        '}';
  }
  @Override
  public Integer getTotalDonationsForYear(Integer year) {
    return NO_DONATION;
  }
}
