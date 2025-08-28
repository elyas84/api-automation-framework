package utils;

import clients.UserClient;
import config.ConfigReader;
import io.restassured.response.Response;
import modules.LoginReq;
import modules.LoginRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthUtil {
    private static final Logger logger = LogManager.getLogger(AuthUtil.class.getName());
    private static String TOKEN;

    /**
     * perform login and retrieve TOKEN
     */
    public static String getTOKEN() {
        logger.info("Login and get the token");
        LoginReq loginReq = new LoginReq(ConfigReader.get("email"), ConfigReader.get("password"));
        Response response = UserClient.LOGIN(loginReq);
        LoginRes loginRes = response.as(LoginRes.class);
        if (loginRes.getToken() == null) {
            throw new RuntimeException(loginRes.getError());
        } else {
            TOKEN = loginRes.getToken();
        }
        return TOKEN;
    }
}

