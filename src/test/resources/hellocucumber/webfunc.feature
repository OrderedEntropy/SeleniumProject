Feature: Youtube basic functionality
  can youtube preform some basic functionality?

  Scenario: Enable dark mode
    Given I am on homepage
    And settings focused
    When I toggle dark mode
    Then I should be displayed dark mode

  Scenario: I click on trending videos
    Given I am on homepage
    When I click trending
    Then I should be taken to trending page

  Scenario Outline: I search for a specific video
    Given I am on homepage
    And I type into the searchbar "<term>"
    When I click search
    Then I should find the "<result>"

    Examples: 
      | term                     | result      |
      | Friday                   | kfVsfOSbJY0 |
      | Virtual Insanity         | 4JkIs37a2JE |
      | Fell In Love With A Girl | fTH71AAxXmM |
