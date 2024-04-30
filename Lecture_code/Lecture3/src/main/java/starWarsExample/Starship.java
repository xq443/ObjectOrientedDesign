package starWarsExample;

public class Starship {

    private static final Double MIN_LEVEL = 0.0;
    private static final Double MAX_LEVEL = 100.0;
    protected Double fuelLevel;
    protected Double destructionLevel;

    public Starship(){
        this.fuelLevel = MAX_LEVEL;
        this.destructionLevel = MIN_LEVEL;
    }

    private Starship(Double fuelLevel, Double destructionLevel) {
        this.fuelLevel = fuelLevel;
        this.destructionLevel = destructionLevel;
    }

    private Boolean validateFuelLevel(Double fuelLevel){
        return fuelLevel > MIN_LEVEL && (this.fuelLevel + fuelLevel) <= MAX_LEVEL;
    }

    private Boolean validateDestructionLevel(Double destructionLevel) {
        return destructionLevel > 0 && (this.destructionLevel + destructionLevel) <= MAX_LEVEL;
    }

    public Double changeFuelLevel(Double fuelLevel) throws InvalidFuelLevelException {
        //if(validateFuelLevel(fuelLevel))
         //   this.fuelLevel += fuelLevel; //this.fuelLevel = this.fuelLevel + fuelLevel;
        //return this.fuelLevel;

        //Expended version
        /*
        if(validateFuelLevel(fuelLevel)){
            this.fuelLevel += fuelLevel; //this.fuelLevel = this.fuelLevel + fuelLevel;
            return this.fuelLevel;
            }
        else return this.fuelLevel;

        //More user friendly design
         if(!validateFuelLevel(fuelLevel))
            System.out.println("This fuel level is not valid. Leaving the levels unchanged.)
        else
            this.fuelLevel += fuelLevel; //this.fuelLevel = this.fuelLevel + fuelLevel;
        return this.fuelLevel;
    //}
         */

        //Exception version
        //More user friendly design
        if(!validateFuelLevel(fuelLevel))
            throw new InvalidFuelLevelException("Invalid fuel level!");
        else
            this.fuelLevel += fuelLevel; //this.fuelLevel = this.fuelLevel + fuelLevel;
        return this.fuelLevel;
    }

    public Starship changeDestructionLevel(Double destructionLevel) throws InvalidDestructionLevelException {
        if(!validateDestructionLevel(destructionLevel))
            throw new InvalidDestructionLevelException("Invalid destruction level!");
        else
            return new Starship(this.fuelLevel, this.destructionLevel + destructionLevel);

        //BAD CODE
        //this.destructionLevel += destructionLevel;
        // return new Starship(this.fuelLevel, this.destructionLevel);
    }
}
