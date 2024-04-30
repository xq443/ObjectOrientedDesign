package docsandvets;

import animals.AbstractLivingBeing;
import animals.Cat;
import animals.Person;

import java.util.Objects;

public abstract class AbstractProvider<T extends AbstractLivingBeing> extends Person {
    private PatientList<T> patients;

    public AbstractProvider(String firstname, String lastname, int maxPatients) {
        super(firstname, lastname);
        this.patients = new PatientList<T>(maxPatients);
    }


    public PatientList<T> getPatients() {
        return this.patients;
    }

    public void addPatient(T patient) {
        this.patients.addPatient(patient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractProvider<?> vet = (AbstractProvider<?>) o;
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
