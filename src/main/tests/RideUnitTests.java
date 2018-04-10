import app.car.Car;
import app.ride.Ride;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class RideUnitTests {
    private Car car = new Car();
    private Ride ride = new Ride("Tallinn", "Riga", new Date(), 12, 12, car);
    @Test
    void getRideStartPointUnitTest() {
        assertEquals("Tallinn", ride.getStartPoint());
    }
    @Test
    void getRideEndPointUnitTest() {
        assertEquals("Riga", ride.getEndPoint());
    }
    @Test
    void getRdideFreeSeatsUnitTest() {
        assertEquals(12, ride.getFreeSeats());
    }
    @Test
    void getRideFeeUnitTest() {
        assertEquals(12, ride.getRideFee());
    }
    @Test
    void getCarUnitTest() {
        assertEquals(car, ride.getRideCar());
    }
}
