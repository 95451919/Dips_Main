package StepDefinitions;

import Pages.APIPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class apistep {
    APIPage api=new APIPage();
    private String baseUrl;
    private Response response;

    @Given("the API base URL is {string}")
    public void the_api_base_url_is(String url) {
        this.baseUrl = url;
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request(String endpoint) {
        response = RestAssured.get(baseUrl + endpoint);
    }

    @When("I send a POST request to {string} with body:")
    public void i_send_a_post_request(String endpoint, String body) {
        response = RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(body)
                .log().all()   // 👈 logs request
                .when()
                .post(endpoint)
                .then()
                .log().all()   // 👈 logs response
                .extract()
                .response();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the response should contain {string} with value {string}")
    public void the_response_should_contain(String key, String value) {
        System.out.println(response);
        assertThat(response.jsonPath().getString(key), equalTo(value));
    }
    @Given("^I use url (.*)$")
    public void iUseUrl(String url){
        api.setUrl(url);

    }
    @When("^I create request body using template file (.*) with following values$")
    public void createRequestBody(String file, DataTable data) throws IOException {
        Map<String,String>customData=data.asMaps().get(0);
        api.i_create_request_body(file,customData);
    }
    @And("^I use (.*) HTTP method$")
    public void useMethod(String method){
switch (method.toLowerCase()){
    case "get":
        break;
    case "post":
        api.SetPostMethod();
        break;
}

    }
    @And("^I validate status code is (.*)$")
    public void validateStatus( int status){
        api.ValidateStatusCode(status);


    }

}
