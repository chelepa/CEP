package br.com.cep.client;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ViaCepConfig {

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

}
