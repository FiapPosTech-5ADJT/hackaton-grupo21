package br.com.fiap.oauthms.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import br.com.fiap.oauthms.entity.Users;
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

    public String generateToken(final Users users) {
        if (users == null || users.getEmail() == null) {
            throw new IllegalArgumentException("User or email cannot be null");
        }
        try {
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(users.getEmail())
                    .withClaim("role", users.getRole().name())  // Adiciona a role no token
                    .withExpiresAt(genExpirationDate())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }


    public String validateToken(final String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
