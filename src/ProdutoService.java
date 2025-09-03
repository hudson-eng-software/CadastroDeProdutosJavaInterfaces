import java.util.List;

public interface ProdutoService {
    void salvarProduto(Produto produto);
    List<Produto> listarProdutos();
}
