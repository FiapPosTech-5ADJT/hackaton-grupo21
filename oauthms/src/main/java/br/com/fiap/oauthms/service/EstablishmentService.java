package br.com.fiap.oauthms.service;

import br.com.fiap.oauthms.entity.Establishment;
import br.com.fiap.oauthms.repository.EstablishmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstablishmentService {

    private EstablishmentRepository establishmentRepository;

    public Establishment findById(Long id) {
        return establishmentRepository.findById(id).orElseThrow();
    }

    public Establishment save(Establishment establishment) {
        return establishmentRepository.save(establishment);
    }

}
