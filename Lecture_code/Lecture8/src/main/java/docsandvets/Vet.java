package docsandvets;

import animals.AbstractAnimal;

public class Vet<T extends AbstractAnimal> extends AbstractProvider<T> {
    public Vet(String firstname, String lastname, int maxPatients) {
        super(firstname, lastname, maxPatients);
    }
}
