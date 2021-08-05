package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteUser {

  private String name;
  private String job;
  private final RequestSpecification requestSpecification;

  public DeleteUser() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api");
//        .basePath("/users/");
  }

  public Response delete(String user)
  {

    String requestBody = "{\n" +
            "  \"name\": \"" + user + "\" \n}";

//    this.requestSpecification.body(requestBody);
    Response response = this.requestSpecification.delete("/users/" + user);

    System.out.println(response.statusCode());
    System.out.println(response.getBody().asString());

    return response;
  }



}
