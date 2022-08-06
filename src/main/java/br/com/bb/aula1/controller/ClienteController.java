package br.com.bb.aula1.controller;

import br.com.bb.aula1.model.Cliente;
import br.com.bb.aula1.repository.IClienteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClienteController {
//    @Autowired
    private IClienteData baseClientes;

    public ClienteController(IClienteData baseClientes) {
        this.baseClientes = baseClientes;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        baseClientes.findAll().forEach(clientes::add);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteData = baseClientes.findById(id);

        if(clienteData.isPresent()) {
            Cliente clienteAux = clienteData.get();
            clienteAux.setVAT(cliente.getVAT());
            clienteAux.setName(cliente.getName());
            clienteAux.setAge(cliente.getAge());
            clienteAux.setEmail(cliente.getEmail());

            return new ResponseEntity<>(baseClientes.save(clienteAux), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody Cliente cliente) {
        try {
            Cliente clienteAux = baseClientes.save(new Cliente(cliente.getName(), cliente.getAge(), cliente.getVAT(), cliente.getEmail()));
            return new ResponseEntity<>(clienteAux, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> apagarCliente(@PathVariable("id") long id) {
        try {
            baseClientes.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
