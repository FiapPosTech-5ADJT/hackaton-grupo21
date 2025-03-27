package br.com.fiap.oauthms.entity;

public enum Roles {

    ADMIN("admin"),
    PROFISSIONAL_ATENDIMENTO("profissional atendimento"),
    PROFISSIONAL_AUXILIAR("profissional auxiliar");

    private String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
