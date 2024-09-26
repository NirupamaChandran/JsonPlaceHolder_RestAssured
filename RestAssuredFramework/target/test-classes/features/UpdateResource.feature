Feature: Validate update resource

  Scenario: Verify user can create a resource
    Given user wants to call "/posts/1" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "update_resource.json"
    When user performs put call
    Then verify status code is 200