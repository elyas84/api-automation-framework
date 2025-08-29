package tests;

import clients.UserClient;
import helper.ApiHelper;
import io.restassured.response.Response;
import modules.User;
import org.testng.annotations.Test;

public class CreateNewUserTest {
    @Test
    void createNewUser() {
        User newUser = new User("john@gmail.com", "avata.png", "Deo", "John", "developer");
        Response response = UserClient.NEW_USER(newUser);
        ApiHelper.verifyStatusCode(response.getStatusCode(), 201);
        ApiHelper.verifyJSONPayload(response.jsonPath().getString("email"), newUser.getEmail());
        ApiHelper.verifyJSONPayload(response.jsonPath().getString("first_name"), newUser.getFirst_name());
        ApiHelper.verifyJSONPayload(response.jsonPath().getString("last_name"), newUser.getLast_name());
        ApiHelper.verifyJSONPayload(response.jsonPath().getString("job"), newUser.getJob());
        ApiHelper.verifyJSONPayload(response.jsonPath().getString("avatar"), newUser.getAvatar());
        System.out.println(response.prettyPrint());
    }
}
