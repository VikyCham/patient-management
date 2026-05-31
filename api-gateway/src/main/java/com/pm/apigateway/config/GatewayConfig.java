package com.pm.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("patient-route",
                        r -> r.path("/api/patients", "/api/patients/**")
                                .filters(f -> f.stripPrefix(1))
                                .uri("http://patient-service:4000"))
                .build();
    }
}
