Feature: Validate create resource

  Scenario: Verify user can create a resource
    Given user wants to call "/posts" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_resource.json"
    When user performs post call
    Then verify status code is 201
    And verify id is not empty
    And stores created id into "resource.id"
    When user wants to call "/posts/@id" end point
    And user performs get call
    Then verify status code is 404