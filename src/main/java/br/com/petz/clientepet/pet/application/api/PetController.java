package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.application.service.PetSerice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {

    private final PetSerice petService;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] PetController - criaPet");
        PetResponse pet = petService.criaPet(idCliente, petRequest);
        log.info("[finaliza] PetController - criaPet");
        return pet;
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoCliente(UUID idCliente) {
        log.info("[inicia] PetController - buscaPetsDoCliente");
        List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoCliente(idCliente);
        log.info("[finaliza] PetController - buscaPetsDoCliente");
        return petsDoCliente;
    }
}
