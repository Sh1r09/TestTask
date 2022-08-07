Feature:

  Scenario Outline:
    Given User opens '<homePage>' page
    When user click on the button
    And user enter first location '<locationOne>' in the field
    And user enter second location '<locationTwo>' in the field
    And user click on transport option button
    And user select one in the transport option dropdown list
    When user click Go button
    Then verify the Distance is '<distance>'

    Examples:
      | homePage                       | locationOne    | locationTwo | distance |
      | https://www.openstreetmap.org/ | Радищева, Київ | Кембридж    | 2423     |
