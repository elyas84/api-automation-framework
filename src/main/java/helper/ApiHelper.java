package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class ApiHelper {
    private static final Logger logger = LogManager.getLogger(ApiHelper.class.getName());

    /**
     * @param actualStatusCode
     * @param expectedStatusCode
     */
    public static void verifyStatusCode(int actualStatusCode, int expectedStatusCode) {
        logger.info("Verify status code");
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match");
    }

    /**
     * @param actualPayload
     * @param expectedPayload
     */
    public static void verifyJSONPayload(Object actualPayload, Object expectedPayload) {
        logger.info("Verify json payload");
        Assert.assertEquals(actualPayload, expectedPayload, "[" + expectedPayload + "] but found [" + actualPayload + "]");
    }


    /**
     * @param expectedToken
     */
    public static void verifyToken(String expectedToken) {
        logger.info("verify token is created");
        Assert.assertNotNull(expectedToken, "Token must be created");
    }

    /**
     * @param expectedToken
     */
    public static void verifyTokenNotCreated(String expectedToken) {
        logger.info("verify token not created");
        Assert.assertNull(expectedToken, "Token cannot be created");
    }

    /**
     * @param expectedError
     */
    public static void verifyError(String expectedError) {
        logger.info("verify error is created");
        Assert.assertNotNull(expectedError, "Token must be created");
    }

    /**
     * @param expectedError
     */
    public static void verifyErrorNotCreated(String expectedError) {
        logger.info("verify error not created");
        Assert.assertNull(expectedError, "Error cannot be created");
    }

}
