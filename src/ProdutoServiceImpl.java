import java.util.ArrayList;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtos;
    }
}

