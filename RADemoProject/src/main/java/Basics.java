import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Basics {

	public static void main(String[] args) {
		// BaseURL or Host
		RestAssured.baseURI = "http://maps.googleapis.com";
		
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
			param("Key","AIzaSyB7QoZPYfMVkc8TgCIV3i6HZWZCR-X6c34").
		when().
			get("maps/api/place/nearbysearch/json").
		then().
			assertThat().statusCode(200);

	}

}
