package webServiceTesting;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class Steps {

  CreateUser createUser;
  Response response;

  DeleteUser deleteUser;

  RegisterUser registerUser;


//  Create User Steps *************************************
  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    createUser = new CreateUser();
  }

  @When("^I set name \"([^\"]*)\"$")
  public void setName(String name) {
    createUser.setName(name);
  }

  @When("^I set job \"([^\"]*)\"$")
  public void setJob(String job) {
    createUser.setJob(job);
  }

  @And("^I send request$")
  public void iSendRequest() {
    response = createUser.send_request();
  }
  @Then("^I validate my response is correct with status \"([^\"]*)\"$")
  public void validateMyResponseIsCorrect(String status) {

    Assert.assertEquals(Integer.parseInt(status), response.statusCode());

  }

  //  Delete User Steps *************************************
  @Given("^I use user delete service$")
  public void iUseUserDeleteServiceForUser() {
    deleteUser = new DeleteUser();
  }

  @And("^I delete the user with id \"([^\"]*)\"$")
  public void iDeleteIt(String user) {
    response = deleteUser.delete(user);
  }


//  Register User *************************************
  @Given("^I use user register service$")
  public void iUseUserRegisterService() {
    registerUser = new RegisterUser();
  }

  @And("^I post request with a new register without password$")
  public void iPostRequestWithANewRegisterWithoutPassword() {
    response = registerUser.register("challenge@automation.com");
  }
}
