package problem1;

import java.util.Arrays;

public abstract class GraphicArtist extends AbstractArtist{

    protected String[] exhibits;

    public GraphicArtist(Name artistsName1, Integer age1, String[] genres1, String[] awards1,
                         String[] exhibits) throws InvalidAgeException {
        super(artistsName1, age1, genres1, awards1);
        this.exhibits = exhibits;
    }

    public String[] getExhibits() {
        return exhibits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GraphicArtist that = (GraphicArtist) o;
        return Arrays.equals(exhibits, that.exhibits);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(exhibits);
        return result;
    }
}
