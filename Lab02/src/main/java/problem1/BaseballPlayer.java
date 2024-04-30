package problem1;

import java.util.Objects;

/**
 * Class BaseballPlayer inherits from class Athlete, and stores information about a BaseballPlayer.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double avgBatting;
  private Integer seasonHomeRuns;

  /**
   * Constructs a BaseballPlayer object with specified attributes.
   *
   * @param athletesName   The name of the athlete.
   * @param height         The height of the athlete.
   * @param weight         The weight of the athlete.
   * @param league         The league the athlete belongs to.
   * @param team           The baseball team the player is part of.
   * @param avgBatting     The batting average of the player.
   * @param seasonHomeRuns The number of home runs scored by the player in a season.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double avgBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBatting = avgBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Constructs a BaseballPlayer object with specified attributes.
   *
   * @param athletesName   The name of the athlete.
   * @param height         The height of the athlete.
   * @param weight         The weight of the athlete.
   * @param team           The baseball team the player is part of.
   * @param avgBatting     The batting average of the player.
   * @param seasonHomeRuns The number of home runs scored by the player in a season.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.avgBatting = avgBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Gets the baseball team the player is part of.
   *
   * @return The team of the baseball player, as a String.
   */
  public String getTeam() {
    return team;
  }

  /**
   * Gets the batting average of the player.
   *
   * @return The batting average of the baseball player, as a Double.
   */
  public Double getAvgBatting() {
    return avgBatting;
  }

  /**
   * Getter for the number of home runs scored by the player in a season.
   *
   * @return The season home runs of the baseball player, represented as integer.
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
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
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) && Objects.equals(avgBatting,
        that.avgBatting) && Objects.equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBatting, seasonHomeRuns);
  }

  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", avgBatting=" + avgBatting +
        ", seasonHomeRuns=" + seasonHomeRuns +
        '}';
  }
}
