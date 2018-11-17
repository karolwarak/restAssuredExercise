import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Exercise2RequestWithHeader extends InfoshareTest{

    @Test
    public void returnsFirstnameSurnameAndPrefix() {
        // given
        String firstname = "Bartosz";
        String surname = "Szulc";
        String prefix = "Mr";

        // given, when, then
        given()
                .header("X-User-Id", 1000)
                .header("X-Role", "admin").

                when()
                .get(path("/hello")).

                then()
                .log().ifValidationFails()

                .body("message", equalTo("Welcome my master!"));

    }
}
