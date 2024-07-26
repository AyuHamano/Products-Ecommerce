package github.hamano.Products.Ecommerce.services;

import github.hamano.Products.Ecommerce.models.Produto;
import github.hamano.Products.Ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProdutoPorId(Long id) {
        return produtoRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Produto produto = obterProdutoPorId(id);
        if (produto != null) {
            produto.setNome(produtoAtualizado.getNome());
            produto.setCodigo(produtoAtualizado.getCodigo());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setEstoque(produtoAtualizado.getEstoque());
            produto.setCategoria(produtoAtualizado.getCategoria());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(Math.toIntExact(id));
    }
    public void atualizarEstoque(Long produtoId, int quantidade) {
        Produto produto = produtoRepository.findById(Math.toIntExact(produtoId)).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        if (produto.getEstoque() >= quantidade) {
            produto.setEstoque(produto.getEstoque() - quantidade);
            produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Estoque insuficiente");
        }
    }
}

