package animals;

public abstract class AbstractAnimal extends AbstractLivingBeing {
    protected Person owner;

    public AbstractAnimal(String firstName, Person owner) {
        super(firstName, owner.getLastName());
        this.owner = owner;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person newOwner) {
        this.owner = newOwner;
        this.setLastName(this.owner.getLastName());
    }
}
