package br.com.bb.aula1.repository;

import br.com.bb.aula1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteData extends JpaRepository<Cliente, Long> {

}
