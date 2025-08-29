package tests;

import clients.UserClient;
import helper.ApiHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaginationTests {

    @Test
    void pagination() {
        Response userListResponse = UserClient.GET_USERS();
        List<Map<String, Object>> pageOneData = new ArrayList<>();
        List<Map<String, Object>> pageTwoData = new ArrayList<>();
        int totalPageNum = userListResponse.jsonPath().getInt("total_pages");
        for (int i = 1; i <= totalPageNum; i++) {
            Response pageResponse = UserClient.GET_USER_LIST_BY_PAGE(i);
            ApiHelper.verifyStatusCode(pageResponse.getStatusCode(), 200);
            ApiHelper.verifyJSONPayload(pageResponse.jsonPath().getInt(" page"), i);
            ApiHelper.verifyJSONPayload(pageResponse.jsonPath().getInt("per_page"), 6);
            ApiHelper.verifyJSONPayload(pageResponse.jsonPath().getInt("total"), 12);
            ApiHelper.verifyJSONPayload(pageResponse.jsonPath().getInt("total_pages"), totalPageNum);
            List<Map<String, Object>> currentPageData = pageResponse.jsonPath()
                    .getList("data.findAll { it }.collect { [id: it.id, email: it.email] }");
            if (i == 1) {
                pageOneData.addAll(currentPageData);
            } else if (i == 2) {
                pageTwoData.addAll(currentPageData);
            }
        }
        Assert.assertNotEquals(pageOneData, pageTwoData, "Page 1 and Page 2 contain duplicate users");
    }
}
