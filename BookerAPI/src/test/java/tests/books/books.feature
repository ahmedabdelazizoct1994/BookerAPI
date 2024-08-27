Feature: As a user, I want to handle Books

  @GenerateAuthToken
  Scenario Outline: I need to generate an auth token
    When user creates an auth token with userName "<userName>" and password "<password>"
    Then validate the response is not empty
    And validate the token is generated successfully

    Examples:
      | userName | password |
      | userName | password |

  @BookCreation
  Scenario Outline: Verify that a booking is added successfully
    When user creates a booking with firstname "<firstName>", lastName "<lastName>", totalPrice "<totalPrice>", depositPaid "<depositPaid>", checkIn "<checkIn>", checkout "<checkout>", and additionalNeeds "<additionalNeeds>"
    Then validate the booking is successfully added with firstname "<firstName>", lastName "<lastName>", totalPrice "<totalPrice>", depositPaid "<depositPaid>", checkIn "<checkIn>", checkout "<checkout>", and additionalNeeds "<additionalNeeds>"

    Examples:
      | firstName | lastName | totalPrice | depositPaid | checkIn | checkout | additionalNeeds |
      | firstName | lastName | totalPrice | depositPaid | checkIn | checkout | additionalNeeds |


  @RetrieveAllBooks
  Scenario: Verify that the list of bookings is greater than zero
    When user retrieves all bookings
    Then validate that the list of bookings is greater than zero
