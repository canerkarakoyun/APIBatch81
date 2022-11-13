package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPojo;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14IbjectMapper extends JsonplaceholderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos/198
        When
         I send GET Request to the URL
      Then
         Status code is 200
         And response body is like {
                               "userId": 10,
                               "id": 198,
                               "title": "quis eius est sint explicabo",
                               "completed": true
                             }
     */

    @Test
    public void get14ObjectMapper() {
        // Set the url
        spec.pathParams("first","todos", "second",198);

        // set the expected data
        String expectedDataInString = new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo", true);
        Map<String ,Object> expectedData = ObjectMapperUtils.convertJsonToJava(expectedDataInString, HashMap.class);
        System.out.println("expectedData = " + expectedData);

        // send request and get response
        Response response=  given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertions
        Map actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("complated"), actualData.get("complated"));

    }
}
