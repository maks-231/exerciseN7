package com.microservices.gatewayApi;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguration {
  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
    return routeLocatorBuilder.routes()
        .route(p -> p
            .path("/currency-exchange/**")
            .uri("lb://CURRENCY-EXCHANGE-SERVICE"))
        .route(p -> p
            .path("/customer-details/**")
            .uri("lb://CUSTOMER-EXCHANGE-SERVICE"))
        .route(p -> p
            .path("/currency-conversion-feign/**")
            .uri("lb://currency-conversion-service"))
        .route(p -> p.path("/currency-conversion/**")
            .uri("lb://currency-conversion-service"))
        .build();
  }
}
