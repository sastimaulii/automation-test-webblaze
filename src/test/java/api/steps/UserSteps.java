package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserSteps {

    Response response;
    String userId;

    String BASE_URL = "https://dummyapi.io/data/v1";
    String APP_ID = "63a804408eb0cb069b57e43a";

    // =============================
    // GET LIST USER
    // =============================
    @Given("User set GET endpoint")
    public void setEndpoint() {
        baseURI = BASE_URL;
    }

    @When("User send GET request")
    public void sendRequest() {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .get("/user");

        System.out.println("STATUS: " + response.getStatusCode());
        response.then().log().all();
    }

    // =============================
    // GET INVALID USER
    // =============================
    @When("User send invalid GET request")
    public void sendInvalidRequest() {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .get("/user/123-invalid");

        System.out.println("INVALID STATUS: " + response.getStatusCode());
        response.then().log().all();
    }

    @Then("Response status should be 200")
    public void validate200() {
        int status = response.getStatusCode();

        if (status != 200) {
            throw new AssertionError("Expected 200 but got " + status);
        }
    }

    @Then("Response status should be 404")
    public void validate404() {
        int status = response.getStatusCode();

        if (status != 404 && status != 400) {
            throw new AssertionError("Expected 404/400 but got " + status);
        }
    }

    // =============================
    // BASE URL (POST & others)
    // =============================
    @Given("user set base api url")
    public void setBaseApiUrl() {
        baseURI = BASE_URL;
    }

    // =============================
    // CREATE USER (FIXED 🔥)
    // =============================
    @When("user create new user")
    public void createUser() {

        // 🔥 email unik biar tidak duplicate
        String uniqueEmail = "john" + System.currentTimeMillis() + "@mail.com";

        String payload = "{ " +
                "\"firstName\": \"John\", " +
                "\"lastName\": \"Doe\", " +
                "\"email\": \"" + uniqueEmail + "\"" +
                "}";

        response = given()
                .header("app-id", APP_ID)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/user/create");

        System.out.println("CREATE STATUS: " + response.getStatusCode());
        System.out.println("CREATE BODY: " + response.getBody().asString());

        response.then().log().all();

        // 🔥 simpan userId untuk chaining
        userId = response.jsonPath().getString("id");
        System.out.println("USER ID: " + userId);
    }

    // =============================
    // GET USER BY ID
    // =============================
    @When("user get user by id")
    public void getUserById() {

        if (userId == null) {
            throw new RuntimeException("User ID is NULL (create user gagal)");
        }

        response = given()
                .header("app-id", APP_ID)
                .when()
                .get("/user/" + userId);

        System.out.println("GET BY ID STATUS: " + response.getStatusCode());
        response.then().log().all();
    }

    // =============================
    // NEGATIVE CASE
    // =============================
    @When("user create user without email")
    public void createUserWithoutEmail() {

        String payload = "{ " +
                "\"firstName\": \"John\", " +
                "\"lastName\": \"Doe\"" +
                "}";

        response = given()
                .header("app-id", APP_ID)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/user/create");

        System.out.println("NEGATIVE STATUS: " + response.getStatusCode());
        System.out.println("NEGATIVE BODY: " + response.getBody().asString());

        response.then().log().all();
    }

    // =============================
    // VALIDATION
    // =============================
    @Then("response should be success")
    public void successResponse() {
        int status = response.getStatusCode();

        if (status != 200 && status != 201) {
            throw new AssertionError("Expected 200/201 but got " + status);
        }
    }

    @Then("response should be error")
    public void errorResponse() {
        int status = response.getStatusCode();

        if (status < 400) {
            throw new AssertionError("Expected error but got " + status);
        }
    }
}