package config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

public class EsConnection extends AbstractModule {
    @Provides
    public RestClient esClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost",9200,"http")
        ).build();
        return restClient;
    }

}
