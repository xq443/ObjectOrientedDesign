(a) input validation:
```agsl
public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team, Double avgBattingScore, Integer seasonHomeRuns) throws InvalidBattingScoreException {
    super(athletesName, height, weight, league); 
    if(this.validateAvgBattingScore(avgBattingScore)) {
        this.team = team;
        this.avgBattingScore = avgBattingScore; this.seasonHomeRuns = seasonHomeRuns;
    } 
}
```
if the avgBattingScore does not satisfy the condition of validateAvgBattingScore() method,
then the exception InvalidBattingScoreException("This is not a valid batting score!") will show.



(b) inheritance
```agsl
public class Runner extends Athlete {
    private Double best5KTime;
    private Double bestHalfMarathonTime; private String favoriteRunningEvent;

    public Runner(Name athletesName, Double height, Double weight, String league, Double best5KTime, Double bestHalfMarathonTime, String favoriteRunningEvent) {
        super(athletesName, height, weight, league); this.best5KTime = best5KTime; this.bestHalfMarathonTime = bestHalfMarathonTime; this.favoriteRunningEvent = favoriteRunningEvent;
    }

    public Runner(Name athletesName, Double height, Double weight, Double best5KTime, Double bestHalfMarathonTime, String favoriteRunningEvent) {
        super(athletesName, height, weight); 
        this.best5KTime = best5KTime; 
        this.bestHalfMarathonTime = bestHalfMarathonTime; 
        this.favoriteRunningEvent = favoriteRunningEvent;
    }
    ...
}
```
The Runner class inherits from the Athlete class, and in the constructor, it also inherits from the Athlete's attributes.

(c) method overriding
```agsl
@Override
public String toString() {
    return "Name{" +
    "firstName=’" + firstName + ’\’’ +
    ", middleName=’" + middleName + ’\’’ + ", lastName=’" + lastName + ’\’’ + ’}’;
}
```
This toString() method overrides the original toString() method with the customized arguments in output:
with firstName, middleName and lastName.

(d) casting
```agsl
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
    Runner runner = (Runner) o;
    return Objects.equals(best5KTime, runner.best5KTime) && Objects.equals( bestHalfMarathonTime, runner.bestHalfMarathonTime) && Objects.equals( favoriteRunningEvent, runner.favoriteRunningEvent);
}

```
Runner runner = (Runner) o; this line is to cast the o in Object type into Runner type.

(e) method overloading
```agsl
public class Athlete {
    protected Name athletesName; 
    protected Double height; 
    protected Double weight; 
    protected String league;

    public Athlete(Name athletesName, Double height, Double weight, String league) { this.athletesName = athletesName;
        this.height = height;
        this.weight = weight;
        this.league = league; 
    }
    
    public Athlete(Name athletesName, Double height, Double weight) { this.athletesName = athletesName;
        this.height = height;
        this.weight = weight;
        this.league = null; 
    }
    ...
}
```

Constructor 1: four args (Name, height, weight, and league).
Constructor 2: three args (Name, height, and weight).
The second constructor differs in the args without league comparing to the first one.