package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationSerice implements PetSerice {

    private final PetRepository petRepository;
    private final ClienteService clienteService;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] PetApplicationSerice - criaPet");
        clienteService.buscaClientePorId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[finaliza] PetApplicationSerice - criaPet");
        return PetResponse.builder()
                .idPet(pet.getIdPet())
                .build();
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoCliente(UUID idCliente) {
        log.info("[inicia] PetApplicationSerice - buscaPetsDoCliente");
        clienteService.buscaClientePorId(idCliente);
        List<Pet> pet = petRepository.buscaPetsDoCliente(idCliente);
        log.info("[finaliza] PetApplicationSerice - buscaPetsDoCliente");
        return PetClienteListResponse.converte(pet);
    }

    @Override
    public PetDetalhadoResponse buscaPetPorId(UUID idCliente, UUID idPet) {
        log.info("[inicia] PetApplicationSerice - buscaPetPorId");
        clienteService.buscaClientePorId(idCliente);
        Pet pet = petRepository.buscaPetPorid(idPet);
        log.info("[finaliza] PetApplicationSerice - buscaPetPorId");
        return new PetDetalhadoResponse(pet);
    }
}
