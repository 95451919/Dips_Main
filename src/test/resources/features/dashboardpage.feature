Feature: Validate all requirement on dashboard page

  Scenario: Validate element is present on dashboard page
    Given user is launch the browser
    Then user validate element is present

  Scenario: Validate Forms is present on dashboard page
    Given user is launch the browser
    Then user validate Forms is present

  Scenario: Validate Interactions is present on dashboard page
    Given user is launch the browser
    Then user validate Interactions is present


  Scenario Outline: Validate the all elements are present on dashboard page
    Given user is launch the browser
    Then user validate <ALLELEMENTS> is present
    Examples:
      | ALLELEMENTS  |
      | element      |
      | Forms        |
      | Interactions |