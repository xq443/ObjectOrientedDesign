package problem1;

import java.util.Objects;

public class BaseballPlayer extends Athlete{

  private String team;
  private Double avgBattingScore;
  private Integer seasonHomeRuns;

  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public String getTeam() {
    return team;
  }

  public Double getAvgBattingScore() {
    return avgBattingScore;
  }

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
    return Objects.equals(team, that.team) && Objects.equals(avgBattingScore,
        that.avgBattingScore) && Objects.equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBattingScore, seasonHomeRuns);
  }

  @Override
  public String toString() {
    return "BaseballPlayer{}";
  }
}
