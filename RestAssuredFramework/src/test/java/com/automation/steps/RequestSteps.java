package com.automation.steps;

import com.automation.pojo.CreateResourcePojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps {

    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) {
        String resourceId = ConfigReader.getConfigValue("resource.id");
        if (endPoint.contains("@")) {
            endPoint = endPoint.replace("@id", resourceId);
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @Given("set request body from the file {string}")
    public void set_request_body_from_the_file(String fileName) throws JsonProcessingException {
        String jsonFolderPath = ConfigReader.getConfigValue("json.folder.path");
        String jsonBody = RestAssuredUtils.getDataFromFile(jsonFolderPath + fileName);

        ObjectMapper objectMapper = new ObjectMapper();
        CreateResourcePojo createResourcePojo = objectMapper.readValue(jsonBody, CreateResourcePojo.class);

        RestAssuredUtils.setBodyUsingPojo(createResourcePojo);
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
    }

    @When("user performs get call")
    public void user_performs_get_call() {
        RestAssuredUtils.get();
    }

    @When("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredUtils.put();
    }

    @And("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }
}
