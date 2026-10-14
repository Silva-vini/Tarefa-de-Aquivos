import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    public void adicionar (Produtos produtos) throws IOException{

        BufferedWriter writer = null;

        try{
            writer = new BufferedWriter(new FileWriter(Arquivo.CAMINHO_ARQUIVO, true));
            writer.write(produtos.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    public Produtos buscarProduto(String nome) throws IOException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(Arquivo.CAMINHO_ARQUIVO));
            String linha = reader.readLine();

            while(linha != null){

                if(linha.substring(0, linha.indexOf("|")).equals(nome)){
                    return converterObjeto(linha);
                }
                linha = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return null;
    }

    private Produtos converterObjeto(String linha) throws Exception{

        String[] atributo = linha.split("\\|");

        String nome = atributo[0];
        int quantidade = Integer.parseInt(atributo[1]);
        double preco = Double.parseDouble(atributo[2]);

        Produtos produtos = new Produtos(nome,quantidade, preco);

        return produtos;
    }

    public List<Produtos> listarProdutos()throws Exception{

        BufferedReader reader = null;
        List<Produtos> produtos = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(Arquivo.CAMINHO_ARQUIVO));
            String linha = reader.readLine();

            while(linha != null){

                produtos.add(converterObjeto(linha));
                linha = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return produtos;
    }
}
