package problem1;

import java.util.Objects;

/**
 * Class Runner inherits from class Athlete, and stores information about a runner.
 */
public class Runner extends Athlete{
  private Double best5kRunTime;
  private Double bestHalfMarathonRunTime;

  private String favoriteRunningEvent;

  /**
   * Constructor for a Runner.
   * @param athletesName runner's name, consisting of first, middle and last name
   * @param height runner's height, represented as a Double(in feet)
   * @param weight runner's weight, represented as a Double(in pounds)
   * @param league runner's league, represented as a String
   * @param best5kRunTime runner's best 5K running time, as a Double
   * @param bestHalfMarathonRunTime runner's best half-marathon running time, as a Double
   * @param favoriteRunningEvent runner's favorite running event, as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5kRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);

    this.best5kRunTime = best5kRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructor for a Runner.
   * @param athletesName runner's name, consisting of first, middle and last name
   * @param height runner's height, represented as a Double(in feet)
   * @param weight runner's weight, represented as a Double(in pounds)
   * @param best5kRunTime runner's best 5K running time, as a Double
   * @param bestHalfMarathonRunTime runner's best half-marathon running time, as a Double
   * @param favoriteRunningEvent runner's favorite running event, as a String
   */

  public Runner(Name athletesName, Double height, Double weight, Double best5kRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5kRunTime = best5kRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Getter for runner's best half-marathon running time
   * @return  best half-marathon running time, as a Double
   */

  public Double getBestHalfMarathonRunTime() {
    return bestHalfMarathonRunTime;
  }

  /**
   * Getter for runner's favorite running event
   * @return runner's favorite running event, as a String
   */

  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }
  /**
   * Getter for runner's best 5K run time
   * @return best 5K running time, as a Double
   */

  public Double getBest5kRunTime() {
    return best5kRunTime;
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
    return Objects.equals(best5kRunTime, runner.best5kRunTime) && Objects.equals(
        bestHalfMarathonRunTime, runner.bestHalfMarathonRunTime) && Objects.equals(
        favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5kRunTime, bestHalfMarathonRunTime,
        favoriteRunningEvent);
  }

  @Override
  public String toString() {
    return "Runner{" +
        "best5kRunTime=" + best5kRunTime +
        ", bestHalfMarathonRunTime=" + bestHalfMarathonRunTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        '}';
  }
}
