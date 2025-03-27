package br.com.fiap.oauthms.requests;

public record CreateUserRequest(String name, String email, String password, Long idEstablishment, String role) {
}
