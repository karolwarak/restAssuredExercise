import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Exercise4RestAutentication {

    @Test
    public void canCreateProject() {

        Map<String, Object> project = new HashMap<String, Object>();
        project.put("name", "Nowy projekcikii");
        project.put("key", "T2");
        project.put("templateKey", "com.pyxis.greenhopper.jira:gh-simplified-agility-kanban");

        given()
                .contentType("application/json")
                .body(project)
                .auth()
                .preemptive()
                .basic("kenneth.signy.training@gmail.com", "b0dHaO4lkpr4K50H8x4TAB6C")


                .when()
                    .post("https://infoshare-rest-asssured.atlassian.net/rest/simplified/latest/project")

                .then()
                    .log()
                    .all()
                    .time(lessThan(5000L))
                    .body("returnUrl", equalTo("/browse/" + project.get("key")));
    }
}
