package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Musician extends AbstractArtist{

    private String recordingCompany;
    private String lastRecordedAlbum;

    public Musician(Name artistsName1, Integer age1, String[] genres1, String[] awards1, String recordingCompany,
                    String lastRecordedAlbum) throws InvalidAgeException {
        super(artistsName1, age1, genres1, awards1);
        this.recordingCompany = recordingCompany;
        this.lastRecordedAlbum = lastRecordedAlbum;
    }

    public String getRecordingCompany() {
        return recordingCompany;
    }

    public String getLastRecordedAlbum() {
        return lastRecordedAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Musician musician = (Musician) o;
        return Objects.equals(recordingCompany, musician.recordingCompany) && Objects.equals(lastRecordedAlbum, musician.lastRecordedAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordingCompany, lastRecordedAlbum);
    }

    @Override
    public String toString() {
        return "Musician{" +
                "recordingCompany='" + recordingCompany + '\'' +
                ", lastRecordedAlbum='" + lastRecordedAlbum + '\'' +
                ", artistsName=" + artistsName +
                ", age=" + age +
                ", genres=" + Arrays.toString(genres) +
                ", awards=" + Arrays.toString(awards) +
                '}';
    }
}
