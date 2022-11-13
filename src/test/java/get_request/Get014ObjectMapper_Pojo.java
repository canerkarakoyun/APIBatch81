package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get014ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
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

    // Object Mapper + Pojo ==> En iyi yontem
    @Test
    public void get14Pojo(){

        //Set the Url
        spec.pathParams("first","todos","second",198);

        //Set the Expected Data
        JsonPojo expectedData = new JsonPojo(10,"quis eius est sint explicabo",true);

        //Sen the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //Do Assertion
        JsonPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getComplated(),actualData.getComplated());

    }
}
