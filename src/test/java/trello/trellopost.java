package trello;

import org.testng.Assert;
import org.testng.annotations.Test;
import apiqa.pojo.queryparams;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class trellopost extends queryparams
{

	@Test
	public void trellopostapi() 
	{

	// Post Trello Scenario //
	Response response=
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.baseUri("https://api.trello.com/1/cards")
				.queryParams(qryparamspost())
				.log().uri()
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(200)
			.extract()
				.response();
						
		Assert.assertTrue(response.body().asString().contains("QA1"));
		String cardid=response.path("id");
		System.out.println("POST CARD ID:"+cardid);
		
		
		/* Get Trello Scenario */
			Response responseget=
				RestAssured
					.given()
						.contentType(ContentType.JSON)
						.baseUri("https://api.trello.com/1/cards")
						.queryParams(qryparamsget())
						.log().uri()
					.when()
						.get("{:id}",cardid)
					.then()
						.assertThat()
						.statusCode(200)
					.extract()
						.response();
			System.out.println("Get reponse info:"+responseget.body().asString().contains("QA1"));

			
			/* PUT Trello Scenario */
			Response responseput=
					RestAssured
					.given()
						.contentType(ContentType.JSON)
						.baseUri("https://api.trello.com/1/cards")
						.queryParams(qryparamsput())
						.log().uri()
					.when()
						.put("{:id}",cardid)
					.then()
						.assertThat()
						.statusCode(200)
					.extract()
						.response();
			System.out.println("PUT reponse info:"+responseput.body().asString().contains("QA123"));
			
				/* DELETE CARD ID  Trello Scenario */
			
			Response responsedel=
					RestAssured
					.given()
						.contentType(ContentType.JSON)
						.baseUri("https://api.trello.com/1/cards")
						.queryParams(qryparamsget())
						.log().uri()
					.when()
						.delete("{:id}",cardid)
					.then()
						.assertThat()
						.statusCode(200)
					.extract()
						.response();
			System.out.println("DELETE reponse info:"+responsedel.body().asString().contains("QA123"));
			

	}
}
