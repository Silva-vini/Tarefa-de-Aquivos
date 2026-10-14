import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Caixa {

    public static void main(String[] args)throws Exception{

        Scanner scanner = new Scanner(System.in);

        Estoque estoque = new Estoque();
        int operacao;

        do {
            System.out.println("Escolha uma opção abaixo\n 1: Adicinar Produto\n 2: Buscar Produto\n 3: Listar todos os produtos\n 4: Gerar XML\n Qualquer outro número: Sair");
            operacao = scanner.nextInt();
            scanner.nextLine();


            if(operacao == 1){
                System.out.print("Nome do produto:");
                String nome = scanner.nextLine();

                System.out.print("Quantidade em estoque:");
                int quantida = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Valor do produto:");
                double preco = scanner.nextDouble();

                estoque.adicionar(new Produtos(nome, quantida, preco));
            } else if (operacao == 2) {

                System.out.print("Digite o Nome do produto para buscarmos:");
                Produtos produtobuscado = estoque.buscarProduto(scanner.nextLine());

                if (Objects.nonNull(produtobuscado)){
                    System.out.println("Dados do produto buscado: " + produtobuscado);

                }else {
                    System.out.println("Produto não encontrado no estoque!");
                }

            } else if (operacao == 3) {

                List<Produtos> lista = estoque.listarProdutos();
                for (Produtos p : lista){
                    System.out.println(p);
                }

            } else if (operacao == 4) {
                List<Produtos> produtos = estoque.listarProdutos();

                ConverterParaXML converter = new ConverterParaXML();

                converter.gerarArquivo(produtos);
            }

        }while(operacao >= 1 && operacao <=4);

        System.out.println("Volte logo!");


    }
}
