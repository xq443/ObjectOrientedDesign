package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OneTimeDonationsTest {

  private OneTimeDonations testDonation;
  private LocalDateTime donationTime;

  @BeforeEach
  void setUp() {
    donationTime = LocalDateTime.of(2022, 5, 15, 10, 30);
    testDonation = new OneTimeDonations(100, donationTime);
  }


  @Test
  void testGetTotalDonationsForYear_CurrentYear() {
    assertEquals(100, testDonation.getTotalDonationsForYear(donationTime.getYear()));
  }

  @Test
  void testGetTotalDonationsForYear_PastYear() {
    LocalDateTime pastDateTime = donationTime.minusYears(1);
    assertEquals(0, testDonation.getTotalDonationsForYear(pastDateTime.getYear()));
  }

  @Test
  void testToString() {
    String expectedToString = "OneTimeDonations{amount=100, donationTime=" + donationTime + '}';
    assertEquals(expectedToString, testDonation.toString());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testDonation.equals(testDonation));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testDonation.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testDonation.equals("String"));
  }

  @Test
  void testEquals_DifferentDonationTime() {
    OneTimeDonations otherDonation = new OneTimeDonations(100, LocalDateTime.of(2023, 5, 15, 10, 30));
    assertFalse(testDonation.equals(otherDonation));
  }

  @Test
  void testEquals_DifferentAmount() {
    OneTimeDonations otherDonation = new OneTimeDonations(200, donationTime);
    assertFalse(testDonation.equals(otherDonation));
  }

  @Test
  void testEquals_SameValues() {
    OneTimeDonations otherDonation = new OneTimeDonations(100, donationTime);
    assertTrue(testDonation.equals(otherDonation));
  }

  @Test
  void testHashCode() {
    OneTimeDonations otherDonation = new OneTimeDonations(100, donationTime);
    assertEquals(testDonation.hashCode(), otherDonation.hashCode());
  }
}
