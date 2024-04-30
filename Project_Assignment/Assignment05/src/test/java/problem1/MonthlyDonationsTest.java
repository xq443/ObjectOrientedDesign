package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonthlyDonationsTest {

  private MonthlyDonations testDonation;
  private LocalDateTime donationTime;

  @BeforeEach
  void setUp() {
    donationTime = LocalDateTime.of(2022, 5, 15, 10, 30);
    testDonation = new MonthlyDonations(100, donationTime);
  }

  @Test
  void testGetCancellationTime() {
    assertEquals(null, testDonation.getCancellationTime());
  }

  @Test
  void testSetCancellationTime_ValidCancellation() throws NoCancellationTimeException {
    LocalDateTime cancellationTime = LocalDateTime.of(2022, 6, 15, 10, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertEquals(cancellationTime, testDonation.getCancellationTime());
  }

  @Test
  void testGetTotalDonationsForYear_CurrentYearWithCancellation()
      throws NoCancellationTimeException {
    LocalDateTime cancellationTime = LocalDateTime.of(2022, 6, 20, 11, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertEquals(200, testDonation.getTotalDonationsForYear(donationTime.getYear()));
  }

  @Test
  void testGetTotalDonationsForYear_PastYear() {
    assertThrows(NoCancellationTimeException.class, () -> testDonation.setCancellationTime(donationTime.minusYears(1)));
  }

  @Test
  void testGetTotalDonationsForYear_NullCancellation() {
    assertThrows(NoCancellationTimeException.class, () -> testDonation.setCancellationTime(null));
  }

  //donationTime = LocalDateTime.of(2022, 5, 15, 10, 30);
  @Test
  void testGetTotalDonationsForYear_FutureYearWithCancellation()
      throws NoCancellationTimeException {
    LocalDateTime cancellationTime = LocalDateTime.of(2023, 6, 16, 10, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertEquals(600, testDonation.getTotalDonationsForYear(donationTime.getYear() + 1));
  }
  @Test
  void testGetTotalDonationsForYear_FutureYearWithCancellation1()
      throws NoCancellationTimeException {
    LocalDateTime cancellationTime = LocalDateTime.of(2024, 6, 16, 10, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertEquals(1200, testDonation.getTotalDonationsForYear(donationTime.getYear() + 1));
  }
  @Test
  void testGetTotalDonationsForYear_NoDonation()
      throws NoCancellationTimeException {
    LocalDateTime cancellationTime = LocalDateTime.of(2024, 6, 16, 10, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertEquals(0, testDonation.getTotalDonationsForYear(2025));
  }
  @Test
  void testGetTotalDonationsForYear_CancellationYearDifferent() throws NoCancellationTimeException {
    //donationTime = LocalDateTime.of(2022, 5, 15, 10, 30);
    LocalDateTime cancellationTime = LocalDateTime.of(2023, 6, 15, 10, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertEquals(800, testDonation.getTotalDonationsForYear(2022));
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
  void testEquals_DifferentCancellationTime() throws NoCancellationTimeException {
    MonthlyDonations otherDonation = new MonthlyDonations(100, donationTime);
    LocalDateTime cancellationTime = LocalDateTime.of(2022, 6, 15, 10, 30);
    otherDonation.setCancellationTime(cancellationTime);
    assertFalse(testDonation.equals(otherDonation));
  }

  @Test
  void testEquals_SameValues() {
    MonthlyDonations otherDonation = new MonthlyDonations(100, donationTime);
    assertTrue(testDonation.equals(otherDonation));
  }

  @Test
  void testEquals_DifferentDonationTime() {
    MonthlyDonations otherDonation = new MonthlyDonations(100, LocalDateTime.of(2023, 5, 15, 10, 30));
    assertFalse(testDonation.equals(otherDonation));
  }

  @Test
  void testEquals_DifferentPledge_Amount() {
    MonthlyDonations otherDonation = new MonthlyDonations(200, donationTime);
    assertFalse(testDonation.equals(otherDonation));
  }

  @Test
  void testEquals_DifferentPledge_CancellationTime() throws NoCancellationTimeException {
    MonthlyDonations otherDonation = new MonthlyDonations(100, donationTime);
    LocalDateTime cancellationTime = LocalDateTime.of(2022, 6, 15, 10, 30);
    testDonation.setCancellationTime(cancellationTime);
    assertFalse(testDonation.equals(otherDonation));
  }

  @Test
  void testHashCode() {
    MonthlyDonations otherDonation = new MonthlyDonations(100, donationTime);
    assertEquals(testDonation.hashCode(), otherDonation.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "MonthlyDonations{cancellationTime=null, amount=100, donationTime=" + donationTime + '}';
    assertEquals(expectedToString, testDonation.toString());
  }
}
