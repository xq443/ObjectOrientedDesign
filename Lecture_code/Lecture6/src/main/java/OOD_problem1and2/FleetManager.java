package problem1and2;

public class FleetManager {

  public FleetManager() {
  }

  TripReport drive(float distance, Vehicle vehicle){
    return new TripReport(vehicle, vehicle.getAverageSpeed(), distance,
        this.getDuration(distance, vehicle.getAverageSpeed()));
  }

  //Ad hoc polymorphism - example 1
  TripReport drive(int duration, Vehicle vehicle){
    return new TripReport(vehicle, vehicle.getAverageSpeed(),
        this.getDistance(duration, vehicle.getAverageSpeed()), duration);
  }

  //Ad hoc polymorhism - example 2
  TripReport drive(Vehicle vehicle, float speed, float distance){
    checkSpeed(speed);
    checkDistance(distance);
    return new TripReport(vehicle, speed, distance, Math.round(distance/speed));
  }

  //this doesn't work because method signatures are the same
  //TripReport drive(Vehicle vehicle, float distance, float speed){
  //
  //}

  //Ad hoc polymorphism - example 3
  TripReport drive(Vehicle vehicle, float speed, float distance, int duration)
      throws InvalidDurationException {
    checkDistance(distance);
    checkSpeed(speed);
    checkDuration(duration, speed, distance);
    return new TripReport(vehicle, speed, distance, duration);
  }

  private Boolean checkDuration(int duration, float speed, float distance)
      throws InvalidDurationException{
    if(duration > 0 && duration == distance/speed)
      return Boolean.TRUE;
    else throw new InvalidDistanceException("Duration has to be strictly positive, "
        + "and has to match distance and speed ratio!");
  }

  private Float getDistance(int duration, float speed){
    if ((duration > 0) && (speed > 0))
      return duration*speed;
    else throw new InvalidDistanceException("Duration and speed have to "
        + "be strictly positive!");

  }

  private Integer getDuration(float distance, float speed) throws
      InvalidDistanceException, InvalidSpeedException{
    this.checkDistance(distance);
    this.checkSpeed(speed);
    return Math.round(distance / speed);
  }

  private boolean checkDistance(float distance) {
    if(distance > 0)
      return Boolean.TRUE;
    else throw new InvalidDistanceException("Distance has to be strictly positive.");
  }

  private boolean checkSpeed(float speed){
    if(speed > 0)
      return Boolean.TRUE;
    else throw new InvalidSpeedException("Speed has to be strictly positive.");
  }
}
