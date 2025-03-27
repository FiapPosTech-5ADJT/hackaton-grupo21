package br.com.fiap.oauthms.service;

import br.com.fiap.oauthms.entity.Establishment;
import br.com.fiap.oauthms.entity.Users;
import br.com.fiap.oauthms.repository.UserRepository;
import br.com.fiap.oauthms.requests.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EstablishmentService establishmentService;

    public Users save(CreateUserRequest data) {
        Users users;
        Establishment establishment = establishmentService.findById(data.idEstablishment());
        users = new Users(data.name(), data.email(), data.password(), establishment, data.role());
        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
        return userRepository.save(users);
    }

}
