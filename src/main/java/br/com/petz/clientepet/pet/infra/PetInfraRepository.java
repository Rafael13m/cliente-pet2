package br.com.petz.clientepet.pet.infra;

import br.com.petz.clientepet.cliente.handler.APIException;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {


    private final PetSpringDataJpa PetSpringDataJpa;

    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[inicia] PetInfraRepository - salvaPet");
        PetSpringDataJpa.save(pet);
        log.info("[finaliza] PetInfraRepository - salvaPet");
        return pet;
    }

    @Override
    public List<Pet> buscaPetsDoCliente(UUID idCliente) {
        log.info("[inicia] PetInfraRepository - buscaPetsDoCliente");
        var petsDoCLiente = PetSpringDataJpa.findByIdCLienteTutor(idCliente);
        log.info("[finaliza] PetInfraRepository - buscaPetsDoCliente");
        return petsDoCLiente;
    }
}
