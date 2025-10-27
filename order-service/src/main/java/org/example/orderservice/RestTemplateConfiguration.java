package org.example.orderservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced   // 입력받는 URL로의 요청은 자동으로 로드 밸런싱 수행
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
