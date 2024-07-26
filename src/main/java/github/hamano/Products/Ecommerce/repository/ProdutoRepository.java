package github.hamano.Products.Ecommerce.repository;

import github.hamano.Products.Ecommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
