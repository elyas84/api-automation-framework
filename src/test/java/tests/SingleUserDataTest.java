package tests;

import clients.UserClient;
import helper.ApiHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleUserDataTest {
    @Test
    void singleUserData() {
        Response singleUseResponse = UserClient.GET_USER_BY_ID(2);
        ApiHelper.verifyStatusCode(singleUseResponse.getStatusCode(), 200);
        ApiHelper.verifyJSONPayload(singleUseResponse.jsonPath().getInt("data.id"), 2);
        ApiHelper.verifyJSONPayload(singleUseResponse.jsonPath().getString("data.email"), "janet.weaver@reqres.in");
        ApiHelper.verifyJSONPayload(singleUseResponse.jsonPath().getString("data.first_name"), "Janet");
        ApiHelper.verifyJSONPayload(singleUseResponse.jsonPath().getString("data.last_name"), "Weaver");
        ApiHelper.verifyJSONPayload(singleUseResponse.jsonPath().getString("data.avatar"), "https://reqres.in/img/faces/2-image.jpg");
    }

}
