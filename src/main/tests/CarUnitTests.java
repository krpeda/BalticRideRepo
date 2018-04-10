import app.car.Car;
import app.ride.Ride;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarUnitTests {
        private Car car = new Car(1222,"123 abc","BMW", 1998, "123asd");
        @Test
        void getCarIdUnitTest() {
            assertEquals(1222, car.getCarId());
        }
        @Test
        void getRegistrationNumberUnitTest() {
            assertEquals("123 abc", car.getCarRegistrationNumber());
        }
        @Test
        void getModelUnitTest() {
            assertEquals("BMW", car.getCarModel());
        }
        @Test
        void getCarYearUnitTest() {
            assertEquals(1998, car.getCarYear());
        }
        @Test
        void getUserIdUnitTest() {
            assertEquals("123asd", car.getUserId());
        }
    }

