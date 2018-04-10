import app.car.Car;

import app.user.User;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserUnitTests {
        private User user = new User("1212", "Tass", "Tass@email.ee","123123");
        @Test
        void getUserIdUnitTest() {
            assertEquals("1212", user.getUserId());
        }
        @Test
        void getUserNameUniTEst() {
            assertEquals("Tass", user.getUserName());
        }
        @Test
        void getUserEmailUnitTest() {
            assertEquals("Tass@email.ee", user.getUserEmail());
        }
        @Test
        void getUserTelephoneUnitTest() {
            assertEquals("123123", user.getUserPhoneNumber());
        }
    }

