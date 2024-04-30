package OOD_design_problem1;

import java.util.Objects;

public class MakeModel {

    private String make;
    private String model;

    public MakeModel(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeModel makeModel = (MakeModel) o;
        return Objects.equals(make, makeModel.make) && Objects.equals(model, makeModel.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model);
    }

    @Override
    public String toString() {
        return "MakeModel{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
