package controllers;

import com.google.inject.Inject;
import org.elasticsearch.client.RestClient;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class EmployeeController {

    @Inject
    private RestClient restClient;

    public EmployeeController(RestClient restClient) {
        this.restClient = restClient;
    }

    public Result connection(){
        return ok("Connected");
    }
}
