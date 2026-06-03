package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class CustomerApiSteps {

    Response response;

    @Given("API base url is {string}")
    public void setBaseUrl(String url) {
        baseURI = url;
    }

    @When("I send POST request to {string} with valid payload")
    public void sendValidRequest(String endpoint) {
        String payload = "{ \"name\": \"John Doe\", \"email\": \"john@mail.com\" }";

        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint);

        response.then().log().all(); // 🔥 penting
    }

    @When("I send POST request to {string} with invalid payload")
    public void sendInvalidRequest(String endpoint) {
        String payload = "{ \"name\": \"\" }";

        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint);

        response.then().log().all();
    }

    @When("I send POST request to {string} without authorization")
    public void sendWithoutAuth(String endpoint) {
        String payload = "{ \"name\": \"John Doe\" }";

        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint);

        response.then().log().all();
    }

    @Then("response status should be {int}")
    public void validateStatus(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}