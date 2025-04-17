package br.com.fiap.apigatewayms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http
      .csrf().disable()
      .authorizeExchange(exchanges -> exchanges
        .pathMatchers("/login").permitAll()  // Libera o endpoint de login
        .anyExchange().authenticated()       // Exige token válido para outras rotas
      )
      // Remove completamente a configuração do OAuth2
      .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
      .build();
  }
}
