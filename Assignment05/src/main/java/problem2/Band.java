package problem2;

import java.util.List;
import java.util.Objects;

/**
 * Represents a band, subclass of Creator.
 */
public class Band extends GroupCreator {
  private String name;
  private List<RecordingArtist> members;

  /**
   * Constructs a band with the specified name and members.
   *
   * @param name    The name of the band.
   * @param members The list of recording artists who are members of the band.
   */
  public Band(String name, List<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * Gets the name of the band.
   *
   * @return The name of the band.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the list of recording artists who are members of the band.
   *
   * @return The list of members of the band.
   */
  public List<RecordingArtist> getMembers() {
    return this.members;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(this.name, band.name) && Objects.equals(this.members,
        band.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.members);
  }

  @Override
  public String toString() {
    return "Band{" +
        "name='" + this.name + '\'' +
        ", members=" + this.members +
        '}';
  }

  @Override
  public Boolean checkCreator(Creator creator) {
    return members.contains(creator);
  }
}
