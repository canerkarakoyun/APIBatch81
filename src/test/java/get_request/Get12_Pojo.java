package get_request;

import base_url.RestfulBaseUrl;
import org.junit.Test;

public class Get12_Pojo extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/12098
        When
          I send GET Request to the URL
       Then
          Status code is 200
      And
          Response body is like:
                       {
                            "firstname": "Carlos",
                            "lastname": "Sevilla",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }
     */

    @Test
    public void get12_Pojo() {
        // Set the url
        spec.pathParams("first", "booking", "second", "12098");

        // Set the ecpected data




    }

}
