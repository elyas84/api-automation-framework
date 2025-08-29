package tests;


import clients.UserClient;
import config.ConfigReader;
import helper.ApiHelper;
import io.restassured.response.Response;
import modules.LoginReq;
import modules.LoginRes;
import org.testng.annotations.Test;
import utils.AuthUtil;

public class LoginTests {

    @Test
    void postRequestWithValidCredentials() {
        LoginReq loginReq = new LoginReq(ConfigReader.get("email"), ConfigReader.get("password"));
        Response response = UserClient.LOGIN(loginReq);
        LoginRes loginRes = response.as(LoginRes.class);
        ApiHelper.verifyStatusCode(response.getStatusCode(), 200);
        ApiHelper.verifyToken(AuthUtil.getTOKEN(true));
        ApiHelper.verifyErrorNotCreated(loginRes.getError());
    }

    @Test
    void postRequestWithInValidCredentials() {
        LoginReq loginReq = new LoginReq(ConfigReader.get("invalid_email"), ConfigReader.get("invalid_password"));
        Response response = UserClient.LOGIN(loginReq);
        LoginRes loginRes = response.as(LoginRes.class);
        ApiHelper.verifyStatusCode(response.getStatusCode(), 400);
        ApiHelper.verifyTokenNotCreated(AuthUtil.getTOKEN(false));
        ApiHelper.verifyError(loginRes.getError());
    }
}
