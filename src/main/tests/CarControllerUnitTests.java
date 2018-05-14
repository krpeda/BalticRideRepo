
import app.car.Car;
import app.car.CarController;
import app.user.User;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CarControllerUnitTests {
        @Autowired
        private MockMvc mvc;
        @MockBean
        private CarController carController;

        @Test
        public void getUserCarsByIdTest() throws Exception {
            User user = new User("21", "Tass", "Tass@gmail.com", "5820299");
            List<Car> carList = new ArrayList<>();
            Car car = new Car();

            given(carController.addCar(car));

            mvc.perform(get("/user/" + user.getUserId() + "/cars"))
                    .andExpect(status().isOk()).andExpect(content().json(""));
        }

}
