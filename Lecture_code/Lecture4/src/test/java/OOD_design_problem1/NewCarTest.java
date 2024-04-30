package OOD_design_problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class NewCarTest {

    private NewCar testCar;
    private String expectedID;
    private BodyType expectedBodyType;
    private Integer expectedManufacturingYear;
    private MakeModel expectedMakeModel;
    private Float expectedMsrp;
    private Integer expectedNumVehicledAvailable;

    @BeforeEach
    void setUp(){
        expectedID = "Vehicle_0012345";
        expectedBodyType = BodyType.SUV;
        expectedMakeModel = new MakeModel("Audi", "Q5");
        expectedManufacturingYear = 2021;
        expectedMsrp = 50000.0f;
        expectedNumVehicledAvailable = 50;
        testCar = new NewCar("Vehicle_0012345", 2021, new MakeModel("Audi", "Q5"),
                50000.0f, BodyType.SUV, 50);
    }

    @Test
    void getBodyType() {
        assertEquals(expectedBodyType, testCar.getBodyType());
    }

    @Test
    void getId() {
        assertEquals(expectedID, testCar.getId());
    }

    @Test
    void getManufacturingYear() {
        assertEquals(expectedManufacturingYear, testCar.getManufacturingYear());
    }

    @Test
    void getMakeModel() {
        assertEquals(expectedMakeModel, testCar.getMakeModel());
    }

    @Test
    void getMsrp() {
        assertEquals(expectedMsrp, testCar.getMsrp());
    }

    @Test
    void getNumVehiclesAvailable() {
        assertEquals(expectedNumVehicledAvailable, testCar.getNumVehiclesAvailable());
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash(testCar.getId(), testCar.getManufacturingYear(),
                testCar.getMakeModel(), testCar.getMsrp(), testCar.getBodyType(),
                testCar.getNumVehiclesAvailable());
        assertEquals(expectedHashCode, testCar.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "NewCar{" +
                "numVehiclesAvailable=" + testCar.getNumVehiclesAvailable() +
                ", bodyType=" + testCar.getBodyType() +
                ", id='" + testCar.getId() + '\'' +
                ", manufacturingYear=" + testCar.getManufacturingYear() +
                ", makeModel=" + testCar.getMakeModel() +
                ", msrp=" + testCar.getMsrp() +
                '}';
        assertEquals(expectedString, testCar.toString());
    }
}