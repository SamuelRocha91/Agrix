package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.AuthenticationDto;
import com.betrybe.agrix.ebytr.staff.dto.TokenDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import com.betrybe.agrix.ebytr.staff.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cria classe que implementa a autenticação do usuário.
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;

  private final TokenService tokenService;

  @Autowired
  public AuthenticationController(AuthenticationManager authenticationManager,
      TokenService tokenService,
      PersonService personService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  /**
   * implementa rota de login do usuário.
   *
   * @param authenticationDto com username, password.
   * @return um token.
   */
  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody AuthenticationDto authenticationDto) {

    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(authenticationDto.username(),
            authenticationDto.password());
    Authentication auth = authenticationManager.authenticate(usernamePassword);
    UserDetails userDetails = (UserDetails) auth.getPrincipal();


    String token = tokenService.generateToken(userDetails);

    return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(token));
  }
}
