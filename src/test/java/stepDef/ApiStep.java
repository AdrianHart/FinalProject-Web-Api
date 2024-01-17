package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiPage;

import java.util.Map;

public class ApiStep {
    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for setup")
    public void prepareUrlForSetup() {
        apiPage.prepareSetupURL();
    }

    @When("send a {string} request to the list data")
    public void sendARequestToTheListData(String url) {
        apiPage.requestGetListData(url);
        apiPage.hitApiGetListUsers();
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @When("send a request {string} with id {string}")
    public void sendARequestWithId(String method, String userId) {
        apiPage.requestGetListData(method);
        apiPage.hitApiGetListUsers();
        apiPage.validationResponseBodyGetListUsersById(method, userId);
    }

    @Then("validation response body get list users id")
    public void validationResponseBodyGetListUsersId() {
        apiPage.theResponseBodyUserDetails();
    }

    @And("the response should be match with {string}")
    public void theResponseShouldBeMatchWith(String filename) {
        apiPage.theResponseShouldBeMatchWithJSON(filename);
    }

    @And("the response body should contain:")
    public void theResponseBodyShouldContain(Map<String, String> expectedValues) {
        apiPage.theResponseBodyShouldContain(expectedValues);
    }

    @Given("prepare url for setup {string}")
    public void prepareUrlForSetup(String url) {
        apiPage.prepareSetupURL();
        apiPage.requestGetListData(url);
        apiPage.hitApiPostCreateUsers();
    }

    @When("send a {string} request to the {string} endpoint")
    public void sendARequestToTheEndpoint(String method, String endpointName) {
        apiPage.sendARequestToTheEndpoint(method, endpointName);
    }

    @Then("the response body post create new user")
    public void theResponseBodyPostCreateNewUser() {
        apiPage.theResponseBodyUserDetails();
    }
    @Then("the response body should not be empty")
    public void theResponseBodyShouldNotBeEmpty() {
        apiPage.theResponseBodyShouldNotBeEmpty();
    }

    @And("the request body is set to:")
    public void theRequestBodyIsSetTo(Map<String, String> body) {
        apiPage.theRequestBodyIsSetTo(body);
    }

    @Then("the response body put update data user")
    public void theResponseBodyPutUpdateDataUser() {
        apiPage.theResponseBodyUserDetails();
    }
}

