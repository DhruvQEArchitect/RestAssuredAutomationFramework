package pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class Mapper {

    static ObjectMapper objectMapper;

    public static AirlinePojo getAirlineResponseMapper(Response response) {
        objectMapper = new ObjectMapper();
        AirlinePojo airlinePojo = null;
        try {
            airlinePojo = objectMapper.readValue(response.getBody().asString(), AirlinePojo.class);
        } catch (Exception ex) {

        }
        return airlinePojo;
    }


    public static ProductPojo getProductResponsePayload(Response response) {
        objectMapper = new ObjectMapper();
        ProductPojo productPojo = null;
        try {
            productPojo = objectMapper.readValue(response.getBody().asString(), ProductPojo.class);
        } catch (Exception ex) {

        }
        return productPojo;
    }



}
