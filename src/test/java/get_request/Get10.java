package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
       {
            "meta": null,
            "data": {
                "id": 2986,
                "name": "Kanaka Jain",
                "email": "kanaka_jain@stark.net",
                "gender": "male",
                "status": "active"
            }
        }
     */

    @Test
    public void get01() {

        // Set the Url
        spec.pathParams("first", "users","second", 2986);

        // Set the expected data
        GoRestTestData obj=new GoRestTestData();
        Map<String,String> dataKeyMap = obj.dataKeyMap("Kanaka Jain","kanaka_jain@stark.net","male","active");
        Map<String,Object> expectedData = obj.expectedDataMethod(null, dataKeyMap);
        System.out.println("expectedData = " + expectedData);


        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertions
        Map<String, String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.get("meta"), actualData.get("meta"));
        assertEquals(expectedData.get("data.name"), actualData.get("data.name"));
        assertEquals(expectedData.get("data.email"), actualData.get("data.email"));
        assertEquals(expectedData.get("data.gender"), actualData.get("data.gender"));
        assertEquals(expectedData.get("data.status"), actualData.get("data.status"));
    }
}
