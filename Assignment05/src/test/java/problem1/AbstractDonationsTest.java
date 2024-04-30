package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractDonationsTest {

  private AbstractDonations testAbstractDonations;
  private Integer expectedAmount;
  private LocalDateTime expectedDonationTime;

  @BeforeEach
  void setUp() {
    expectedAmount = 100;
    expectedDonationTime = LocalDateTime.of(2023, 1, 1, 10, 30);

    testAbstractDonations = new AbstractDonations(expectedAmount, expectedDonationTime){
    };
  }

  @Test
  void testGetAmount() {
    assertEquals(expectedAmount, testAbstractDonations.getAmount());
  }

  @Test
  void testGetDonationTime() {
    assertEquals(expectedDonationTime, testAbstractDonations.getDonationTime());
  }

  @Test
  void testToString() {
    String expectedToString = "Donations{" +
        "amount=" + expectedAmount +
        ", donationTime=" + expectedDonationTime +
        '}';
    assertEquals(expectedToString, testAbstractDonations.toString());
  }

  @Test
  void test_getTotalDonationsForYear() {
    assertEquals(0, testAbstractDonations.getTotalDonationsForYear(2023));
  }
}
