package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/90
        When
            I send GET Request to the url
        Then
            Response body should be like that;
             {
            "firstname": "Nicholas",
            "lastname": "Harris",
            "totalprice": 133,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2023-01-27",
                "checkout": "2023-01-31"
            },
            "additionalneeds": "lunch"
            }
     */

    @Test
    public void get01() {
        // Set the url
        spec.pathParams("first", "booking", "second",90);

        // Set the expected data
        Map<String, String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2023-01-27");
        bookingDatesMap.put("checkout", "2023-01-31");

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Nicholas");
        expectedData.put("lastname", "Harris");
        expectedData.put("totalprice", 133);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingDatesMap);
        expectedData.put("additionalneeds", "lunch");
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response

        Response response = given().spec(spec).get("/{first}/{second}");
        //response.prettyPrint();

        // Do assertions
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("bookingdates.checkin"), actualData.get("bookingdates.checkin"));
        assertEquals(expectedData.get("bookingdates.checkout"), actualData.get("bookingdates.checkout"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
    }
}
