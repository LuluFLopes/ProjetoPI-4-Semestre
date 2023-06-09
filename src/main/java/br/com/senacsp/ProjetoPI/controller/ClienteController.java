package br.com.senacsp.ProjetoPI.controller;


import br.com.senacsp.ProjetoPI.dto.cliente.ClienteDTO;
import br.com.senacsp.ProjetoPI.dto.usuario.LoginDTO;
import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.model.EnderecoEntrega;
import br.com.senacsp.ProjetoPI.model.EnderecoFaturamento;
import br.com.senacsp.ProjetoPI.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/buscarEnderecoFaturamento/{id}")
    public ResponseEntity<EnderecoFaturamento> buscarEnderecoFaturamento(@PathVariable long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente.getEnderecoFaturamento());
    }

    @GetMapping("/buscarEnderecoEntrega/{id}")
    public ResponseEntity<List<EnderecoEntrega>> buscarEnderecoEntrega(@PathVariable long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente.getEnderecoEntrega());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> listarClientes = clienteService.listar();
        return ResponseEntity.ok(listarClientes);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteDTO dto) {
        clienteService.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar")
    public ResponseEntity<Cliente> alterar(@RequestBody ClienteDTO dto) {
        clienteService.alterar(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody LoginDTO dto) {
        Cliente cliente = clienteService.login(dto.getUsuario(), dto.getSenha());
        return ResponseEntity.ok(cliente);
    }
}
