package dessert;

import java.util.Arrays;
import java.util.Objects;

public class Dessert {

    protected String name;
    protected String[] flavors = new String[10];
    protected Integer quantity;
    protected Float calories;

    public Dessert(String name, String[] flavors, Integer quantity, Float calories) {
        this.name = name;
        this.flavors = flavors;
        this.quantity = quantity;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public String[] getFlavors() {
        return flavors;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dessert dessert = (Dessert) o;
        return Objects.equals(name, dessert.name) && Arrays.equals(flavors,
            dessert.flavors) && Objects.equals(quantity, dessert.quantity)
            && Objects.equals(calories, dessert.calories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, quantity, calories);
        result = 31 * result + Arrays.hashCode(flavors);
        return result;
    }

    @Override
    public String toString() {
        return "Dessert{" +
            "name='" + name + '\'' +
            ", flavors=" + Arrays.toString(flavors) +
            ", quantity=" + quantity +
            ", calories=" + calories +
            '}';
    }
}
