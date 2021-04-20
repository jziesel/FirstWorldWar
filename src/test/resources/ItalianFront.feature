@Regression
Feature: World War I - The Italian Front

  Scenario Outline: Italian Front Battles Overview
    Given the user lands on the WWI page
    When clicks the "<battles>" link
    And next clicks the "<theItalianFront>" link
    Then the user is taken to the "<target>" page
    And the browser closes

    Examples:
      | battles | theItalianFront | target |
      | Battles | The Italian Front | major actions fought on the Italian Front during the First World War |