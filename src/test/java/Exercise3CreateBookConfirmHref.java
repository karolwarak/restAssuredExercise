import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Exercise3CreateBookConfirmHref extends InfoshareTest {

    @Test
    public void confirmHrefLinkToBook() {

        // given
        Map<String, Object> book = new HashMap<String, Object>();
        book.put("author", "Bartosz Szulc");
        book.put("category", "software");
        book.put("isbn", "1234");
        book.put("title", "quality in software development");
        book.put("price", 100000);
        // when
                given()
                        // musi byc contentTypr zeby serwer wiedzial jak odpwiedziec
                        .contentType("application/json")
                        .body(book).

                        when()
                        // wysylamy ksiazke ktora stworzylem
                        .post(path("/book")).

                        then()
                        .log()
                        .all()
                        .body("href", equalTo("/books/" + book.get("isbn")));
                //.concat("1234") - to jest szybszy przy dodawaniu Stringow niz +

        // then

    }
}
