package apiqa.testauto.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import apiqa.pojo.BookingDates;
import apiqa.pojo.booking;
import apiqa.util.filenameconstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class postreqpojo 
{
	@Test
	public void pojoreq() throws IOException 
	{
		
		BookingDates bookingDates = new BookingDates("2024-01-01", "2024-02-02");
		booking booking = new booking("Steve testing", "QA1", "breakfast", 1000, true, bookingDates);
		
		//serialization
		ObjectMapper objectMapper = new ObjectMapper();
		try 
		{
			String jsonSchema = FileUtils.readFileToString(new File(filenameconstants.JSON_SCHEMA),"UTF-8");
			
			String requestBody  = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
			System.out.println(requestBody);
			
			//De-serialization
			booking bookingdetails=objectMapper.readValue(requestBody, booking.class);
			System.out.println(bookingdetails.getFirstname());
			System.out.println(bookingdetails.getTotalprice());
			System.out.println(bookingdetails.getBookingdates().getCheckin());
			System.out.println(bookingdetails.getBookingdates().getCheckout());
			
			Response response =
			RestAssured
				.given()
					.contentType(ContentType.JSON)
					.body(requestBody)
					.baseUri("https://restful-booker.herokuapp.com/booking")
				.when()
					.post()
				.then()
					.assertThat()
					.statusCode(200)
					.log().all()
				.extract()
					.response();
			
			int id=response.path("bookingid");	
			System.out.println("Get new Booking ID:"+id);
			
			System.out.println("Josn Schema Output" + jsonSchema );

			RestAssured
				.given()
					.contentType(ContentType.JSON)
					.baseUri("https://restful-booker.herokuapp.com/booking")
				.when()
					.get("/{:bookingID}",id)
				.then()
					.assertThat()
					.statusCode(200)
					.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
			
		} catch (JsonProcessingException e) 
		{
			e.printStackTrace();
		}
	}
	

}
