package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

  private String name;
  private String job;
  private final RequestSpecification requestSpecification;

  public CreateUser() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api")
        .basePath("/users");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String buildBody() {
    return "{\n" +
            "  \"name\": \""+ this.name+"\",\n" +
            "  \"job\": \""+ this.job+"\"\n" +
            "}";
  }

  public String buildBodyWithSurname() {
    return "{\n" +
            "    \"name\": \""+ this.name+" autoSurname\",\n" +
            "    \"job\": \""+ this.job+"\"\n" +
            "}";
  }

  public Response send_request()
  {
    String requestBody = this.buildBody();

    this.requestSpecification.contentType(ContentType.JSON);
    this.requestSpecification.body(requestBody);

    Response response = this.requestSpecification.post();

    System.out.println(response.statusCode());
    System.out.println(response.getBody().asString());

    return response;
  }

}
