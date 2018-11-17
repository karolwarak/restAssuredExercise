import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Exercise4RequestBookWithS extends InfoshareTest {

    @Test
    public void returnsTotalAuthorNamesLengthOfSelectedBooks()
    {
        given().
                get(path("/book")).
                then().
                body("store.book.findAll { it.title.startsWith(\"S\")}.size()", equalTo(2));
    }
}
