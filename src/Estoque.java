import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Product> produtos;
    
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Product p) {
        produtos.add(p);
    }

    public void venderProduto(int indice, int quantidade) throws ProdutoIndisponivelException {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.get(indice).vender(quantidade);
        } else {
            throw new IndexOutOfBoundsException("Índice de produto inválido no estoque.");
        }
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        for (Product p : produtos) {
            
            valorTotal += p.calcularValorTotal();
        }
        return valorTotal;
    }

    public void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS NO ESTOQUE ---");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("[" + i + "] " + produtos.get(i).getDescricao() + " | Valor em Estoque: R$ " + String.format("%.2f", produtos.get(i).calcularValorTotal()));
        }
    }
}