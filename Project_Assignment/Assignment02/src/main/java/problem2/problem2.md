The addMail method in the Locker class, where exceptions are used for handling specific cases:

```java
public class Locker {
  ...

  public void addMail(MailItem mailItem)
      throws LockerOccupiedException, MailItemTooLargeException {
    if (storedMail != null) {
      throw new LockerOccupiedException("The locker is already occupied.");
    }
    if (mailItem.getWidth() > maxWidth || mailItem.getHeight() > maxHeight || mailItem.getDepth() > maxDepth) {
      throw new MailItemTooLargeException("The mail item exceeds the dimensions of the locker.");
    }
    storedMail = mailItem;
  }
  
  ...Other methods...
}
```
In the addMail method, exceptions (LockerOccupiedException and MailItemTooLargeException) are thrown:
If the locker is already occupied (storedMail != null), a LockerOccupiedException is thrown.
If the dimensions of the mail item exceed the dimensions of the locker, a MailItemTooLargeException is thrown.


There is no explicit use of class inheritance regarding Locker, MailItem, and Recipient because they don't share the same properties or methods, however, in the example of LockerOccupiedException class, it inherits from Exception class with keywords extends

```java
public class LockerOccupiedException extends Exception{

  public LockerOccupiedException(String message) {
    super(message);
  }
}
```
