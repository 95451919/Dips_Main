package StepDefinitions;

import Pages.SamplePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class SampleStep {
   SamplePage sample=new SamplePage();

    @Given("^user is launch the browser$")
    public void user_is_on_login_page() throws InterruptedException {
        sample.login_Page();
        }
    @Given("^user navigate on (.*)$")
    public void userClick(String elementonpage) throws InterruptedException {
        sample.userClick(elementonpage);

    }
    @Given("^user validate (.*) is present$")
    public void userValidateelementondashboardpage(String element) throws InterruptedException {
        sample.userClick(element);


    }
    @And("^user click on element page (.*)$")
    public void userClickonelement(String elementonpage) throws InterruptedException {
        sample.userClickonelement(elementonpage);

    }
    @And("^user validate (.*) last name as (.*)$")
    public void uservalidatelastname(String firstname,String lastname) throws InterruptedException {
        sample.uservalidatelastname(firstname,lastname);

    }

    @When("^user enters valid credentials username (.*) and password (.*)$")
    public void user_enters_valid_credentials(String username,String password) {
        sample.login(username,password);

        System.out.println("User enters valid credentials");
    }

    @Then("^user should be logged in successfully$")
    public void user_should_be_logged_in_successfully(DataTable data) {
//        String dip=data.asMap().get("abc");
//        String nil=data.asMap().get("abc1");
        sample.m1(data.asMaps().get(0));

        System.out.println("User logged in successfully");
    }

    @Then("^User enter the below details$")
    public void userEnterTheDetails(DataTable data) throws InterruptedException {

        sample.userEnterTheDetails(data.asMaps().get(0));

        }
}
