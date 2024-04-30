package problem1;

import java.util.Arrays;

public class Actor extends MultimediaArtist{

    public Actor(Name artistsName1, Integer age1, String[] genres1, String[] awards1,
                 String[] movies, String[] series, String[] otherMultimedia) throws InvalidAgeException {
        super(artistsName1, age1, genres1, awards1, movies, series, otherMultimedia);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "movies=" + Arrays.toString(movies) +
                ", series=" + Arrays.toString(series) +
                ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
                ", artistsName=" + artistsName +
                ", age=" + age +
                ", genres=" + Arrays.toString(genres) +
                ", awards=" + Arrays.toString(awards) +
                '}';
    }
}
