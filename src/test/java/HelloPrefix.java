import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class HelloPrefix {

    // bardzo przydatny test sprawdzajacy czy schema z jaka odpowiada serwer jest prawidlowa
    //  https://jsonschema.net/
    @Test
    public void serverInfoPassesSchemaValidation(){

        get("https://safe-plateau-87483.herokuapp.com/hello")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
