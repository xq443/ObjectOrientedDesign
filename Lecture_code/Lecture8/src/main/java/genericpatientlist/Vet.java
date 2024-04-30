package genericpatientlist;

import animals.AbstractAnimal;
import animals.Person;

import java.util.Objects;

public class Vet<T extends AbstractAnimal> extends Person {

    private PatientList<T> patients;

    public Vet(String firstname, String lastname, int maxPatients) {
        super(firstname, lastname);
        this.patients = new PatientList<T>(maxPatients);
    }


    public PatientList<T> getPatients() {
        return this.patients;
    }

    public void addPatient(AbstractAnimal patient) {

        this.patients.addPatient((T) patient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vet<?> vet = (Vet<?>) o;
        return patients.equals(vet.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patients);
    }

    @Override
    public String toString() {
        return "Vet{" +
                "patients=" + patients +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
