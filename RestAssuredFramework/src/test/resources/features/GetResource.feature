Feature: Validate get resource

  Scenario: Verify user can get resource
    Given user wants to call "/posts/1" end point
    And user performs get call
    Then verify status code is 200