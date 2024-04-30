package problem1;

import java.util.Objects;

/**
 * Class Runner inherits from class Athlete, and stores information about a runner.
 */
public class Runner extends Athlete{

  private Double best5KRunTime;
  private Double bestHalfMarathonRunTime;
  private String favoriteRunningEvent;

  /**
   * Constructor for a Runner.
   * @param athletesName runner's name, consisting of first, middle and last name
   * @param height runner's height, represented as a Double (in feet)
   * @param weight runner's weight, represented as a Double (in pounds)
   * @param league runner's league, represented as a String
   * @param best5KRunTime runner's best 5K running time, as a Double
   * @param bestHalfMarathonRunTime runner's best half-marathon running time, as a Double
   * @param favoriteRunningEvent runner's favorite running event, as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
      super(athletesName, height, weight, league);
      this.best5KRunTime = best5KRunTime;
      this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
      this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructor for a Runner.
   * @param athletesName runner's name, consisting of first, middle and last name
   * @param height runner's height, represented as a Double (in feet)
   * @param weight runner's weight, represented as a Double (in pounds)
   * @param best5KRunTime runner's best 5K running time, as a Double
   * @param bestHalfMarathonRunTime runner's best half-marathon running time, as a Double
   * @param favoriteRunningEvent runner's favorite running event, as a String
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5KRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5KRunTime = best5KRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Getter for runner's best 5k run time.
   * @return best 5k run time, as a Double
   */
  public Double getBest5KRunTime() {
    return best5KRunTime;
  }

  /**
   * Getter for runner's best half-marathon time.
   * @return best half-marathon time as a Double.
   */
  public Double getBestHalfMarathonRunTime() {
    return bestHalfMarathonRunTime;
  }

  /**
   * Getter for runner's favorite running event.
   * @return favorite running event, as a String
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
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
    Runner runner = (Runner) o;
    return Objects.equals(best5KRunTime, runner.best5KRunTime) && Objects.equals(
        bestHalfMarathonRunTime, runner.bestHalfMarathonRunTime) && Objects.equals(
        favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5KRunTime, bestHalfMarathonRunTime,
        favoriteRunningEvent);
  }

  @Override
  public String toString() {
    return "Runner{}";
  }
}
