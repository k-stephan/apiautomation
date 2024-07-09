package mars;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import apiqa.util.filenameconstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class marsapi 
{
	@Test
	public void bearertoken()
	{
		try 
		{
			
			String payloaddata=FileUtils.readFileToString(new File(filenameconstants.PAYLOAD), "UTF-8");
		
	Response response=
			
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.body(payloaddata)
				.baseUri("https://imarscrmdev.phxa.com/MARSRestAPI/api/token/generatetoken")
				//.log().all()
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(200)
				//.log().all()
			.extract()
				.response();
		
	String TokenID=response.path("Token");
	System.out.println("Token ID:"+TokenID);
	
	//String responseBody = response.getBody().asString();
	//System.out.println(responseBody);
		
		} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	
	
}
