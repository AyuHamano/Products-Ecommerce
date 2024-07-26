package github.hamano.Products.Ecommerce.services;

import github.hamano.Products.Ecommerce.models.ItemPedido;
import github.hamano.Products.Ecommerce.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido obterItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public ItemPedido atualizarItemPedido(Long id, ItemPedido itemPedidoAtualizado) {
        ItemPedido itemPedido = obterItemPedidoPorId(id);
        if (itemPedido != null) {
            itemPedido.setProduto(itemPedidoAtualizado.getProduto());
            itemPedido.setQuantidade(itemPedidoAtualizado.getQuantidade());
            itemPedido.setPreco(itemPedidoAtualizado.getPreco());
            itemPedido.setPedido(itemPedidoAtualizado.getPedido());
            return itemPedidoRepository.save(itemPedido);
        }
        return null;
    }

    public void deletarItemPedido(Long id) {
        itemPedidoRepository.deleteById(Math.toIntExact(id));
    }
}

