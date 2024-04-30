package problem2;

import java.util.ArrayList;
import java.util.List;

public class OlderVehiclesFilter {

  private static final Integer CUTOFF_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();
  public OlderVehiclesFilter(List<Vehicle> vehicles) { this.vehicles = vehicles;
  }
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3){
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }
  public void filterOlderVehicles(){
    List<Vehicle> ret = vehicles.stream().filter(x -> x.getYear() >= CUTOFF_YEAR)
        .toList();

    // ret.forEach(System.out::println);
    ret.stream().map(x -> x.getMake() + " " + x.getModel() + " " + x.getYear())
        .forEach(System.out::println);

    ret.stream().map(OlderVehiclesFilter::mapToMakeModelYear)
        .forEach(System.out::println);

    ret.forEach(OlderVehiclesFilter::printVehicleInfo);

    vehicles.stream().filter(x -> x.getYear() >= CUTOFF_YEAR)
        .map(y -> y.getMake() + " " + y.getModel() + " " + y.getYear())
        .forEach(System.out::println);
  }

  private static String mapToMakeModelYear(Vehicle vehicle) {
    return vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear();
  }

  private static void printVehicleInfo(Vehicle vehicle) {
    System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear());
  }
}