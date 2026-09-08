package africa.bookCatalog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ConfigClient {

    @Value("${gutenberg.api.key}")
    private String apiKey;

    @Value("${gutenberg.api.host}")
    private String apiHost;

    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("https: //"+apiHost)
                .defaultHeader("X-RapidAPI-Key",apiKey)
                .defaultHeader("X-RapidAPI-Host",apiHost).build();
    }








}
