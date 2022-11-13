package delete_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

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

        // Send request and get response
        Response response=given().spec(spec).when().delete("/{first}/{second}");


    }
}
