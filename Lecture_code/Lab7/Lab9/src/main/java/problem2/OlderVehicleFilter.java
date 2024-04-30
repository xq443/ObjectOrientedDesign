package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehicleFilter {

  private static final Integer CUTOFF_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();
  public OlderVehicleFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }
  public OlderVehicleFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3){
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }
  public void filterOlderVehilces(){
    //YOUR CODE HERE
    List<Vehicle> resultingVehicles = vehicles.stream().filter(x -> x.getYear() >= CUTOFF_YEAR).collect(
        Collectors.toList());

    //This is quite the approach because it prints out the entire vehicle information
    //resultingVehicles.stream().forEach(System.out::println);

    //First approach
    resultingVehicles.stream().map(x -> x.getMake() + " " + x.getModel() + "" + x.getYear())
                      .forEach(System.out::println);

    //Second approach
    resultingVehicles.stream().map(x -> OlderVehicleFilter.mapToMakeModelYear(x))
                    .forEach(System.out::println);

    //Third approach
    resultingVehicles.stream().forEach(x -> OlderVehicleFilter.printVehicleInfo(x));

    //All put together
    vehicles.stream().filter(x -> x.getYear() >= CUTOFF_YEAR)
            .map(y -> y.getMake() + " " + y.getModel() + " " + y.getYear())
            .forEach(System.out::println);
  }
  
  private static String mapToMakeModelYear(Vehicle vehicle){
    return new String(vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
  }

  private static void printVehicleInfo(Vehicle vehicle){
    System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
  }
}