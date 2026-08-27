package br.com.ggfv.backend.repository;

import br.com.ggfv.backend.entity.Cliente;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface ClienteRepository extends Repository<Cliente, Long> {


    @Transactional(readOnly = true)
    Optional<Cliente> findByCnpj(String cnpj);


    @Transactional
    Cliente save(Cliente cliente);

}