package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationSerice implements PetSerice {

    private final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] PetApplicationSerice - criaPet");
        Pet pet = petRepository.salvaPet(new Pet(petRequest));
        log.info("[finaliza] PetApplicationSerice - criaPet");
        return PetResponse.builder()
                .idPet(pet.getIdPet())
                .build();
    }
}
