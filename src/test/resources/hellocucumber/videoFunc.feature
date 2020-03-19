Feature: Youtube video basic functionality
  is youtube video playback robust and flexible?

  Scenario: I can pause a video
    Given I am on a video page
    When wait for load
    And I press pause
    Then the video pauses

  Scenario: I can mute a video
    Given I am on a video page
    When wait for load
    And I press mute
    Then the video mutes

  Scenario: When I finish video, I can replay
    Given I am on a video page
    And I finish watching video
    When I click replay
    Then the video plays again
