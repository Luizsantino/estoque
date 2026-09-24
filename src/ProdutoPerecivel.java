public class ProdutoPerecivel extends Product {
    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParavencer) throws QuantidadeinvalidaException {

        super(nome, preco, quantidade, diasParavencer);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double total = getPreco() * getQuantidade();
        if (diasParaVencer <= 3) {
            total *= 0.80; // Aplicando 20% de desconto automático
        }
        return total;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + String.format(" | Dias para vencer: %d", diasParaVencer);
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }
}