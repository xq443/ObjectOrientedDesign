package genericpatientlist;

import animals.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person doolittle = new Person("Dr.", "Doolittle");
        Cat mittens = new Cat("Mittens", doolittle);
        Dog spot = new Dog("Spot", doolittle);
        AbstractLivingBeing milly = new Cow("Milly", doolittle);
        Horse ned = new Horse("Ned", doolittle);
        Canary delia = new Canary("Delia", doolittle);
        Parakeet polly = new Parakeet("Polly", doolittle);

        Vet<AbstractAnimal> drB = new Vet<>("Dr.", "Vet", 20);

        List<AbstractAnimal> animals = new ArrayList<>();

        AbstractLivingBeing drDoolitle = new Person("Dr.", "Doolittle");
        //animals.add(drDoolitle);
        animals.add(mittens);
        animals.add(spot);
        animals.add((AbstractAnimal) milly);  //this is not a safe down-cast
        animals.add(ned);
        animals.add(delia);
        animals.add(polly);

        for (AbstractAnimal animal: animals) {
            if (animal instanceof AbstractBird)
                drB.addPatient(animal);
        }

        System.out.println(drB.getPatients());

        //PatientList<AbstractNonHuman> patients = new PatientList<>(10);
        //patients.addPatient(doolittle);
        //patients.addPatient(milly);


    }
}
