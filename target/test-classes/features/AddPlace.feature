Feature: Add Place feature

@addPlace
Scenario Outline: verify add place 
    Given add place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "post" http request
    Then the API call got succes with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then place id should match in the "GetPlaceAPI" "<name>"
    Examples:
    |name|language|address|
    |siva|english| india|
    |kumar|telugu| andhra|
    
    