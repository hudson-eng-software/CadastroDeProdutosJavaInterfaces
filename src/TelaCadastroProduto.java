import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroProduto extends JFrame {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnSalvar;
    private JButton btnListar;

    private ProdutoService produtoService;

    public TelaCadastroProduto(ProdutoService produtoService) {
        this.produtoService = produtoService;

        setTitle("Cadastro de Produtos");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblPreco = new JLabel("Preço:");
        JLabel lblQuantidade = new JLabel("Quantidade:");

        txtNome = new JTextField(15);
        txtPreco = new JTextField(10);
        txtQuantidade = new JTextField(5);

        btnSalvar = new JButton("Salvar");
        btnListar = new JButton("Listar Produtos");

        // Adiciona na tela
        add(lblNome); add(txtNome);
        add(lblPreco); add(txtPreco);
        add(lblQuantidade); add(txtQuantidade);
        add(btnSalvar); add(btnListar);

        // Ações
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    double preco = Double.parseDouble(txtPreco.getText());
                    int quantidade = Integer.parseInt(txtQuantidade.getText());

                    Produto produto = new Produto(nome, preco, quantidade);
                    produtoService.salvarProduto(produto);

                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                    // limpar campos
                    txtNome.setText("");
                    txtPreco.setText("");
                    txtQuantidade.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: verifique os dados informados.");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Produto> lista = produtoService.listarProdutos();
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
                } else {
                    StringBuilder sb = new StringBuilder("Produtos cadastrados:\n");
                    for (Produto p : lista) {
                        sb.append(p.getNome())
                                .append(" - R$ ").append(p.getPreco())
                                .append(" - qtd: ").append(p.getQuantidade())
                                .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProdutoService produtoService = new ProdutoServiceImpl();
            TelaCadastroProduto tela = new TelaCadastroProduto(produtoService);
            tela.setVisible(true);
        });
    }
}
