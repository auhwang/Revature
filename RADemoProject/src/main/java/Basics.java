import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class Basics {

	public static void main(String[] args) {
		// BaseURL or Host
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		/*
		 * given -> when -> then -> extract
		 * 	- given - Request Headers, Parameters, cookies, body
		 * 	- when - get(resource), post(resource), put(resource)
		 * 	- then - assertions to make sure we are getting the correct response
		 *
		 */
			
		given().
			param("location", "-33.8670522,151.1957362").
			param("radius","500").
			param("key","AIzaSyDTp_ZCt2WjL9WvKOY1nf50sXWuYAAnzuI").
		when().
			get("/maps/api/place/nearbysearch/json").
		then().
			assertThat().statusCode(200)
		.and().
			contentType(ContentType.JSON)
		.and().
			body("results[0].name",equalTo("Sydney"));

	}

}
