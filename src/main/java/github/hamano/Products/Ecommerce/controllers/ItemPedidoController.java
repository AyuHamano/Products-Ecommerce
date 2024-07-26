package github.hamano.Products.Ecommerce.controllers;

import github.hamano.Products.Ecommerce.models.ItemPedido;
import github.hamano.Products.Ecommerce.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensPedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ItemPedido criarItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.salvarItemPedido(itemPedido);
    }

    @GetMapping
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoService.listarItensPedido();
    }

    @GetMapping("/{id}")
    public ItemPedido obterItemPedidoPorId(@PathVariable Long id) {
        return itemPedidoService.obterItemPedidoPorId(id);
    }

    @PutMapping("/{id}")
    public ItemPedido atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado) {
        return itemPedidoService.atualizarItemPedido(id, itemPedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.deletarItemPedido(id);
    }
}

