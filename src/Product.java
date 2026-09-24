public abstract class Product implements Vendavel {
    private String nome;
    private double preco;
    private int quantidade;


    public Product(String nome, double preco, int quantidade, int diasParavencer) throws QuantidadeinvalidaException{
        if (preco < 0 || quantidade < 0) {
            throw new QuantidadeinvalidaException("Preço e quantidade não podem ser negativos. Fornecido: Preço R$ " + preco + ", Qtd: " + quantidade);
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;

    }


    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format("Produto: %s | Preço: R$ %.2f | Estoque: %d un", nome, preco, quantidade);
    }

    @Override
    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada > this.quantidade) {
            throw new ProdutoIndisponivelException("Estoque insuficiente para '" + nome + "'. Solicitado: " + quantidadeDesejada + ", Disponível: " + this.quantidade);

        }
        this.quantidade -= quantidadeDesejada;
    }

    // Sobrecarga (Polimorfismo Estático)
    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            this.preco -= this.preco * (percentual / 100.0);
        }
    }

    public void aplicarDesconto(double percentual, double descontoMaximo) {
        if (percentual > 0 && percentual <= 100) {
            double valorDesconto = this.preco * (percentual / 100.0);
            if (valorDesconto > descontoMaximo) {
                valorDesconto = descontoMaximo;
            }
            this.preco -= valorDesconto;
        }
    }
    // Getters e Setters
    public String getNome() { return nome; }
    public double getPreco() { return preco;}
    public int getQuantidade() { return quantidade;}
    protected void setPreco(double preco) { this.preco = preco;}


}