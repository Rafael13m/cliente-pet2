package br.com.petz.clientepet.pet.domain;


import br.com.petz.clientepet.pet.application.api.PetRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID idPet;
    @NotNull
    @Column(name = "idClienteTutor", nullable = false)
    private UUID idCLienteTutor;
    @NotBlank
    private String nomePet;
    @Enumerated(EnumType.STRING)
    private Porte porte;
    @Enumerated(EnumType.STRING)
    private TipoPet tipo;
    private String microchip;
    private String raca;
    @Enumerated(EnumType.STRING)
    private SexoPet sexoPet;
    private String pelagemCor;
    @NotNull
    private LocalDate dataNascimento;
    private String rga;
    private Integer peso;

    private LocalDateTime dataHotaDoCadastro;
    private LocalDateTime dataHotaDaUltimaAlteracao;

    public Pet(UUID idCliente, PetRequest petRequest) {
        this.idCLienteTutor = idCliente;
        this.nomePet = petRequest.getNomePet();
        this.porte = petRequest.getPorte();
        this.tipo = petRequest.getTipo();
        this.microchip = petRequest.getMicrochip();
        this.raca = petRequest.getRaca();
        this.sexoPet = petRequest.getSexoPet();
        this.pelagemCor = petRequest.getPelagemCor();
        this.dataNascimento = petRequest.getDataNascimento();
        this.rga = petRequest.getRga();
        this.peso = petRequest.getPeso();
        this.dataHotaDoCadastro = LocalDateTime.now();
    }
}
