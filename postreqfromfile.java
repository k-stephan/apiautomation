package apiqa.testauto.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import apiqa.util.filenameconstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class postreqfromfile 
{
	@Test
	public void postapireq()
	{
			try 
			{
				String data=FileUtils.readFileToString(new File(filenameconstants.REQ_FILE_NM), "UTF-8");
				//System.out.println(data);
				
				Response response =
				RestAssured
					.given()
						.contentType(ContentType.JSON)
						.body(data)
						.baseUri("https://restful-booker.herokuapp.com/booking")
					.when()
						.post()
						
					.then()
						.assertThat()
						.statusCode(200)
					.extract()
						.response();
				
				Assert.assertTrue(response.getBody().asString().contains("Steve"));
				
				JSONArray jsonarray=JsonPath.read(response.body().asString(),"$.booking..firstname");
				System.out.println(jsonarray);
				String firstname =(String) jsonarray.get(0);
				System.out.println(firstname);
				
			}	
							
				catch (IOException e) 
				{
					e.printStackTrace();
				}
		
		
	}
}
