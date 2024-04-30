In the implementation, inheritance is utilized in the design of the `Event`, `LunchEvents`, and `DinnerEvents` classes. The `LunchEvents` and `DinnerEvents` classes inherit from the base class `Event`, sharing common properties and methods. Here is a code snippet demonstrating the use of inheritance:

```java
public class Event {
    protected String clientName;
    protected Integer numAttendees;

    ...
}

public class LunchEvents extends Event {
    private Integer numSandwiches;

    public LunchEvents(String clientName, Integer numAttendees) throws InvalidNumAttendeesLunchException {
        if (numAttendees < 15 || numAttendees > 90) {
            throw new InvalidNumAttendeesLunchException("Invalid number of attendees for lunch.");
        }
        this.numSandwiches = (int) Math.ceil(1.05 * numAttendees);
        ...
    }

     ...
}

```
An exception class InvalidNumAttendeesLunchException is thrown when the number of lunch attendees falls outside the valid range. Similarly, an exception class InvalidNumAttendeesDinnerException is thrown for invalid dinner attendees. Here is a code snippet illustrating the usage of exceptions:

```java
public class InvalidNumAttendeesLunchException extends Exception {
    public InvalidNumAttendeesLunchException(String message) {
        super(message);
    }
     ... other code for InvalidNumAttendeesLunchException
}

public class InvalidNumAttendeesDinnerException extends Exception {
    public InvalidNumAttendeesDinnerException(String message) {
        super(message);
    }
    ... other code for InvalidNumAttendeesDinnerException
}
```