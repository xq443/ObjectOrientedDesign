## Report

### Overview of solution: Option 1

The Rideshare Dispatch Simulator utilizes an event-driven approach to model ride requests and driver assignments. Employing the Model-View-Controller (MVC) architecture, it separates to manage data, presentation, and logic, ensuring scalability and maintainability to mock the simulation scenarios with varying driver and the number of rides.

### How to Run:

click Run botton EDIT CONFIGURATIONS to input your argument which represents the number of the drivers, whichs should be a positive integer.
Enter 'RideShareDispatchSimulator' file to start the simulator

OR

```agsl
cd src/main/java

javac RideShareDispatchSimulator.java

java RideShareDispatchSimulator.java 50

find . -type f -name "*.class" -delete
```

### Key challenges: 


Key challenges included managing the interactions between the time-window like ride requests and assignments, and keep the simulated process of mocking the request, assign and complete steps. Ensuring efficient data structures for tracking rides and drivers, and defining rules for prioritizing ride assignments based on ride type and anticipated distance. 

These challenges were addressed by carefully designing the system architecture using the MVC pattern to separate concerns. Also, implementing priority queues to handle ride requests and active rides , and devising customized rules for assigning rides such as ride type and distance priority. 

### Reference:

Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Westford, Massachusess, United States: Addison-Wesley.

### Output Samples:

Number of Drivers: 50
```
Simulation Scenario Information:
Number of Drivers: 50
Number of Rides: 25

Average wait time for a ride: 0.0 s
Average number of rides a driver has handled: 0.5

Simulation Scenario Information:
Number of Drivers: 50
Number of Rides: 100

Average wait time for a ride: 14.937280000000001 s
Average number of rides a driver has handled: 2.0

Simulation Scenario Information:
Number of Drivers: 50
Number of Rides: 250

Average wait time for a ride: 16.306288000000002 s
Average number of rides a driver has handled: 5.0
```
Number of Drivers = 20
```
Simulation Scenario Information:
Number of Drivers: 20
Number of Rides: 25

Average wait time for a ride: 9.98964 s
Average number of rides a driver has handled: 1.25

Simulation Scenario Information:
Number of Drivers: 20
Number of Rides: 100

Average wait time for a ride: 15.16799 s
Average number of rides a driver has handled: 5.0

Simulation Scenario Information:
Number of Drivers: 20
Number of Rides: 250

Average wait time for a ride: 15.371319999999999 s
Average number of rides a driver has handled: 12.5

```

### Write-up answers:

1. Please include a code snippet showing how have you used inheritance and composition in your code.
Inheritance: InvalidInputException is a subclass of Exception, and it inherits all the properties and behaviors of the Exception class. 
```
public class InvalidInputException extends Exception{

  public InvalidInputException(String message) {
    super(message);
  }
}

```

Composition: RideController contains a CustomerService object, allowing it to delegate customer-related operations to the CustomerService class, which demonstrating composition.
```
public class RideController {
    private CustomerService customerService;

    public RideController() {
        this.customerService = new CustomerService();
    }

    // Other methods of RideController...
}

public class CustomerService {
    // Methods for handling customer-related operations
}
```

2. Please include a code snippet showing how have you used an interface or an abstract class in your code.

The RideService interface declares methods for simulating scenarios, requesting rides, assigning rides, 
and completing assigned rides. This interface defines the behavior that any class implementing it must provide.
the RideServiceImpl class implements this interface and provides the concrete implementation of these methods.
```
public interface RideService {
  
    void requestRide(Ride ride);

    void assignRides();
    ...
}

public class RideServiceImpl implements RideService {
    // Implementation of methods from RideService interface
}

```
3. Please include code example of a method overriding and method overloading from your code, or explain why you have not used any overloading or overriding.

```
// Method Overriding: Overrides equals, hashCode, and toString methods in Customer and Ride classes
@Override
public boolean equals(Object o) {...}

// Method Overriding: Overrides equals, hashCode, and toString methods in Customer and Ride classes
@Override
public int hashCode() {...}

// Method Overriding: Overrides equals, hashCode, and toString methods in Customer and Ride classes
@Override
public String toString() {...}
```

4. Please include a code example showing how have you used encapsulation, or explain why you did not need encapsulation in your code.

Encapsulation of input validation and simulation logic:
```

public class RideShareDispatchSimulator {
  public static void main(String[] args) {
    try {
      int numDrivers = ValidateInputService.validateNumberOfDrivers(args);
      // Proceed with simulation using numDrivers
      RideController simulator = new RideController(numDrivers);
      simulator.simulate(numDrivers);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
  ...
}
```
5. Please include a code example of subtype polymorphism from your code, or explain why you did not need subtype polymorphism.

In the provided code snippet, i dont invoke subtype polymorphism because for different types of rides, i incorperate enum class and use it as a property named RideType with certain given priority, which makes the design clear and simple. 


6. Please include a code snippet of generics from your code.

```
// Generics: PriorityQueues using generics
private PriorityQueue<Ride> rideRequested;
private PriorityQueue<Ride> activeRides;
private PriorityQueue<Ride> completeRides;
```

7. Please include a code snippet showing how have you used some of the built-in data collections from the Java Collections Framework, or explain why you had no need for any data collections.

```
// Java Collections Framework: PriorityQueues used in RideController: we need first in first out ADT for rides
private PriorityQueue<Ride> rideRequested;
private PriorityQueue<Ride> activeRides;
private PriorityQueue<Ride> completeRides;
```

8. Please include a code snippet showing how have you used interfaces Iterable and Iterator, or explain why you had no need for these two interfaces.

Java collections utilized in my code like List, Set, or Queue, they already provide built-in iteration mechanisms (e.g., using for loops).
Also, the code may not have required complex iteration logic or custom iteration behavior. In such cases, using standard iteration for loop provided by Java collections have been sufficient without the need for implementing custom iterable or iterator logic.


9. Please include a code snippet showing how have you used interfaces Comparable and Comparator, or explain why you had no need for these two interfaces.

```
// Comparator used in RideController for custom ordering of rides
    this.rideRequested = new PriorityQueue<>(new Comparator<Ride>() {
      @Override
      public int compare(Ride ride1, Ride ride2) {
        if (isHigherPriority(ride1, ride2)) {
          return -1; // ride1 has higher priority
        } else if (isHigherPriority(ride2, ride1)) {
          return 1; // ride2 has higher priority
        } else {
          // If neither ride has higher priority, compare the request time
          return Long.compare(ride1.getRequestTime(), ride2.getRequestTime());
        }
      }
    });
```

10. Please include a code snippet showing how have you used regular expressions, or explain why you had no need for it.

The POSITIVE_INTEGER_REGEX constant defines the pattern for a positive integer.
```
private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
...

public static int validateNumberOfDrivers(String[] input) throws InvalidInputException {
    ...
    try {
        int numDrivers = Integer.parseInt(input[0]);
        if (!Pattern.matches(POSITIVE_INTEGER_REGEX, input[0])) {
            throw new InvalidInputException(ERROR_INVALID_POSITIVE_INTEGER);
        }
        return numDrivers;
    } catch (NumberFormatException e) {
        throw new InvalidInputException(ERROR_INVALID_NUMBER_FORMAT);
    }
}
```

11. Please include a code snippet showing how have you used nested classes, or justify why you had no need for nested classes.

Nested classes weren't used in my code. Nested classes can be beneficial for encapsulating helper or utility classes within the scope of another class, improving code organization and readability. However, I‘ve seperated the classes for decoupling purpose and clearer layout.

13. Please include code example showing how have you used components of functional programming, such as lambdas and streams, or explain why you had no need for it in your code.

Lambdas are utilized in the comparator provided to the PriorityQueue constructor in the RideController class. 
This lambda expression defines a custom comparison logic for rides in the priority queue
 ```
 this.rideRequested = new PriorityQueue<>((ride1, ride2) -> {
    if (isHigherPriority(ride1, ride2)) {
        return -1; // ride1 has higher priority
    } else if (isHigherPriority(ride2, ride1)) {
        return 1; // ride2 has higher priority
    } else {
        // If neither ride has higher priority, compare the request time
        return Long.compare(ride1.getRequestTime(), ride2.getRequestTime());
    }
});
```


14. Please include code snippet(s) showing how have you used creational, structural and/or behavioral design patterns. Please list which design patterns have you used, or explain why you had no need for design patterns in your solution.

Creational design pattern:
with factory method utilization: to encapsulate the ride object creation logic.
In this case, createRandomRide() encapsulates the logic for generating random values to construct a Ride object, providing a convenient way to create random rides without cluttering the client code with the details of random value generation.
```
public class RideFactory {
  public static Ride createRide() {
  ...
    // Creating the random ride object
    return new Ride(new Customer(customerId), startingLocation, desiredLocation,
        anticipatedRideDistance, rideRequestedTime, rideType, rideStartTime,
        rideStartTime, rideDuration);
  }
}

```

Structural Pattern:
The Composite pattern is well suited to model the hierarchical relationship among the classes: Customer and Ride. This pattern enables a Ride object to contain a customer objects. 
```
public class Ride {
  private Customer customer;
  private String startingLocation;
  private String desiredLocation;

  private double anticipatedDistance;
  private long requestTime;
  private RideType rideType;
  private long startTime;
  private long endTime;
  private double length;

  public Ride(Customer customer, String startingLocation, String desiredLocation,
      double anticipatedDistance, long requestTime, RideType rideType, long startTime, long endTime,
      double length) {
    this.customer = customer;
    this.startingLocation = startingLocation;
    this.desiredLocation = desiredLocation;
    this.anticipatedDistance = anticipatedDistance;
    this.requestTime = requestTime;
    this.rideType = rideType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.length = length;
  }
  ...
```
15. Please include code snippets showing examples of MVC architecture, or justify why you had no need for MVC architecture in your design. 

As Gamma, Helm, Johnson, and Vlissides suggested (1994), 
The Model-View-Controller (MVC) design pattern is utilized to separate an application's data model, user interface, and control logic into distinct components, enhancing maintainability and scalability. By decoupling concerns and promoting modularity, MVC fosters code reusability, testability, and parallel development, leading to more robust and adaptable software solutions.

Here in my case, the code structure includes: RideController (controller), RideService (service), RideView (view).
The point that needs to be mentioned is that I add the service layer for better decoupling which contains the business logic,
which connects the model and controller.

Model example: it provides the entity's properties. 
```
public class Ride {
  private String rideId;
  private Customer customer;
  private String startingLocation;
  private String desiredLocation;

  private double anticipatedDistance;
  private long requestTime;
  private RideType rideType;
  private long startTime;
  private long endTime;
  private double length;

  public Ride(Customer customer, String startingLocation, String desiredLocation,
      double anticipatedDistance, long requestTime, RideType rideType, long startTime, long endTime,
      double length) {
    this.rideId = generateRideId();
    this.customer = customer;
    this.startingLocation = startingLocation;
    this.desiredLocation = desiredLocation;
    this.anticipatedDistance = anticipatedDistance;
    this.requestTime = requestTime;
    this.rideType = rideType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.length = length;
  }

...

```
Controller snippet: it manages the MODEL and presents the VIEW
 ```
 public class RideController {

  private PriorityQueue<Ride> rideRequested;
  private PriorityQueue<Ride> activeRides;
  private PriorityQueue<Ride> completeRides;

  private RideView view;
  private int availableDrivers;

  public RideController(int numberOfDrivers) {
    this.rideRequested = new PriorityQueue<>(new Comparator<Ride>() {
      @Override
      public int compare(Ride ride1, Ride ride2) {
        if (isHigherPriority(ride1, ride2)) {
          return -1; // ride1 has higher priority
        } else if (isHigherPriority(ride2, ride1)) {
          return 1; // ride2 has higher priority
        } else {
          // If neither ride has higher priority, compare the request time
          return Long.compare(ride1.getRequestTime(), ride2.getRequestTime());
        }
      }
    });

    this.activeRides = new PriorityQueue<>(Comparator.comparingLong(Ride::getStartTime));
    this.completeRides = new PriorityQueue<>(Comparator.comparingLong(Ride::getEndTime));
    this.view = new RideView();
    this.availableDrivers = numberOfDrivers;
  }

  public void requestRide(Ride ride) {
    rideRequested.offer(ride);
    view.displayRideRequested(ride);
  }

....
}

 ```
 View: it connects with the how the outputs are generated or displayed.
 ```
 public class RideView {
  ...
  public void displayAverageWaitTime(double averageWaitTime) {
    System.out.println("Average wait time for a ride: " + averageWaitTime);
  }

  public void displayAverageRidesPerDriver(double averageRidesPerDriver) {
    System.out.println("Average number of rides a driver has handled: " + averageRidesPerDriver);
  }
  ...
}

 ```
16. Please include code examples showing data and stamp coupling in your code.

Data coupling: data coupling can be observed in RideService which creates Ride objects using createRandomRide() and passes them to RideController via requestRide(ride) method. This shows data coupling between RideService and RideController.

```
public void simulate(int numberOfDrivers, int numberOfRides) {
    // Initialize the RideController with the specified number of drivers
    rideController.initialize(numberOfDrivers);

    // Simulate the specified number of ride requests
    for (int i = 0; i < numberOfRides; i++) {
        Ride ride = createRandomRide(); // Creating Ride objects here
        rideController.requestRide(ride); // Passing Ride objects to RideController
    }

    rideController.assignRides();

    // Complete rides
    rideController.completeAssignedRides();

    // Calculate and display average wait time and average rides per driver
    double averageWaitTime = calculateAverageWaitTime();
    double averageRidesPerDriver = calculateAverageRidesPerDriver(numberOfDrivers);
    rideView.displayAverageWaitTime(averageWaitTime);
    rideView.displayAverageRidesPerDriver(averageRidesPerDriver);
}

```
Stamp Coupling: the Ride class represents a single entity that encapsulates all the information related to a ride, including customer details, locations, distance, timestamps, etc. Any module interacting with Ride class would be tightly coupled to the entire data structure of a ride, demonstrating stamp coupling (Gamma, Helm, Johnson, & Vlissides, 1994).
```
public class Ride {
    private Customer customer;
    private String startingLocation;
    private String desiredLocation;
    private double anticipatedDistance;
    private long requestTime;
    private RideType rideType;
    private long startTime;
    private long endTime;
    private double duration;

    // Constructor, getters, and setters omitted for brevity
}
...
```
## conclustions:
By adhering to these design pattern guidelines, the system not only promotes code reusability and extensibility, but also reduces class coupling. This facilitates the accommodation of new requirements (Gamma, Helm, Johnson, & Vlissides, 1994).Along with the MVC architecture, a modular, flexible, and maintainable theater reservation system can be deployed with efficiency.
