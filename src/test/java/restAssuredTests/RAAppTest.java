package restAssuredTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import restAssuredTests.pojo.RegisterUserPojo;
import restAssuredTests.pojo.SuccessRegPojo;
import restAssuredTests.pojo.UserPojo;
import restAssuredTests.services.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

@Tag("RAssured")
public class RAAppTest {

    private static final String URI = "https://reqres.in";

    @Test
    public void getListUsersTest() {
        Specifications.installSpecification(
                Specifications.requestSpecification(URI), Specifications.responseSpecification(200)
        );
        List<UserPojo> users = given()
                .when()
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserPojo.class);
        users.forEach(x -> Assertions.assertNotNull(x.getFirst_name()));
    }

    @Test
    public void getSingleUserTest() {
        Specifications.installSpecification(
                Specifications.requestSpecification(URI), Specifications.responseSpecification(200)
        );
        UserPojo user = given()
                .when()
                .get("")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", UserPojo.class);
        Assertions.assertNotNull(user.getFirst_name());
    }

    @Test
    public void userNotFoundTest() {
        Specifications.installSpecification(
                Specifications.requestSpecification(URI), Specifications.responseSpecification(404)
        );
        UserPojo user = given()
                .when()
                .get("/api/users/23")
                .then().log().all()
                .extract().as(UserPojo.class);
        Assertions.assertNull(user.getFirst_name());
    }

    @Test
    public void successRegisterTest() {
        Specifications.installSpecification(
                Specifications.requestSpecification(URI), Specifications.responseSpecification(200)
        );
        RegisterUserPojo registerUser = new RegisterUserPojo("eve.holt@reqres.in", "pistol");
        SuccessRegPojo successRegPojo = given()
                .body(registerUser)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessRegPojo.class);
    }
}