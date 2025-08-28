package clients;


import base.RequestSpecFactory;
import config.ApiConfig;
import io.restassured.*;
import io.restassured.response.Response;
import modules.LoginReq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserClient {
    private static final Logger logger = LogManager.getLogger(UserClient.class.getName());

    /**
     * GET user list by page
     */

    public static Response GET_USER_LIST_BY_PAGE(int page) {
        logger.info("GET user list by [{}]", page);
        Response response = RestAssured.given().spec(RequestSpecFactory.getRequestSpecification()).when().
                get("/users?page=" + page).then().extract()
                .response();
        return response;
    }

    /**
     * GET users byID
     */
    public static Response GET_USER_BY_ID(int id) {
        logger.info("GET a single user by id");
        Response response = RestAssured.given().
                spec(RequestSpecFactory.getRequestSpecification()).when().
                get("/users/" + id).then().extract().response();
        return response;
    }

    /**
     * POST ==> Login request
     */

    public static Response LOGIN(LoginReq loginReq) {
        logger.info("[POST] perform login");
        Response response = RestAssured.given().
                spec(RequestSpecFactory.getRequestSpecification()).body(loginReq).when().post("/login").then().extract().response();
        return response;
    }


}
