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
            .path("/language-details/**")
            .uri("lb://COUNTRY-LANGUAGES-SERVICE"))
        .route(p -> p
            .path("/country/**")
            .uri("lb://COUNTRY-SERVICE"))
        .route(p -> p
            .path("/city/**")
            .uri("lb://COUNTRY-SERVICE"))
        .build();
  }
}
