package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonProfitTest {

  private NonProfit testNonProfit;
  private String expectedOrganizationName;
  private List<AbstractDonations> expectedNonProfitDonations;

  @BeforeEach
  void setUp() throws NoCancellationTimeException {
    expectedOrganizationName = "Test Non-Profit";
    expectedNonProfitDonations = new ArrayList<>();
    LocalDateTime donationTime1 = LocalDateTime.of(2022, 5, 15, 10, 30);
    LocalDateTime donationTime2 = LocalDateTime.of(2023, 6, 20, 12, 0);
    LocalDateTime processingTime1 = LocalDateTime.of(2024, 6, 20, 12, 0);
    MonthlyDonations donation1 = new MonthlyDonations(100, donationTime1);
    LocalDateTime cancellationTime = LocalDateTime.of(2024, 6, 16, 10, 30);
    donation1.setCancellationTime(cancellationTime);
    Pledges donation2 = new Pledges(200, donationTime2, processingTime1);
    OneTimeDonations donations3 = new OneTimeDonations(300, donationTime1);

    expectedNonProfitDonations.add(donation1);
    expectedNonProfitDonations.add(donation2);
    expectedNonProfitDonations.add(donations3);
    testNonProfit = new NonProfit(expectedOrganizationName, expectedNonProfitDonations);
  }

  @Test
  void getOrganizationName() {
    assertEquals(expectedOrganizationName, testNonProfit.getOrganizationName());
  }

  @Test
  void getNonProfitDonations() {
    assertEquals(expectedNonProfitDonations, testNonProfit.getNonProfitDonations());
  }

  @Test
  void getTotalDonationsForYear() {
    assertEquals(1100, testNonProfit.getTotalDonationsForYear(2022));
    assertEquals(1200, testNonProfit.getTotalDonationsForYear(2023));
    assertEquals(800, testNonProfit.getTotalDonationsForYear(2024));
  }

  @Test
  void testEquals_SameObject() {
    assertEquals(testNonProfit, testNonProfit);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testNonProfit.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testNonProfit.equals("String"));
  }

  @Test
  void testEquals_DifferentOrganizationName() {
    NonProfit otherNonProfit = new NonProfit("Different Non-Profit", expectedNonProfitDonations);
    assertFalse(testNonProfit.equals(otherNonProfit));
  }

  @Test
  void testEquals_DifferentDonations() {
    List<AbstractDonations> otherDonations = new ArrayList<>();
    otherDonations.add(new OneTimeDonations(100, LocalDateTime.of(2022, 5, 15, 10, 30)));
    NonProfit otherNonProfit = new NonProfit(expectedOrganizationName, otherDonations);
    assertFalse(testNonProfit.equals(otherNonProfit));
  }

  @Test
  void testEquals_SameValues() {
    NonProfit otherNonProfit = new NonProfit(expectedOrganizationName, expectedNonProfitDonations);
    assertTrue(testNonProfit.equals(otherNonProfit));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedOrganizationName, expectedNonProfitDonations);
    assertEquals(expectedHashCode, testNonProfit.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "NonProfit{" +
        "organizationName='" + expectedOrganizationName + '\'' +
        ", nonProfitDonations=" + expectedNonProfitDonations +
        '}';
    assertEquals(expectedStr, testNonProfit.toString());
  }
}
