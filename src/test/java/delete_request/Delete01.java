package delete_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonplaceholderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the URL
      Then
         Status code is 200
         And response body is like { }
     */

    @Test
    public void delete01() {
        // Set the url
        spec.pathParams("first","todos","second",198);

        // set the expected data
        Map<String,String> expectedData = new HashMap<>();

        // Send request and get response
        Response response=given().spec(spec).when().delete("/{first}/{second}");

        // Do assertions
        Map actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

        assertEquals(200, response.getStatusCode());

        // 1. Yol
        assertEquals(expectedData, actualData);

        // 2. yol
        assertTrue(actualData.isEmpty());

        // 3. yol
        assertEquals(0, actualData.size());
    }
}
