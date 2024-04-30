package problem2;

import java.util.Objects;

/**
 * The Locker class represents a storage unit for mail items in a package locker system.
 */
public class Locker {
  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem storedMail;

  /**
   * Constructs a new Locker with the specified dimensions.
   *
   * @param maxWidth  The maximum width of the locker.
   * @param maxHeight The maximum height of the locker.
   * @param maxDepth  The maximum depth of the locker.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.storedMail = null;
  }


  /**
   * Adds a mail item to the locker, if possible.
   *
   * @param mailItem The mail item to be added.
   * @throws LockerOccupiedException   If the locker is already occupied.
   * @throws MailItemTooLargeException If the mail item exceeds the locker dimensions.
   */
  public void addMail(MailItem mailItem) throws LockerOccupiedException, MailItemTooLargeException {
    if (this.storedMail != null) {
      throw new LockerOccupiedException("The locker is already occupied.");
    }
    if (mailItem.getWidth() > this.maxWidth || mailItem.getHeight() > this.maxHeight || mailItem.getDepth() > this.maxDepth) {
      throw new MailItemTooLargeException("The mail item exceeds the dimensions of the locker.");
    }
    this.storedMail = mailItem;
  }


  /**
   * Picks up a mail item from the locker based on the recipient information.
   *
   * @param recipient The recipient of the mail item.
   * @return The picked-up mail item.
   * @throws NoMailItemMatchException       If no mail item is found in the locker.
   * @throws RecipientUnableMatchException If the recipient information doesn't match.
   */
  public MailItem pickupMail(Recipient recipient)
      throws NoMailItemMatchException, RecipientUnableMatchException {
    if (this.storedMail != null && this.storedMail.getRecipient().equals(recipient)) {
      MailItem pickedUpMail = this.storedMail;
      this.storedMail = null; // Remove the mail item from the locker
      return pickedUpMail;
    } else if(this.storedMail == null) {
      throw new NoMailItemMatchException("No mail item found");
    } else  {
      throw new RecipientUnableMatchException("Recipient doesn't match");
    }
  }

  /**
   * Gets the maximum width of the locker.
   * @return The maximum width of the locker: Integer
   */
  public Integer getMaxWidth() {
    return this.maxWidth;
  }

  /**
   * Gets the maximum height of the locker.
   * @return The maximum height of the locker: Integer
   */
  public Integer getMaxHeight() {
    return this.maxHeight;
  }

  /**
   * Gets the maximum depth of the locker.
   * @return The maximum depth of the locker: Integer
   */
  public Integer getMaxDepth() {
    return this.maxDepth;
  }


  /**
   * Gets the currently stored mail item in the locker.
   * @return The stored mail item: MailItem object
   */
  public MailItem getStoredMail() {
    return this.storedMail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Locker locker = (Locker) o;
    return Objects.equals(this.maxWidth, locker.maxWidth) && Objects.equals(this.maxHeight, locker.maxHeight)
        && Objects.equals(this.maxDepth, locker.maxDepth)
        && Objects.equals(this.storedMail, locker.storedMail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.maxWidth, this.maxHeight, this.maxDepth, this.storedMail);
  }

  @Override
  public String toString() {
    return "Locker{" +
        "maxWidth=" + this.maxWidth +
        ", maxHeight=" + this.maxHeight +
        ", maxDepth=" + this.maxDepth +
        ", storedMail=" + this.storedMail +
        '}';
  }
}
