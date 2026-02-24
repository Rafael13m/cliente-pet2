package br.com.petz.clientepet.pet.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PetResponse criaPet(@PathVariable UUID idCliente,
                        @Valid @RequestBody PetRequest petRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PetClienteListResponse> buscaPetsDoCliente(@PathVariable UUID idCliente);

    @GetMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.OK)
    PetDetalhadoResponse buscaPetPorId(@PathVariable UUID idCliente, UUID idPet);
//
//    @DeleteMapping(value = "/{idCliente}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    void deletaCliente(@PathVariable UUID idCliente);
//
//    @PatchMapping(value = "/{idCliente}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    void AlteraCliente(@PathVariable UUID idCliente ,
//                       @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest);

}
