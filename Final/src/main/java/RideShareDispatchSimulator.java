import controller.RideController;
import service.ValidateInputService;
import exception.InvalidInputException;

/**
 * The RideShareDispatchSimulator class is the entry point
 * for the ride dispatch simulation application.
 */
public class RideShareDispatchSimulator {

  /**
   * The main method of the application.
   *
   * @param args The command-line arguments.
   * Expects the number of drivers as the first argument.
   */
  public static void main(String[] args) {
    try {
      // Validate and retrieve the number of drivers from the command-line arguments
      int numDrivers = ValidateInputService.validateNumberOfDrivers(args);

      // Proceed with simulation using numDrivers
      RideController simulator = new RideController();
      simulator.simulate(numDrivers);
    } catch (Exception e) {
      // Handle invalid input exceptions
      System.out.println(e.getMessage());
    }
  }
}
