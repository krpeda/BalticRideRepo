package app.car;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;

import app.car.Car;

public class CarDeserialize extends JsonDeserializer<Car> {

	@Override
	public Car deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		long id = (Long) ((LongNode) node.get("id")).numberValue();
		String carRegistrationNumber = node.get("carRegistrationNumber").asText();
		String carModel = node.get("carModel").asText();
		int carYear = (Integer) ((IntNode) node.get("carYear")).numberValue();
		String userId = node.get("userId").asText();
		return new Car(id, carRegistrationNumber, carModel, carYear, userId);
	}

}
