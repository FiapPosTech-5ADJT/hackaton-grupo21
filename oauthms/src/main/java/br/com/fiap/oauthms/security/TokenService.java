package br.com.fiap.oauthms.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import br.com.fiap.oauthms.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public String generateToken(final Users users) {
      if (users == null || users.getEmail() == null) {
        logger.error("Usuário ou email não pode ser nulo");
        throw new IllegalArgumentException("User or email cannot be null");
      }
      try {
        logger.info("Gerando token para o usuário: {}", users.getEmail());
        return JWT.create()
          .withIssuer("auth-api")
          .withSubject(users.getEmail())
          .withClaim("role", users.getRole().name())
          .withExpiresAt(genExpirationDate())
          .sign(Algorithm.HMAC256(secret));
      } catch (JWTCreationException exception) {
        logger.error("Erro ao gerar o token", exception);
        throw new RuntimeException("Error while generating token", exception);
      }
    }


    public String validateToken(final String token) {
      try {
        logger.debug("Validando token...");
        return JWT.require(Algorithm.HMAC256(secret))
          .withIssuer("auth-api")
          .build()
          .verify(token)
          .getSubject();
      } catch (JWTVerificationException exception) {
        logger.warn("Token inválido ou expirado");
        return "";
      }
    }

    private Instant genExpirationDate() {
      logger.trace("Gerando data de expiração do token");
      return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
