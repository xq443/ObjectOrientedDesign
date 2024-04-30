package pair;

import java.util.Objects;

public class GenericTripleInheritance<X, Y, Z> extends GenericPair<X, Y>{

    private Z third;

    public GenericTripleInheritance(X first, Y second, Z third) {
        super(first, second);
        this.third = third;
    }

    public Z getThird() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GenericTripleInheritance<?, ?, ?> that = (GenericTripleInheritance<?, ?, ?>) o;
        return Objects.equals(third, that.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), third);
    }
}
