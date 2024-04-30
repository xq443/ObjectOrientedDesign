package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Poet extends AbstractArtist{

    private String publishingCompany;
    private String lastPublishedCollection;

    public Poet(Name artistsName1, Integer age1, String[] genres1, String[] awards1, String publishingCompany,
                String lastPublishedCollection) throws InvalidAgeException {
        super(artistsName1, age1, genres1, awards1);
        this.publishingCompany = publishingCompany;
        this.lastPublishedCollection = lastPublishedCollection;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public String getLastPublishedCollection() {
        return lastPublishedCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Poet poet = (Poet) o;
        return Objects.equals(publishingCompany, poet.publishingCompany) && Objects.equals(lastPublishedCollection, poet.lastPublishedCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
    }

    @Override
    public String toString() {
        return "Poet{" +
                "publishingCompany='" + publishingCompany + '\'' +
                ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
                ", artistsName=" + artistsName +
                ", age=" + age +
                ", genres=" + Arrays.toString(genres) +
                ", awards=" + Arrays.toString(awards) +
                '}';
    }
}
