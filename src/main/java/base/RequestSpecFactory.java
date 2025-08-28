package base;

import config.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestSpecFactory {
    private static final Logger logger = LogManager.getLogger(RequestSpecFactory.class.getName());
    private static RequestSpecification requestSpec;

    public static RequestSpecification getRequestSpecification() {
        logger.info("Prepare request spec [{}] [{}] provided.", ApiConfig.BASE_URI, ApiConfig.API_KEY);

        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder().setBaseUri(ApiConfig.BASE_URI)
                    .setContentType(ContentType.JSON).addHeader("x-api-key", ApiConfig.API_KEY).build();
        }
        return requestSpec;
    }
}
