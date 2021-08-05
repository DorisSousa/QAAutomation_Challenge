Feature: Add user with job
  As a User
  I want input ...

  Scenario: Add user with job
    Given I use user creation service
    When I set name "Toy"
    When I set job "Singer"
    And I send request
    Then I validate my response is correct with status "201"

  Scenario: Delete user
    Given I use user delete service
    And I delete the user with id "2"
    Then I validate my response is correct with status "204"

  Scenario: Register new user without password
    Given I use user register service
    And I post request with a new register without password
    Then I validate my response is correct with status "400"