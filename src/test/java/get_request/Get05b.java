package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

public class Get05b extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void get01() {
        spec.pathParams("first","unknown", "second", 3);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();

        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "Id degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "Name degeri dogru degil");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "Year degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932", "Color degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"), "19-1664", "pantone_value degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.url"), "https://reqres.in/#support-heading", "URL degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.text"), "To keep ReqRes free, contributions towards server costs are appreciated!", "Text degeri dogru degil");

        softAssert.assertAll();

    }
}
