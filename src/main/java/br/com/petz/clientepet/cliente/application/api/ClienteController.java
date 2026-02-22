package br.com.petz.clientepet.cliente.application.api;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ClienteController implements ClienteAPI {
    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("Inicia Controler - post");

        log.info("Finaliza Controler - post");
        return null;
    }
}
