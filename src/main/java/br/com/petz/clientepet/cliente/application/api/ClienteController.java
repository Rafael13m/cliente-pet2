package br.com.petz.clientepet.cliente.application.api;


import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("Inicia Controler - post");
        ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
        log.info("Finaliza Controler - post");
        return clienteCriado;
    }

    @Override
    public List<ClienteListResponse> buscaClientes() {
        log.info("Inicia Controler - Busca Todos");
        List<ClienteListResponse> cliente = clienteService.buscaClientes();
        log.info("finaliza Controler - Busca Todos");
        return cliente;
    }
}
