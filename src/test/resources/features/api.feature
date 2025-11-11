Feature: Login functionality


  Scenario: Validated for get method
    Given the API base URL is "https://reqres.in"
    When I send a GET request to "/api/users/2"
    Then the response status code should be 200
#    And the response should contain "email" with value "janet.weaver@reqres.in"

  Scenario: Create a new user
    Given the API base URL is "https://reqres.in"
    When I send a POST request to "/api/users" with body:
      """
      { "name": "dipak", "job": "tester" }
      """
    Then the response status code should be 401
    And the response should contain "name" with value "dipak"
    And the response should contain "job" with value "tester"


  Scenario: Create a new user
    Given I use url https://reqres.in
    When I create request body using template file abc.json with following values
      | NAME  | DOC_ID | ACC_NUM |
      | Dipak | D-123  | 787878  |
    And I use POST HTTP method
    Then I validate status code is 404
