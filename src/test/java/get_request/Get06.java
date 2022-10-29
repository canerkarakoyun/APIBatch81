package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Get06 extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
     */

    @Test
    public void get01() {
        spec.pathParams("first", "booking", "second", "2325");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Howard"),
                        "lastname", equalTo("Colque"),
                        "totalprice", equalTo(111),
                        "depositepaid", equalTo(null),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("Breakfast"));

        // 2. Yol : Jsonpath class'inin kullanimi
        JsonPath json = response.jsonPath();
        assertEquals("Howard",json.getString("firstname"));
        assertEquals("Colque",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertNull(json.getString("depositepaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Breakfast",json.getString("additionalneeds"));
        assertEquals("Breakfast",json.getString("additionalneeds"));

        // 3. Yol : SoftAssert (3 adimda kullanilir-- 1. Obje olustur )
        // 1. Adim: Obje olusturma
        // 2. Adim: Do assertion
        // 3. Adim: Dogrulama islemleri sonunda softAssert.assertAll() diyerek yaptigimiz tum dogrulama
        //          islemlerinin kontrol edilmesini sagliyoruz.
        //          Not:  Eger islemin sonunda softAssert.assertAll() kullanmaz isek taleplerimiz
        //          hatalı bile olsa testimiz pass olacaktir.

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(json.getString("firstname"),"Howard","Firstname hatali");
        softAssert.assertEquals(json.getString("lastname"),"Colque","Lastname hatali");
        softAssert.assertEquals(json.getInt("totalprice"),111,"Total price hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true,"Depositepaid hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01","Checkin Date hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01","Checkout Date hatali");
        softAssert.assertEquals(json.getString("additionalneeds"),"Breakfast","Additionalneeds hatali");

        softAssert.assertAll();



    }
}
