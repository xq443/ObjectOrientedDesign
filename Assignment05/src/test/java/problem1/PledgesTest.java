package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PledgesTest {

  private Pledges testPledge;
  private LocalDateTime donationTime;
  private LocalDateTime processingTime;

  @BeforeEach
  void setUp() {
    donationTime = LocalDateTime.of(2023, 10, 15, 8, 0);
    processingTime = LocalDateTime.of(2023, 11, 1, 10, 30);
    testPledge = new Pledges(100, donationTime, processingTime);
  }

  @Test
  void testGetProcessingDateTime() {
    assertEquals(processingTime, testPledge.getProcessingDateTime());
  }

  @Test
  void testSetProcessingDateTime_ValidTime() throws NoProcessingTimeException {
    LocalDateTime newProcessingTime = LocalDateTime.of(2023, 11, 5, 12, 0);
    testPledge.setProcessingDateTime(newProcessingTime);
    assertEquals(newProcessingTime, testPledge.getProcessingDateTime());
  }

  @Test
  void testSetProcessingDateTime_NullTime() throws NoProcessingTimeException {
    assertThrows(NoProcessingTimeException.class, () -> testPledge.setProcessingDateTime(null));
  }

  @Test
  void testSetProcessingDateTime_InvalidTime() {
    LocalDateTime newProcessingTime = LocalDateTime.of(2023, 10, 5, 12, 0);
    assertThrows(NoProcessingTimeException.class, () -> testPledge.setProcessingDateTime(newProcessingTime));
  }

  @Test
  void testGetTotalDonationsForYear_ProcessingYear() {
    assertEquals(100, testPledge.getTotalDonationsForYear(2023));
  }

  @Test
  void testGetTotalDonationsForYear_ProcessingYear_NewProcessingTime()
      throws NoProcessingTimeException {
    LocalDateTime newProcessingTime = LocalDateTime.of(2023, 11, 16, 12, 0);
    testPledge.setProcessingDateTime(newProcessingTime);
    assertEquals(100, testPledge.getTotalDonationsForYear(2023));
  }

  @Test
  void testGetTotalDonationsForYear_NonProcessingYear() {
    assertEquals(0, testPledge.getTotalDonationsForYear(2024));
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testPledge.equals(testPledge));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testPledge.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testPledge.equals("String"));
  }

  @Test
  void testEquals_SameValues() {
    Pledges samePledge = new Pledges(100, donationTime, processingTime);
    assertTrue(testPledge.equals(samePledge));
  }

  @Test
  void testEquals_DifferentPledge_Amount() {
    Pledges otherPledge = new Pledges(200, donationTime, processingTime);
    assertFalse(testPledge.equals(otherPledge));
  }

  @Test
  void testEquals_DifferentPledge_DonationTime() {
    Pledges otherPledge = new Pledges(100, LocalDateTime.of(1933, 10, 15, 8, 0), processingTime);
    assertFalse(testPledge.equals(otherPledge));
  }
  @Test
  void testEquals_DifferentPledge_ProcessingTime() {
    Pledges otherPledge = new Pledges(100, donationTime, LocalDateTime.of(2029, 11, 1, 10, 30));
    assertFalse(testPledge.equals(otherPledge));
  }


  @Test
  void testHashCode() {
    Pledges samePledge = new Pledges(100, donationTime, processingTime);
    assertEquals(samePledge.hashCode(), testPledge.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "Pledges{processingDateTime=" + processingTime + ", amount=100, donationTime=" + donationTime + "}";
    assertEquals(expectedToString, testPledge.toString());
  }
}
