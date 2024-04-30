package problem1;

import java.util.Objects;

/**
 *  * The Schedule class represents a schedule for a catering company, tracking lunch and
 *  * dinner events for a single day.
 */
public class Schedule {
  private LunchEvents lunchEvents;
  private DinnerEvents dinnerEvents;

  /**
   * Constructs an Schedule object with the specified lunchEvents and dinnerEvents.
   *
   * @param lunchEvents   lunchEvents object
   * @param dinnerEvents dinnerEvents object
   */
  public Schedule(LunchEvents lunchEvents, DinnerEvents dinnerEvents) {
    this.lunchEvents = lunchEvents;
    this.dinnerEvents = dinnerEvents;
  }

  /**
   * Validates if successfully book a lunch event.
   *
   * @param bookedLunchEvents LunchEvents object
   * @throws UnsuccessfulBookedLunchException if a lunch event is not successfully booked
   */
  public void bookLunchEvents(LunchEvents bookedLunchEvents)
      throws UnsuccessfulBookedLunchException {

    if(this.lunchEvents == null) this.lunchEvents = bookedLunchEvents;
    else throw new UnsuccessfulBookedLunchException("There is already a lunch event booked for this day.");
  }

  /**
   * Validates if successfully book a dinner event.
   *
   * @param bookeddinnerEvents DinnerEvents object
   * @throws UnsuccessfulBookedDinnerException if a dinner event is not successfully booked
   */
  public void bookDinnerEvents(DinnerEvents bookeddinnerEvents)
      throws UnsuccessfulBookedDinnerException {
    if(this.dinnerEvents == null) this.dinnerEvents = bookeddinnerEvents;
    else throw new UnsuccessfulBookedDinnerException("There is already a dinner event booked for this day.");
  }

  /**
   * Returns the lunchEvents object.
   * @return the lunchEvents object: LunchEvents
   */
  public LunchEvents getLunchEvents() {
    return this.lunchEvents;
  }

  /**
   * Returns the dinnerEvents object.
   * @return the dinnerEvents object: DinnerEvents
   */
  public DinnerEvents getDinnerEvents() {
    return this.dinnerEvents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Schedule schedule = (Schedule) o;
    return Objects.equals(lunchEvents, schedule.lunchEvents) && Objects.equals(
        dinnerEvents, schedule.dinnerEvents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lunchEvents, dinnerEvents);
  }

  @Override
  public String toString() {
    return "Schedule{" +
        "lunchEvents=" + lunchEvents +
        ", dinnerEvents=" + dinnerEvents +
        '}';
  }
}
