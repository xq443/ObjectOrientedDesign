package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DinnerEventsTest {
  private DinnerEvents testDinnerEvents;
  private Integer expectedNumNonVegEntree;
  private Integer expectedNumVegEntrees;
  private Integer expectedNumAttendees;

  @BeforeEach
  void setUp() {
    testDinnerEvents = new DinnerEvents("Lily", 40);
    expectedNumAttendees = 40;
    expectedNumNonVegEntree = 32;
    expectedNumVegEntrees = 8;
  }

  @Test
  void checkDinnerNumAttendeesOverMax() {
    Assertions.assertThrows(InvalidNumAttendeesDinnerOverMaxException.class, () -> {
      testDinnerEvents.checkDinnerNumAttendees(100);
    });
  }

  @Test
  void checkDinnerNumAttendeesLessMin() {
    Assertions.assertThrows(InvalidNumAttendeesDinnerLessMinException.class, () -> {
      testDinnerEvents.checkDinnerNumAttendees(1);
    });
  }

  @Test
  void checkDinnerNumAttendeesSuccess() {
    try {
      testDinnerEvents.checkDinnerNumAttendees(40);
    } catch (InvalidNumAttendeesDinnerLessMinException | InvalidNumAttendeesDinnerOverMaxException e) {
      fail("Check Unsuccessful");
    }
    assertEquals(40, testDinnerEvents.getNumAttendees());
  }

  @Test
  void getNumNonVegEntrees() {
    assertEquals(expectedNumNonVegEntree, testDinnerEvents.getNumNonVegEntrees());
  }

  @Test
  void getNumVegEntrees() {
    assertEquals(expectedNumVegEntrees, testDinnerEvents.getNumVegEntrees());
  }
}