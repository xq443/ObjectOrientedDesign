package problem2;

import java.util.Objects;

/**
 * The MailItem class represents a mail item in a package locker system.
 */
public class MailItem {
  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;

  /**
   * Constructs a new MailItem with the specified dimensions and recipient.
   *
   * @param width     The width of the mail item.
   * @param height    The height of the mail item.
   * @param depth     The depth of the mail item.
   * @param recipient The recipient associated with the mail item.
   */
  public MailItem(int width, int height, int depth, Recipient recipient) {
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Gets the width of the mail item.
   * @return The width of the mail item: Integer
   */
  public Integer getWidth() {
    return this.width;
  }

  /**
   * Gets the height of the mail item.
   * @return The height of the mail item: Integer
   */
  public Integer getHeight() {
    return this.height;
  }

  /**
   * Gets the depth of the mail item.
   * @return The depth of the mail item: Integer
   */
  public Integer getDepth() {
    return this.depth;
  }

  /**
   * Gets the recipient associated with the mail item.
   * @return The recipient of the mail item: Recipient object
   */
  public Recipient getRecipient() {
    return this.recipient;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return this.width.equals(mailItem.width) && Objects.equals(this.height, mailItem.height) && Objects.equals(
        depth, mailItem.depth)
        && Objects.equals(this.recipient, mailItem.recipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.width, this.height, this.depth, this.recipient);
  }

  @Override
  public String toString() {
    return "MailItem{" +
        "width=" + width +
        ", height=" + height +
        ", depth=" + depth +
        ", recipient=" + recipient +
        '}';
  }
}
