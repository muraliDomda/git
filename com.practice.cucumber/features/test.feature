Feature: facebook login
  to test login functionality


  Scenario: Get info from wether info service
    Given I set base uri to wether info service
    When I perform get request for "/Hyderabad" end point
    Then I see  response with  success status
    Then I see info in below format
      | keyname            | keyvalue         |
      | City               | Hyderabad        |
      | WindSpeed          | 3.1 Km per hour  |
      | WeatherDescription | scattered clouds |
