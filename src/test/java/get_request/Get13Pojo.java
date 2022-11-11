package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            {
               "meta": null,
               "data": {
                   "id": 2508,
                   "name": "Vasundhara Nayar Ret.",
                   "email": "ret_vasundhara_nayar@renner.co",
                   "gender": "female",
                   "status": "inactive"
                    }
            }
    */

    @Test
    public void get13Pojo() {
        // Set the url
        spec.pathParams("first", "users", "second", "2508");

        // Set the expected data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508,
                "Vasundhara Nayar Ret.", "ret_vasundhara_nayar@renner.co",
                "female", "inactive");
        GoRestPojo expectetData = new GoRestPojo(null, goRestDataPojo);

        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertions
        GoRestPojo actualData = response.as(GoRestPojo.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectetData.getMeta(), actualData.getMeta());
        assertEquals(expectetData.getData().getId(), actualData.getData().getId());
        assertEquals(expectetData.getData().getName(), actualData.getData().getName());
        assertEquals(expectetData.getData().getEmail(), actualData.getData().getEmail());
        assertEquals(expectetData.getData().getGender(), actualData.getData().getGender());
        assertEquals(expectetData.getData().getStatus(), actualData.getData().getStatus());
    }
}
