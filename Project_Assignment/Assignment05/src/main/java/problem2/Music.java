package problem2;

/**
 * Represents a music item.
 */
public class Music extends Item {
  private Band band;
  private RecordingArtist recordingArtist;

  /**
   * Constructs a Music object with information about a band.
   *
   * @param band  the band associated with the music
   * @param title the title of the music
   * @param year  the year when the music was released
   */
  public Music(Band band, String title, Integer year) {
    super(band, title, year);
  }

  /**
   * Constructs a Music object with information about a recording artist.
   *
   * @param recordingArtist the recording artist associated with the music
   * @param title           the title of the music
   * @param year            the year when the music was released
   */
  public Music(RecordingArtist recordingArtist, String title, Integer year) {
    super(recordingArtist, title, year);
  }


}
