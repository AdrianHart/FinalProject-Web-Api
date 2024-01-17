package helper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;
import static io.restassured.RestAssured.given;

public class Models {
    public static RequestSpecification request;
    public static void setupHeaders() {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "655487b1d6a0fa4bfaa47fa1");
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUsers(String endpoint) {
        String firstName = "Adrian";
        String lastName = "Hartanto";
        String title = "mr";
        String gender = "male";
        String email = generateRandomEmail();
        String dateOfBirth = "03/11/1992";
        String picture = "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY";
        String phone = "08123456789";

        JSONObject location = new JSONObject();
        location.put("street", "Dayeuhkolot");
        location.put("city", "Bandung");
        location.put("state", "State");
        location.put("country", "Indonesia");
        location.put("timezone", "GMT+7");

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("title", title);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("dateOfBirth", dateOfBirth);
        payload.put("picture", picture);
        payload.put("phone", phone);
        payload.put("location", location);

        Response response = given()
                .header("app-id", "655487b1d6a0fa4bfaa47fa1")
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .post(endpoint);

        System.out.println(response.getBody().asString());
        return response;
    }
}




