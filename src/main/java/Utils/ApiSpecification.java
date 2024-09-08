package Utils;

import static Constants.Urls.BASE_URL;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class ApiSpecification {

    public static RequestSpecification requestSpec() {
        Filter FORCE_JSON_RESPONSE_BODY = (reqSpec, respSpec, ctx) -> {
            Response response = ctx.next(reqSpec, respSpec);
            ((RestAssuredResponseOptionsImpl) response).setContentType("application/json");
            return response;
        };
        RestAssured.filters(FORCE_JSON_RESPONSE_BODY);

        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .filter(FORCE_JSON_RESPONSE_BODY);
    }

    public Response get(String path){
        return requestSpec()
                .get(path);
    }

    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification responseSpec404NotFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    public static ResponseSpecification responseSpecUnique(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

}
