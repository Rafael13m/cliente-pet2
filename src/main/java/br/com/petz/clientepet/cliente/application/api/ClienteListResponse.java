package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {

    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;

    private ClienteListResponse(Cliente cliente) {
        this.celular = cliente.getCelular();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.idCliente = cliente.getIdCliente();
    }

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteListResponse::new)
                .collect(Collectors.toList());
    }
}
