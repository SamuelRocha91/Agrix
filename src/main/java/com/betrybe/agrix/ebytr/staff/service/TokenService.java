package com.betrybe.agrix.ebytr.staff.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Implementa classe de criação e autenticação de Token.
 *
 */
@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  /**
   * Gera um token jwt.
   *
   * @param userDetails username e password.
   * @return jwt.
   */
  public String generateToken(UserDetails userDetails) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("agrix")
        .withSubject(userDetails.getUsername())
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now()
        .plusHours(2)
        .toInstant(ZoneOffset.of("-03:00"));
  }

  /**
   * valida o token se ainda está válido.
   *
   * @param token jwt.
   * @return a validação.
   */
  public String validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.require(algorithm)
        .withIssuer("agrix")
        .build()
        .verify(token)
        .getSubject();
  }
}