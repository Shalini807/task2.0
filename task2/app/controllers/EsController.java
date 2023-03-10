package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import data.EsClient;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import play.mvc.Http;
import play.mvc.Result;
import service.EsService;

import java.io.IOException;

import static play.mvc.Results.ok;

public class EsController {
    //    private RestClient restClient;
    private EsClient esClient;

    private EsService esService;
    @Inject
    public EsController(EsClient esClient, EsService esService) {
        this.esClient = esClient;
        this.esService = esService;
    }

    public Result add() throws IOException {
        System.out.println("connected to Elastic Search");
        String json = "{\"id\":\"1\",\"name\":\"Ruksana1\"}";
        Request request = new Request("POST", "/employee/_doc/1");
        request.setJsonEntity(json);
        Response response = esClient.getRestClient().performRequest(request);
        return ok(EntityUtils.toString(response.getEntity()));

    }


    //    public Result addDocument(Http.Request request) {
//        JsonNode requestBody = request.body().asJson();
//        Request request1 = new Request("PUT", "/employee/_doc/4");
//        try {
//            Response response = esClient.getRestClient().performRequest(request1);
//            System.out.println("Response code: " + response.getStatusLine().getStatusCode());
//
//        } catch (IOException e) {
//            return internalServerError(e.getMessage());
//        }
//        return ok("Success");
//    }
    public Result getDocument() throws IOException {
        Request request = new Request("GET", "/employee/_doc/1");
        Response response = esClient.getRestClient().performRequest(request);
        return ok(EntityUtils.toString(response.getEntity()));

    }
}
