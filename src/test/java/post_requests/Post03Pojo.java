package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post03Pojo extends JsonplaceholderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post03Pojo() {
        // Set the  url
        spec.pathParam("first", "todos");

        // Set the expected data
        JsonPojo expectedData = new JsonPojo(55, "Tidy your room", false);

        // Send the request get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData)
                                                                                    .when().post("/{first}");
        //response.prettyPrint();


        // Do assertion
        JsonPojo actualData = response.as(JsonPojo.class);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getComplated(), actualData.getComplated());
    }
}
