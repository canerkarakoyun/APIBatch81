package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get04b extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Tyler&lastname=Smith
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Tyler" and lastname is "Smith"
     */

    @Test
    public void get01() {
        spec.pathParam("first","booking").
                queryParams("firstname","Tyler","lastname","Smith");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
