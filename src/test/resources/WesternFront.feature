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

    Scenario Outline: Western Front Battlefield Details
      Given the user lands on the WWI page
      When clicks the "<battles>" link
      And next clicks the "<theWesternFront>" link
      Then the user is taken to the "<target>" page
      And next clicks the Western Front "<westernFrontBattle>" link
      Then the user is taken to the Western Front "<target2>" page
      And the browser closes

      Examples:
        | battles | theWesternFront | target | westernFrontBattle | target2 |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Siege of Antwerp | The Siege of Antwerp, 1914 |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Battle of the Ardennes | 21-23 August 1914, the Battle of the Ardennes |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | First Battle of Champagne | The First Battle of Champagne, which after minor skirmishes |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Second Battle of Ypres | The Second Battle of Ypres comprised the only major attack |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Battle of Verdun | The German siege of Verdun and its ring of forts |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Battle of the Somme | Battle of the Somme is famous chiefly on account |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Battle of Flers-Courcelette | Battle of Flers-Courcelette was notable for the introduction of tanks |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Battle of Cambrai | The Battle of Cambrai, launched in November 1917 |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Third Battle of the Aisne | the Third Battle of Aisne, from 27 May-6 June 1918 |
        | Battles | The Western Front | actions, battles and offensives conducted along the Western Front | Battle of Epehy | the Battle of Epehy was directed against forward outposts |
