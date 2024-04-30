package problem1;

import java.util.Arrays;

public class Painter extends GraphicArtist{

    public Painter(Name artistsName1, Integer age1, String[] genres1, String[] awards1,
                   String[] exhibits) throws InvalidAgeException {
        super(artistsName1, age1, genres1, awards1, exhibits);
    }

    @Override
    public String toString() {
        return "Painter{" +
                "exhibits=" + Arrays.toString(exhibits) +
                ", artistsName=" + artistsName +
                ", age=" + age +
                ", genres=" + Arrays.toString(genres) +
                ", awards=" + Arrays.toString(awards) +
                '}';
    }
}
