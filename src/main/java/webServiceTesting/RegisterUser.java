package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterUser {

  private String name;
  private String job;
  private final RequestSpecification requestSpecification;

  public RegisterUser() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api")
        .basePath("/register");
  }

  public Response register(String email) {

    String requestBody = "{\n" +
            "  \"email\": \"" + email + "\" \n}";

    this.requestSpecification.contentType(ContentType.JSON);
    this.requestSpecification.body(requestBody);

    Response response = this.requestSpecification.post();

    System.out.println(response.statusCode());
    System.out.println(response.getBody().asString());

    return response;
  }



}
