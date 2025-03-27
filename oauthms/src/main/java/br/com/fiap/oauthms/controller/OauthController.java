package br.com.fiap.oauthms.controller;

import br.com.fiap.oauthms.entity.Users;
import br.com.fiap.oauthms.requests.UserLoginRequest;
import br.com.fiap.oauthms.response.UserLoginResponse;
import br.com.fiap.oauthms.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oauth")
public class OauthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest data) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(data.email(), data.password());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        if (!(auth.getPrincipal() instanceof Users)) {
            return ResponseEntity.status(401).build();
        }

        Users user = (Users) auth.getPrincipal();
        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new UserLoginResponse(token));
    }


}
