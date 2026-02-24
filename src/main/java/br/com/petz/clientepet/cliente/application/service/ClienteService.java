package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;
import br.com.petz.clientepet.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaClientes();

    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);

    void deletaCliente(UUID idCliente);

    void alteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
}
