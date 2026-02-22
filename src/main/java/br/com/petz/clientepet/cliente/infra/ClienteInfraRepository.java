package br.com.petz.clientepet.cliente.infra;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
