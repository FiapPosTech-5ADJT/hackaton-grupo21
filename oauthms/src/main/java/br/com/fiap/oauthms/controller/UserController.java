package br.com.fiap.oauthms.controller;

import br.com.fiap.oauthms.entity.Users;
import br.com.fiap.oauthms.requests.CreateUserRequest;
import br.com.fiap.oauthms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CreateUserRequest data) {
        userService.save(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Users>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
