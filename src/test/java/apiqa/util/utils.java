package apiqa.util;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class utils 
{
	@BeforeMethod
	public void beforemethod() 
	{
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
}
