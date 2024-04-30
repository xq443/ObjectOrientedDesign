package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LunchEventsTest {

  private LunchEvents testLunchEvents;
  private String expectedClientName;
  private Integer expectedNumAttendees;
  private Integer expectedNumSandwiches;

  @BeforeEach
  void setUp() {
    testLunchEvents = new LunchEvents("Maria", 50);
    expectedClientName = "Maria";
    expectedNumAttendees = 50;
    expectedNumSandwiches = 53;
  }

  @Test
  void getClientName() {
    assertEquals(expectedClientName, testLunchEvents.getClientName());
  }

  @Test
  void getNumAttendees() {
    assertEquals(expectedNumAttendees, testLunchEvents.getNumAttendees());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testLunchEvents.equals(testLunchEvents));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testLunchEvents.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testLunchEvents.equals("String"));
  }

  @Test
  void testEquals_DifferentName() {
    LunchEvents otherLunchEvents = new LunchEvents("Grace", 50);
    assertFalse(testLunchEvents.equals(otherLunchEvents));
  }

  @Test
  void testEquals_DifferentNumAttendees() {
    LunchEvents otherLunchEvents = new LunchEvents("Maria", 55);
    assertFalse(testLunchEvents.equals(otherLunchEvents));
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    LunchEvents otherLunchEvents = new LunchEvents("Maria", 50);
    assertTrue(testLunchEvents.equals(otherLunchEvents));
  }


  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedClientName, expectedNumAttendees);
    assertEquals(expectedHashCode, testLunchEvents.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "Event{" +
        "clientName='" + expectedClientName + '\'' +
        ", numAttendees=" + expectedNumAttendees +
        '}';
    assertEquals(expectedStr, testLunchEvents.toString());
  }

  @Test
  void checkLunchNumAttendeesOverMax() {
    Assertions.assertThrows(InvalidNumAttendeesLunchOverMaxException.class, () -> {
      testLunchEvents.checkLunchNumAttendees(100);
    });
  }

  @Test
  void checkLunchNumAttendeesLessMin() {
    Assertions.assertThrows(InvalidNumAttendeesLunchLessMinException.class, () -> {
      testLunchEvents.checkLunchNumAttendees(1);
    });
  }

  @Test
  void checkLunchNumAttendeesSuccess() {
    try {
      testLunchEvents.checkLunchNumAttendees(50);
    } catch (InvalidNumAttendeesLunchOverMaxException | InvalidNumAttendeesLunchLessMinException e) {
      fail("Check Unsuccessful");
    }
    assertEquals(50, testLunchEvents.getNumAttendees());
  }



  @Test
  void getNumSandwiches() {
    assertEquals(expectedNumSandwiches, testLunchEvents.getNumSandwiches());
  }


}