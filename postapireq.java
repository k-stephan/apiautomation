package apiqa.testauto.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import apiqa.util.utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;




public class postapireq extends utils
{
	@Test
	
	public void createbooking()
	{
		
		//RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		JSONObject booking = new JSONObject();
		JSONObject bookingdates = new JSONObject();

		booking.put("firstname", "Steve5");
		booking.put("lastname", "K");
		booking.put("totalprice", "1325");
		booking.put("depositpaid", "115");
		booking.put("additionalneeds", "New Booking");
		booking.put("bookingdates", bookingdates);
		bookingdates.put("checkin", "2024-01-01");
		bookingdates.put("checkout", "2024-02-02");
		
		//System.out.println(booking);
		Response response =
	
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(booking.toString())
				.baseUri("https://restful-booker.herokuapp.com/booking")
				//.log().body()
				//.log().headers()
				//.log().all()
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(200)
				.body("booking.firstname", Matchers.equalTo("Steve4"))
				//.log().all()
			.extract()
				.response();
				
		
		
		
		System.out.println(response.getBody().asString());

		//Assert.assertTrue(response.getBody().asString().contains("Steve4"));

	}
	
}
