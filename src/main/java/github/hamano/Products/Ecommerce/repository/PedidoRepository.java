package github.hamano.Products.Ecommerce.repository;

import github.hamano.Products.Ecommerce.models.ItemPedido;
import github.hamano.Products.Ecommerce.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
