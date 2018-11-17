import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Exercise1RequestWithUrlParameter extends InfoshareTest {

    @Test
    public void returnsFirstnameSurnameAndPrefix() {
        // given
        String firstname = "Bartosz";
        String surname = "Szulc";
        String prefix = "Mr";

        // given, when, then
        given()
                .params("firstname", firstname, "surname", surname, "prefix", prefix).


                when()
                .get(path("/hello")).

                then()
                .log().ifValidationFails()

                .body("firstname", equalTo(firstname))
                .body("surname", equalTo(surname))
                .body("prefix", equalTo(prefix));

    }
}
