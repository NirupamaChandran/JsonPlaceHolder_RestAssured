package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @Then("verify id is not empty")
    public void verify_id_is_not_empty() {
        String resourceId = RestAssuredUtils.getResponse().jsonPath().getString("id");
        Assert.assertTrue(!resourceId.isEmpty());
    }

    @Then("stores created id into {string}")
    public void stores_created_id_into(String key) {
        String resourceId = RestAssuredUtils.getResponse().jsonPath().getString("id");
        ConfigReader.setConfigValue(key, resourceId);
    }
}
