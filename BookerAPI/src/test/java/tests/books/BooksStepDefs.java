package tests.books;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import books_apis.BaseAPI;
import books_apis.BooksAPIs;


import java.io.IOException;
import java.util.List;

 public class BooksStepDefs extends BaseAPI {
    BooksAPIs booksAPIs = new BooksAPIs();
    String token;
    private Response authResponse;
    private Response bookingResponse;
    private Response allBooksResponse;

    public BooksStepDefs() throws IOException {
    }

    @When("user creates an auth token with userName {string} and password {string}")
    public void userCreatesAnAuthTokenWithUserNameAndPassword(String userName, String password) {
        authResponse = booksAPIs.generateAuthToken(booksDataProperties.getProperty(userName),
                booksDataProperties.getProperty(password));
        token = authResponse.jsonPath().getString("token");
    }
    @Then("validate the response is not empty")
    public void validateTheResponseIsNotEmpty() {
        Assert.assertNotNull("The response body is empty", authResponse.getBody().asString());

    }

    @Then("validate the token is generated successfully")
    public void validate_the_token_is_generated_successfully() {
        Assert.assertNotNull("Token is not generated", token);

    }


    @When("user creates a booking with firstname {string}, lastName {string}, totalPrice {string}, depositPaid {string}, checkIn {string}, checkout {string}, and additionalNeeds {string}")
    public void userCreatesABookingWithFirstnameLastNameTotalPriceDepositPaidCheckInCheckoutAndAdditionalNeeds(String firstName, String lastName, String totalPrice, String depositPaid, String checkIn, String checkout, String additionalNeeds ) {
        bookingResponse = booksAPIs.createBooking(booksDataProperties.getProperty(firstName)
                ,booksDataProperties.getProperty(lastName),
                booksDataProperties.getProperty(totalPrice),
                booksDataProperties.getProperty(depositPaid),
                booksDataProperties.getProperty(checkIn),
                booksDataProperties.getProperty(checkout),
                booksDataProperties.getProperty(additionalNeeds));
    }


    @Then("validate the booking is successfully added with firstname {string}, lastName {string}, totalPrice <totalPrice>, depositPaid <depositPaid>, checkIn {string}, checkout {string}, and additionalNeeds {string}")
    public void validateTheBookingIsSuccessfullyAddedWithFirstnameLastNameTotalPriceTotalPriceDepositPaidDepositPaidCheckInCheckoutAndAdditionalNeeds(String firstName, String lastName, String totalPrice, String depositPaid, String checkIn, String checkout, String additionalNeeds) {
        Assert.assertEquals(200, bookingResponse.getStatusCode());

        String bookingFirstName = bookingResponse.jsonPath().getString("booking.firstname");
        String bookingLastName = bookingResponse.jsonPath().getString("booking.lastname");
        String bookingTotalPrice = bookingResponse.jsonPath().getString("booking.totalprice");
        String bookingDepositPaid = bookingResponse.jsonPath().getString("booking.depositpaid");
        String bookingCheckIn = bookingResponse.jsonPath().getString("booking.bookingdates.checkin");
        String bookingCheckout = bookingResponse.jsonPath().getString("booking.bookingdates.checkout");
        String bookingAdditionalNeeds = bookingResponse.jsonPath().getString("booking.additionalneeds");


        Assert.assertEquals(firstName, bookingFirstName);
        Assert.assertEquals(lastName, bookingLastName);
        Assert.assertEquals(totalPrice, bookingTotalPrice);
        Assert.assertEquals(depositPaid, bookingDepositPaid);
        Assert.assertEquals(checkIn, bookingCheckIn);
        Assert.assertEquals(checkout, bookingCheckout);
        Assert.assertEquals(additionalNeeds, bookingAdditionalNeeds);
    }

    @Then("validate the booking is successfully added with firstname {string}, lastName {string}, totalPrice {string}, depositPaid {string}, checkIn {string}, checkout {string}, and additionalNeeds {string}")
    public void validateTheBookingIsSuccessfullyAddedWithFirstnameLastNameTotalPriceDepositPaidCheckInCheckoutAndAdditionalNeeds(String firstName, String lastName, String totalPrice, String depositPaid, String checkIn, String checkout, String additionalNeeds) {
        Assert.assertEquals(200, bookingResponse.getStatusCode());

        // String responseJson = bookingResponse.getBody().asString();
        String bookingFirstName = bookingResponse.jsonPath().getString("booking.firstname");
        String bookingLastName = bookingResponse.jsonPath().getString("booking.lastname");
        String bookingTotalPrice = bookingResponse.jsonPath().getString("booking.totalprice");
        String bookingDepositPaid = bookingResponse.jsonPath().getString("booking.depositpaid");
        String bookingCheckIn = bookingResponse.jsonPath().getString("booking.bookingdates.checkin");
        String bookingCheckout = bookingResponse.jsonPath().getString("booking.bookingdates.checkout");
        String bookingAdditionalNeeds = bookingResponse.jsonPath().getString("booking.additionalneeds");


        Assert.assertEquals(firstName, bookingFirstName);
        Assert.assertEquals(lastName, bookingLastName);
        Assert.assertEquals(totalPrice, bookingTotalPrice);
        Assert.assertEquals(depositPaid, bookingDepositPaid);
        Assert.assertEquals(checkIn, bookingCheckIn);
        Assert.assertEquals(checkout, bookingCheckout);
        Assert.assertEquals(additionalNeeds, bookingAdditionalNeeds);
    }

    @When("user retrieves all bookings")
    public void userRetrievesAllBookings() {
        allBooksResponse =booksAPIs.retrieveAllBooks();
    }
    @Then("validate that the list of bookings is greater than zero")
    public void validateThatTheListOfBookingsIsGreaterThanZero() {
        Assert.assertEquals(200, allBooksResponse.getStatusCode());

        List<?> bookingsList = allBooksResponse.jsonPath().getList("");

        Assert.assertTrue(bookingsList.size() > 0, "The list of bookings should be greater than zero");
    }



}