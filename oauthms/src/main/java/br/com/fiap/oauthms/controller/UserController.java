package br.com.fiap.oauthms.controller;

import br.com.fiap.oauthms.requests.CreateUserRequest;
import br.com.fiap.oauthms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CreateUserRequest data) {
        userService.save(data);

        return ResponseEntity.ok().build();
    }
}
