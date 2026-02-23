package br.com.petz.clientepet.cliente.infra;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("Inicia Cliente Infra - salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("finaliza Cliente Infra - salva");
        return cliente;
    }

    @Override
    public List<Cliente> buscaClientes() {
        log.info("Inicia Cliente Infra - Busca CLientes");
        List<Cliente> clientes = clienteSpringDataJPARepository.findAll();
        log.info("Finaliza Cliente Infra - Busca CLientes");
        return clientes;
    }

    @Override
    public Cliente buscaClientePorId(UUID idCliente) {
        log.info("Inicia Cliente Infra - Busca CLiente por id");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente).
                orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        log.info("Finaliza Cliente Infra - Busca CLiente por id");
        return cliente;
    }
}
