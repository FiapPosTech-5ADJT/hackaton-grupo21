package br.com.fiap.oauthms.controller;

import br.com.fiap.oauthms.entity.Establishment;
import br.com.fiap.oauthms.requests.CreateEstablishmentRequest;
import br.com.fiap.oauthms.service.EstablishmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/establishment")
@AllArgsConstructor
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    @PostMapping("/save")
    public ResponseEntity<Establishment> save(@RequestBody CreateEstablishmentRequest request) {
        Establishment establishment = new Establishment(null, request.nome(), request.endereco(), request.cnpj());
        Establishment savedEstablishment = establishmentService.save(establishment);
        return ResponseEntity.ok(savedEstablishment);
    }
}