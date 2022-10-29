package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Get05 extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Ali" and lastname is "Cengiz"
     */

    @Test
    public void get01() {
        spec.pathParam("first","booking").
                queryParams("firstname","Ali","lastname","Cengiz");

        Response response = given().spec(spec).get("/{first}");
        response.prettyPrint();

        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
