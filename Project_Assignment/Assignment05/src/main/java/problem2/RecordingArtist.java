package problem2;

/**
 * Represents a recording artist.
 */
public class RecordingArtist extends IndividualCreator {

  /**
   * Constructs a recording artist with the specified first name and last name.
   *
   * @param firstName The first name of the recording artist.
   * @param lastName  The last name of the recording artist.
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public Boolean checkCreator(Creator creator) {
    return this.equals(creator);
  }
}
