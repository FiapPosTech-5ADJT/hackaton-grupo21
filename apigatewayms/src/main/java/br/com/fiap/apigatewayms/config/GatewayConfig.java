package br.com.fiap.apigatewayms.config;

import br.com.fiap.apigatewayms.gateway.TokenAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  private final TokenAuthenticationFilter tokenAuthenticationFilter;

  public GatewayConfig(TokenAuthenticationFilter tokenAuthenticationFilter) {
    this.tokenAuthenticationFilter = tokenAuthenticationFilter;
  }

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
      .route("exames-service", r -> r.path("/api/exames/**")
        .filters(f -> f.filter(tokenAuthenticationFilter.apply(new TokenAuthenticationFilter.Config())))
        .uri("http://localhost:8082"))
      .route("autenticacao-service", r -> r.path("/login")
        .filters(f -> f.rewritePath("/login", "/oauth/login"))
        .uri("http://localhost:8081"))
        .route("users-service", r -> r.path("/users/list")
          .filters(f -> f.filter(tokenAuthenticationFilter.apply(new TokenAuthenticationFilter.Config())))
          .uri("http://localhost:8081"))
        .build();
  }
}
