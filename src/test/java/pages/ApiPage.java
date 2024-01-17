package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;

import static helper.Models.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.nullValue;


public class ApiPage {

    String setURL;
    Response res;
    RequestSpecification request;

    public void prepareSetupURL() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("app-id", "655487b1d6a0fa4bfaa47fa1");
    }

    public void requestGetListData(@NotNull String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "GET_LIST_USERS_ID":
                setURL = Endpoint.GET_LIST_USERS_ID;
                break;
            case "GET_LIST_TAGS":
                setURL = Endpoint.GET_LIST_TAGS;
                break;
            case "GET_WRONG_USERS_ID":
                setURL = Endpoint.GET_WRONG_USERS_ID;
                break;
            case "GET_WRONG_SYMBOL_USERS_ID":
                setURL = Endpoint.GET_WRONG_SYMBOL_USERS_ID;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            default:
        }
        System.out.println("Endpoint siap pakai adalah : " + setURL);
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
    }

    public void hitApiPostCreateUsers() {
        res = postCreateUsers(setURL);
    }

    public void validationStatusCodeIsEquals(int status_code) {
        if (res != null) {
            assertThat(res.statusCode()).isEqualTo(status_code);
        } else {
            System.err.println("Response is null. Unable to validate status code.");
        }
    }
//        assertThat(res.statusCode()).isEqualTo(status_code);

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> title = res.jsonPath().getList("data.title");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
        List<Object> picture = res.jsonPath().getList("data.picture");

        assertThat(id.get(0)).isNotNull();
        assertThat(title.get(0)).isIn("mr", "ms", "mrs", "miss", "dr");
        assertThat(firstName.get(0)).isNotNull();
        assertThat(lastName.get(0)).isNotNull();
        assertThat(picture.get(0)).isNotNull();

//        System.out.println(res.getBody().asString());
    }

    public void theResponseShouldBeMatchWithJSON(String filename) {
        if (res != null) {
            File JSONFile = Utility.getJSONSchemaFile(filename);
            res.then().assertThat().body(matchesJsonSchema(JSONFile));
        } else {
            System.out.println("Response is null. Make sure a request was made successfully.");
        }
    }

    public void validationResponseBodyGetListUsersById(@NotNull String method, String userId) {
        Preferences prefs = Preferences.userRoot().node("api.features");
        String userId01 = prefs.get("userId01", null);
        String userId02 = prefs.get("userId02", null);
        String userId03 = prefs.get("userId03", null);

        switch (method) {
            case "GET":
                res = request.when().get(Endpoint.host_dummyapi + userId);
                break;
            case "DELETE":
                if ("userId01".equals(userId)) {
                    res = request.when().delete(Endpoint.host_dummyapi + userId01);
                } else if ("userId02".equals(userId)) {
                    res = request.when().delete(Endpoint.host_dummyapi + userId02);
                } else if ("userId03".equals(userId)) {
                    res = request.when().delete(Endpoint.host_dummyapi + userId03);
                } else {
                    res = request.when().delete(Endpoint.host_dummyapi + userId);
                }
                break;
            case "PUT":
                if ("userId01".equals(userId)) {
                    res = request.when().put(Endpoint.host_dummyapi + userId01);
                } else if ("userId02".equals(userId)) {
                    res = request.when().put(Endpoint.host_dummyapi + userId02);
                }
                break;
            default:
        }
//        System.out.println(res.getBody().asString());
    }

    public void theResponseBodyUserDetails() {
        if (res != null) {
            res.then().body("data.id", nullValue());
            res.then().body("data.firstName", nullValue());
            res.then().body("data.lastName", nullValue());
            res.then().body("data.email", nullValue());
        } else {
            System.out.println("Response is null. Make sure a request was made successfully.");
        }
    }
    public void theResponseBodyShouldContain(@NotNull Map<String, String> expectedValues) {
        if (res != null) {
            for (Map.Entry<String, String> entry : expectedValues.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                try {
                    String actualValue = res.path(key).toString();
                    MatcherAssert.assertThat(actualValue, equalTo(value));
                } catch (Exception e) {
                    System.err.println("Failed to extract value for key: " + key);
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("Response is null. Unable to check the response body.");
        }
    }

    public void theResponseBodyShouldNotBeEmpty() {
        if (res != null) {
            res.then().body("data.title", nullValue());
            res.then().body("data.picture", nullValue());
            res.then().body("data.gender", nullValue());
            res.then().body("data.dateOfBirth", nullValue());
            res.then().body("data.phone", nullValue());
            res.then().body("data.location.country", nullValue());
            res.then().body("data.location.city", nullValue());
            res.then().body("data.location.street", nullValue());
            res.then().body("data.location.timezone", nullValue());
            res.then().body("data.location.state", nullValue());
        } else {
            System.out.println("test");
        }
    }

    public void sendARequestToTheEndpoint(@NotNull String method, String endpointName) {
        switch (method) {
            case "GET":
                if (endpointName.equals("LIST")) {
                    res = request.when().get(Endpoint.GET_LIST_USERS);
                } else if (endpointName.equals("TAGS")) {
                    res = request.when().get(Endpoint.GET_LIST_TAGS);
                }
                break;
            case "POST":
                if (endpointName.equals("CREATE_NEW_USERS")) {
                    JSONObject payload = new JSONObject();
                    payload.put("lastName", "Hartanto");
                    payload.put("firstName", "Adrian");
                    payload.put("email", Utility.generateRandomEmail());

                    res = request
                            .contentType(ContentType.JSON)
                            .body(payload.toString())
                            .post(Endpoint.CREATE_NEW_USERS);
                }
                break;
            default:
        }
//        System.out.println(res.getBody().asString());
    }

    public void initializeRequest() {
        this.request = RestAssured.given();
    }
    public void theRequestBodyIsSetTo(Map<String, String> body) {
        if (request == null) {
            initializeRequest();
        }
        String firstName = body.get("data.firstName");
        String lastName = body.get("data.lastName");
        String email = body.get("data.email");

        JSONObject bodyObj = Utility.userRequestLimitedBody(firstName, lastName, email);
        request.body(bodyObj.toString());

    }
}