package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduleTest {

  private Schedule testSchedule;
  private LunchEvents expectedLunchEvent;
  private DinnerEvents expectedDinnerEvent;

  private Schedule testScheduleOther;

  @BeforeEach
  void setUp() {
    testSchedule = new Schedule(new LunchEvents("Client1", 30), new DinnerEvents("Client2", 20));
    expectedLunchEvent = new LunchEvents("Client1", 30);
    expectedDinnerEvent = new DinnerEvents("Client2", 20);
    testScheduleOther = new Schedule(null, null);
  }

  @Test
  void bookLunchEvents_Success() throws UnsuccessfulBookedLunchException {
    try {
      testScheduleOther.bookLunchEvents(expectedLunchEvent);
    } catch (UnsuccessfulBookedLunchException e) {
      fail("Book Unsuccessful");
    }
    assertEquals(expectedLunchEvent, testScheduleOther.getLunchEvents());
  }

  @Test
  void bookLunchEvents_Failure() {
    assertThrows(UnsuccessfulBookedLunchException.class, () -> {
      testSchedule.bookLunchEvents(expectedLunchEvent);
      testSchedule.bookLunchEvents(new LunchEvents("Client3", 40));
    });
  }

  @Test
  void bookDinnerEvents_Success() throws UnsuccessfulBookedDinnerException {
    try {
      testScheduleOther.bookDinnerEvents(expectedDinnerEvent);
    } catch (UnsuccessfulBookedDinnerException e) {
      fail("Book Unsuccessful");
    }
    assertEquals(expectedDinnerEvent, testScheduleOther.getDinnerEvents());
  }

  @Test
  void bookDinnerEvents_Failure() {
    assertThrows(UnsuccessfulBookedDinnerException.class, () -> {
      testSchedule.bookDinnerEvents(expectedDinnerEvent);
      testSchedule.bookDinnerEvents(new DinnerEvents("Client4", 25));
    });
  }

  @Test
  void equals_SameObjects() {
    assertTrue(testSchedule.equals(testSchedule));
  }

  @Test
  void equals_NULL() {
    assertFalse(testSchedule.equals(null));
  }
  @Test
  void equals_DifferentDataType() {
    assertFalse(testSchedule.equals("String"));
  }

  @Test
  void testEquals_DifferentLunch() {
    LunchEvents otherLunch = new LunchEvents("Peter", 35);
    Schedule otherSchedule = new Schedule(otherLunch, expectedDinnerEvent);
    assertFalse(testSchedule.equals(otherSchedule));
  }
  @Test
  void testEquals_DifferentDinner() {
    DinnerEvents otherDinner = new DinnerEvents("Peter", 22);
    Schedule otherSchedule = new Schedule(expectedLunchEvent, otherDinner);
    assertFalse(testSchedule.equals(otherSchedule));
  }


  @Test
  void testEquals_DifferentObjectSameFields() {
    Schedule otherSchedule = new Schedule(expectedLunchEvent, expectedDinnerEvent);
    assertTrue(testSchedule.equals(otherSchedule));
  }

  @Test
  void hashCode_EqualsObjects() {
    int expHashCode = Objects.hash(expectedLunchEvent, expectedDinnerEvent);
    assertEquals(expHashCode, testSchedule.hashCode());
  }

  @Test
  void toString_ValidString() {
    String expectedString = "Schedule{" +
        "lunchEvents=" + expectedLunchEvent +
        ", dinnerEvents=" + expectedDinnerEvent +
        '}';
    assertEquals(expectedString, testSchedule.toString());
  }
}
