package br.com.petz.clientepet.cliente.application.api;


import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("Inicia Controler - Busca por Id");
        ClienteDetalhadoResponse cliente = clienteService.buscaClientePorId(idCliente);
        log.info("Finaliza Controler - Busca por Id");
        return cliente;
    }

    @Override
    public void deletaCliente(UUID idCliente) {
        log.info("Inicia Controler - Deleta Cliente");
        clienteService.deletaCliente(idCliente);
        log.info("Finaliza Controler - Deleta Cliente");
    }

    @Override
    public void AlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("Inicia Controler - Altera Cliente");
        clienteService.alteraCliente(idCliente, clienteAlteracaoRequest);
        log.info("Finaliza Controler - Altera Cliente");
    }
}
