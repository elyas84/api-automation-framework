package config;

public class ApiConfig {
    public static  final String BASE_URI = ConfigReader.get("base_uri");
    public static  final String API_KEY = ConfigReader.get("apikey");

    /**
     * We can specify testing env here
     * e.g like Enum --> QA, STAGE, PROD
     */
}
