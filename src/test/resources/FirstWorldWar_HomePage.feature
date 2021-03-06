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

    Scenario Outline: Search Site For Topic
      Given the user lands on the WWI page
      When the user enters "<search>" in the search box
      And clicks the Search button
      And verifies the Google "<search>" results page
      And selects the first search result on Google page
      Then the user is taken to the "<target>" page
      And the browser closes

      Examples:
        | search | target |
        | Search1 | json data |
        | Search2 | json data |

    Scenario: Rotating Banner
      Given the user lands on the WWI page
      Then the user verifies there are five rotating banner articles
      And the browser closes