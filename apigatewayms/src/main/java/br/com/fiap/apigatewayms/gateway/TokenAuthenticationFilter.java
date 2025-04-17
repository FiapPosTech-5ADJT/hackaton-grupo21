package br.com.fiap.apigatewayms.gateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
public class TokenAuthenticationFilter extends AbstractGatewayFilterFactory<TokenAuthenticationFilter.Config> {

  @Value("${api.security.token.secret}")
  private String secret;

  @Override
  public GatewayFilter apply(Config config) {
    return (exchange, chain) -> {
      String token = exchange.getRequest()
        .getHeaders()
        .getFirst(HttpHeaders.AUTHORIZATION);

      // Verifica se o token existe
      if (token == null || !token.startsWith("Bearer ")) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
      }

      // Extrai o token (remove "Bearer ")
      token = token.substring(7);

      try {
        // Valida o token JWT
        Claims claims = Jwts.parserBuilder()
          .setSigningKey(secret.getBytes())
          .build()
          .parseClaimsJws(token)
          .getBody();

        // Adiciona o ID do usuário ao cabeçalho para os microsserviços
        ServerHttpRequest mutatedRequest = exchange.getRequest()
          .mutate()
          .header("user-id", claims.getSubject())
          .build();

        // Continua o fluxo com o token validado
        return chain.filter(exchange.mutate().request(mutatedRequest).build());

      } catch (Exception e) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
      }
    };
  }

  public static class Config {}
}
