Feature: Test different APIs of ReqRest.in

  @GETUsers @E2EAPISuite
  Scenario Outline: Get and Verify User API
    Given Get the users details at page "<pageNumber>"
    When Status Code is 200
    Then Verify the value of "<field>" for "<id>" is "<value>"
    Examples:
      | pageNumber |  id | field      |value   |
      | 2          | 10  | first_name |  Byron |

  @POSTUsers @E2EAPISuite
  Scenario Outline: Create and Verify User API
    Given Create user with "<name>" and "<job>"
    When Status Code is 201
    Then Verify that id is generated
    And Response matches its JSON Schema
    Examples:
      | name       |  job |
      | Bryant     | BA   |