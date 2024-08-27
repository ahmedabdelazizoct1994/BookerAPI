package books_apis;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class BooksAPIs extends BaseAPI {


    private static String BASE_BOOKS_URL ;


    public BooksAPIs() throws IOException {
        super();
        BASE_BOOKS_URL = BASE_URL_BOOKS;

    }


        public Response generateAuthToken(String userName, String password) {
            RestAssured.baseURI =BASE_URL_BOOKS + "/auth";

            String generateAuthTokenRequestBody = "{\n" +
                    "    \"username\": \"" + userName + "\",\n" +
                    "    \"password\": \"" + password + "\"\n" +
                    "}";

            Response generateAuthTokenResponse = given().headers("Content-Type", ContentType.JSON.toString())
                    .body(generateAuthTokenRequestBody)
                    .when()
                    .post();
            return generateAuthTokenResponse;
    }

    public Response retrieveAllBooks() {
        return RestAssured.get(BASE_BOOKS_URL.concat("/booking"));
    }





    public Response createBooking(String firstname, String lastName, String totalPrice, String  depositPaid, String checkIn, String checkout, String additionalNeeds) {


        RestAssured.baseURI = BASE_BOOKS_URL +"/" + "booking";


        String createBookingRequestBody = "{\n" +
                "    \"firstname\": \"" + firstname + "\",\n" +
                "    \"lastname\": \"" + lastName + "\",\n" +
                "    \"totalprice\": " + totalPrice + ",\n" +
                "    \"depositpaid\": " + depositPaid + ",\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"" + checkIn + "\",\n" +
                "        \"checkout\": \"" + checkout + "\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"" + additionalNeeds + "\"\n" +
                "}";

        Response createBookingResponse = given().headers("Content-Type", ContentType.JSON.toString())
                .body(createBookingRequestBody)
                .when()
                .post();
        return createBookingResponse;
    }
}
