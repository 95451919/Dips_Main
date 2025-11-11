Feature: Login functionality

  Background: user login first common step
    Given user is launch the browser
    When user navigate on Elements
    And user click on element page Text Box

@Smoke,@Functional,@Regression
  Scenario: User enter the details of nilam
    And User enter the below details
      | FullName   | Email           | CurrentAdress | PermanatAdress |
      | Nilam Rakh | nilam@gmail.com | Pune          | Beed           |

  @test
  Scenario: User enter the details for dipak
    And User enter the below details
      | FullName     | Email           | CurrentAdress | PermanatAdress |
      | Dipak Jagtap | dipak@gmail.com | Pune1         | Beed1          |


#  Scenario: User enter the details
#    Given user is launch the browser
##    When user enters valid credentials username "dipak@123" and password "1234"
##    Then user should be logged in successfully
##      | abc   | abc1   | abc3   |
##      | <abc> | <abc1> | <abc3> |
#    When user navigate on Elements
#    And user click on element page Text Box
#    And User enter the below details
#      | FullName   | Email           | CurrentAdress | PermanatAdress |
#      | Nilam Rakh | nilam@gmail.com | Pune          | Beed           |
##    Then I will verify the status
##      | abc   | abc1   |
##      | <abc> | <abc1> |
##    Examples:
##      | abc   | abc1  | abc3  |
##      | Dipak | Nilam | dips  |
##      | sdd   | dsdsf | dsfsf |





