package dessert;

import java.util.Arrays;
import java.util.Objects;

public class Cookie extends Dessert {

    private Integer servingSize;

    public Cookie(String name, String[] flavors, Integer quantity, Float calories) {
        super(name, flavors, quantity, calories);
    }

    public Cookie(String name, String[] flavors, Integer quantity, Float calories, Integer servingSize) {
        super(name, flavors, quantity, calories);
        this.servingSize = servingSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Cookie cookie = (Cookie) o;
        return Objects.equals(servingSize, cookie.servingSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), servingSize);
    }

    @Override
    public String toString() {
        return "Cookie{" +
            "servingSize=" + servingSize +
            ", name='" + name + '\'' +
            ", flavors=" + Arrays.toString(flavors) +
            ", quantity=" + quantity +
            ", calories=" + calories +
            '}';
    }
}
