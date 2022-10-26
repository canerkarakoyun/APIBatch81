import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/1
    When
        User send a GET Request to the url
    Then
        HTTP Status code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
    And
        Response body contains "Not Found"
    And
        Response body does not contain "TechProEd"
    And
        Server is "Cowboy"

     */

    @Test
    public void get01() {
        //i. Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/1";

        //ii. Set the expected data (beklenen datanin olusturulmasi.. Post, Put, Patch)


        //iii. Type code to send request (Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        //iv. Do assertion (Dogrulama yapmak)
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found"));
        // Ust satirda bady Not Found iceriyor mu testi yapiliyor
        assertFalse(response.asString().contains("TechProEd"));
        // Ust satirda bady'nin TechProEd icermedigi test ediyoruz
        assertEquals("Cowboy", response.getHeader("Server"));
        // Server'in Cowboy olup olmadigini test ediyoruz
    }
}
