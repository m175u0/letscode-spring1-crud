package br.com.bb.aula1.controller;

import br.com.bb.aula1.model.Cliente;
import br.com.bb.aula1.repository.IClienteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteData baseClientes;

    @GetMapping("/client/list")
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        baseClientes.findAll().forEach(clientes::add);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<HttpStatus> criarNovoCliente() {


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
