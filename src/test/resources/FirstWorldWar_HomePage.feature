@Regression
Feature: The First World War

  Scenario Outline: The First World War Forum
    Given the user lands on the WWI page
    When clicks the "<forums>" link
    Then the user is taken to the "<target>" page
    And the browser closes

    Examples:
      | forums | target |
      | First World War Forum | Please note our forum is currently not open |

  Scenario Outline: Battlefield Tours
    Given the user lands on the WWI page
    When clicks the "<topic>" link
    Then the user is taken to the "<target>" page
    And the browser closes

    Examples:
      | topic | target |
      | Battlefield Tours | Touring the Battlefields |