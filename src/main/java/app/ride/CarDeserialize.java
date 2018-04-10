package app.ride;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import app.car.Car;

public class CarDeserialize extends JsonDeserializer<Car> {

	@Override
	public Car deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		/*int id = p.*/
		return null;
	}

}
