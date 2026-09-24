public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque =  new Estoque();

       System.out.println("=== SISTEMA DE CONTROLE DE ESTOQUE ===");

        // 1. Teste de Exceção

        System.out.println("[TESTE 1] Tentando cadastrar produto com quantidade negativa: ");
        try{
            Product produtoInvalido = new ProdutoComum("Cadeira Ergonômica", 450.0, -5, 10);
            estoque.adicionarProduto(produtoInvalido);
        } catch (QuantidadeinvalidaException e) {
            System.out.println(" Exceção capturada: " + e.getMessage());
        } catch (EstoqueException e) {
            System.out.println(" Exceção Genérica: " + e.getMessage());
        }

        // 2. Cadastro de Produtos válidos
        System.out.println("\n[TESTE 2] Cadastrando produtos válidos: ");
        try {
            ProdutoComum pComum1 = new ProdutoComum("Teclado Mecânico", 250.0, 10, 20);
            ProdutoComum pComum2 = new ProdutoComum("Mouse Gamer", 120.00, 15, 20);

            ProdutoPerecivel pPerecivel1 = new ProdutoPerecivel("Iogurte Natural", 6.00, 20, 10);
            ProdutoPerecivel pPerecivel2 = new ProdutoPerecivel("Leite Integral", 5.00, 30, 2);

            estoque.adicionarProduto(pComum1);
            estoque.adicionarProduto(pComum2);
            estoque.adicionarProduto(pPerecivel1);
            estoque.adicionarProduto(pPerecivel2);

            System.out.println("Produtos cadastrados com sucesso!");
            
        } catch (QuantidadeinvalidaException e) {
            System.out.println(" Erro ao cadastrar produtos: " + e.getMessage());
        }

        // Exibe lista inicial e valor total do estoque
        estoque.listarProdutos();
        System.out.printf("\n Valor Total do Estoque: R$ %.2f\n", estoque.calcularValorTotalEstoque());

        // 3. Teste de Venda Bem-Sucedida
        System.out.println("\n[TESTE 3] Realizando venda válida (5 unidades do produto [0]):");
        try {
            estoque.venderProduto(0, 5);
            System.out.println(" Venda realizada com sucesso!");
        } catch (ProdutoIndisponivelException e) {
            System.out.println(" Erro na venda: " + e.getMessage());
        }

        estoque.listarProdutos();

        // 4. Teste de Exceção: Venda com quantidade indisponível
        System.out.println("\n[TESTE 4] Tentando vender mais do que o estoque disponível do produto [0] (tentando 10, disponível 5):");
        try {
            estoque.venderProduto(0, 10);
        } catch (ProdutoIndisponivelException e) {
            System.out.println(" Exceção Capturada: " + e.getMessage());
        } catch (EstoqueException e) {
            System.out.println(" Exceção Genérica: " + e.getMessage());
        }

        // Valor Final do Estoque
        System.out.printf("\n Valor Total do Estoque Atualizado: R$ %.2f\n", estoque.calcularValorTotalEstoque());
    }
}
