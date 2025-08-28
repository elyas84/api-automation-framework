package tests.api;

import base.TestBase;
import clients.UserClient;
import config.ConfigReader;
import io.restassured.response.Response;
import modules.LoginReq;
import modules.LoginRes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    void postRequestWithValidCredentials() {
        LoginReq loginReq = new LoginReq(ConfigReader.get("email"), ConfigReader.get("password"));
        Response response = UserClient.LOGIN(loginReq);
        LoginRes loginRes = response.as(LoginRes.class);
        /**
         * Assertion
         */
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getHeaders().get("Content-Type").getValue().contains("application/json"), "application/json is expected");
        Assert.assertNotNull(loginRes.getToken(), "Token must be created");
        Assert.assertNull(loginRes.getError(), "Error msg cannot be created");
    }

    @Test
    void postRequestWithInValidCredentials() {
        LoginReq loginReq = new LoginReq(ConfigReader.get("invalid_email"), ConfigReader.get("invalid_password"));
        Response response = UserClient.LOGIN(loginReq);
        LoginRes loginRes = response.as(LoginRes.class);
        /**
         * Assertion
         */
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertNull(loginRes.getToken(), "Token cannot be created");
        Assert.assertNotNull(loginRes.getError(), "Error must be created");


    }
}
