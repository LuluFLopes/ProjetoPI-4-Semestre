package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.pedido.AlterarStatusDTO;
import br.com.senacsp.ProjetoPI.dto.pedido.PedidoDTO;
import br.com.senacsp.ProjetoPI.form.pedido.PedidoForm;
import br.com.senacsp.ProjetoPI.model.Pedido;
import br.com.senacsp.ProjetoPI.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PedidoForm>> listar() {
        List<PedidoForm> listarPedidos = pedidoService.listar();
        return ResponseEntity.ok(listarPedidos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable long id) {
        Pedido pedido = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pedido> salvar(@RequestBody PedidoDTO dto) {
        Pedido pedido = pedidoService.salvar(dto);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("/alterar")
    public ResponseEntity<Pedido> alterar(@RequestBody PedidoDTO dto) {
        pedidoService.alterar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/ajustarStatus")
    public ResponseEntity<Pedido> ajustarStatus(@RequestBody AlterarStatusDTO dto) {
        pedidoService.ajustarStatus(dto);
        return ResponseEntity.ok().build();
    }

}
