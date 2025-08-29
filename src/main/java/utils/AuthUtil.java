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
     * @param validCred
     * @return
     */
    public static String getTOKEN(boolean validCred) {
        logger.info("Get the token");
        if (validCred) {
            LoginReq loginReq = new LoginReq(ConfigReader.get("email"), ConfigReader.get("password"));
            Response response = UserClient.LOGIN(loginReq);
            LoginRes loginRes = response.as(LoginRes.class);
            TOKEN = loginRes.getToken();
        } else {
            return null;
        }
        return TOKEN;
    }
}

