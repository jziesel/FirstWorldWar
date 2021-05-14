@Regression
Feature: World War I - The Western Front

  Scenario Outline: Western Front Battles Overview
    Given the user lands on the WWI page
    When clicks the "<battles>" link
    And next clicks the "<theWesternFront>" link
    Then the user is taken to the "<target>" page
    And the browser closes

    Examples:
      | battles | theWesternFront | target |
      | Battles | The Western Front | actions, battles and offensives conducted along the Western Front |

    Scenario Outline: The Seige of Antwerp
      Given the user lands on the WWI page
      When clicks the "<battles>" link
      And next clicks the "<theWesternFront>" link
      Then the user is taken to the "<target>" page
      And next clicks the Western Front "<siegeOfAntwerp>" link
      Then the user is taken to the Western Front "<target2>" page
      And the browser closes

      Examples:
        | battles | theWesternFront | target | siegeOfAntwerp | target2 |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Siege of Antwerp | The Siege of Antwerp, 1914 |
