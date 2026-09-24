public class ProdutoComum extends Product {

    public ProdutoComum(String nome, double preco, int quantidade, int diasParavencer) throws QuantidadeinvalidaException {
        super(nome, preco, quantidade, diasParavencer);
    }

    @Override
    public double calcularValorTotal() {
        return getPreco() * getQuantidade();
    }
}