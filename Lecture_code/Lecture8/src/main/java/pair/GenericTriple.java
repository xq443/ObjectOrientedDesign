package pair;

import java.util.Objects;

public class GenericTriple<X, Y, Z> {

    private GenericPair<X, Y> xAndYCoordinates;
    private Z zCoordinate;

    public GenericTriple(GenericPair<X, Y> xAndYCoordinates, Z zCoordinate) {
        this.xAndYCoordinates = xAndYCoordinates;
        this.zCoordinate = zCoordinate;
    }

    public GenericPair<X, Y> getxAndYCoordinates() {
        return xAndYCoordinates;
    }

    public Z getzCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericTriple<?, ?, ?> that = (GenericTriple<?, ?, ?>) o;
        return Objects.equals(xAndYCoordinates, that.xAndYCoordinates) && Objects.equals(zCoordinate, that.zCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAndYCoordinates, zCoordinate);
    }
}
