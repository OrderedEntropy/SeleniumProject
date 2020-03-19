Feature: Youtube video basic functionality
  is youtube video playback robust and flexible?

  Scenario Outline: I can log in
    Given I am on login page
    When I type in user "<username>"
    And press submit user
    And  type pass "<pass>"
    And press submit pass
    And wait for load
    Then I log in "<username>"

    Examples: 
      | username                      | pass        |
      | testaccountzzz@protonmail.com | Testpass12# |
