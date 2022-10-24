import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1. Postman, manuel testler icin kullanilir
    2. Automation testler icin ise Rest Assured Library kullanacagiz
    3. Biz otomasyon testlerimizi yaparken asagidaki adimlarimizi izliyoruz;
        a. Gereksinimleri anlamak
        b. Test case'lerimizi yaziyoruz
            i. Test case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da muhataplarimiz
                hakim olmayabilir. Ancak Gherkin ile yazilan testleri anlamakta zorluk cekmeyeceklerdir.

                Gherkin dilinde kullanacagimiz keyword'ler;
                - Given : On kosul
                - When : Yapilacak aksiyonlar icin ( get(), put(), post(), patch() ve delete() )
                - Then : Istek yaptiktan sonra (request gonderdikten sonra) dogrulama
                - And : Coklu islemlerde kullanacagiz (Birden fazla when ya da then varsa onun yerine and yazacagiz)

        c. Test Kodlarimizi Yazmaya Baslayacagiz
            i. Set the URL
            ii. Set the expected data (beklenen datanin olusturulmasi.. Post, Put, Patch)
            iii. Type code to send request (Talep gondermek icin kod yazimi)
            iv. Do assertion (Dogrulama yapmak)

     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */

    @Test
    public void get01() {
        //i. Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";

        //ii. Set the expected data (beklenen datanin olusturulmasi.. Post, Put, Patch)
        // Bizden post, put ya da patch istenmedigi icin bu case'de kullanmayacagiz

        //iii. Type code to send request (Talep gondermek icin kod yazimi)
        Response response=given().when().get(url);
        response.prettyPrint();

        //iv. Do assertion (Dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
    }
}
