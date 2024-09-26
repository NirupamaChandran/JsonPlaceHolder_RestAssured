Feature: Validate delete resource

  Scenario: Verify user can get resource
    Given user wants to call "/posts/1" end point
    And user performs delete call
    Then verify status code is 200