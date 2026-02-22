package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("inicia service - cria cliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("finaliza service - cria cliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    @Override
    public List<ClienteListResponse> buscaClientes() {
        log.info("inicia service - busca Clientes");
        List<Cliente> clientes = clienteRepository.buscaClientes();
        log.info("finaliza service - busca Clientes");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("inicia service - busca Cliente por id");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        log.info("finaliza service - busca Cliente por id");
        return new ClienteDetalhadoResponse(cliente);
    }
}
