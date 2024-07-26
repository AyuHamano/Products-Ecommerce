package github.hamano.Products.Ecommerce.services;

import github.hamano.Products.Ecommerce.models.Pedido;
import github.hamano.Products.Ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    public Pedido salvarPedido(Pedido pedido) {
        pedido.getItens().forEach(item -> {
            produtoService.atualizarEstoque(item.getProduto().getId(), item.getQuantidade());
        });
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = obterPedidoPorId(id);
        if (pedido != null) {
            pedido.setCliente(pedidoAtualizado.getCliente());
            pedido.setData(pedidoAtualizado.getData());
            pedido.setFormaPagamento(pedidoAtualizado.getFormaPagamento());
            pedido.setItens(pedidoAtualizado.getItens());
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

}


