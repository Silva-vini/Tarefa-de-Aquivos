import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class ConverterParaXML {

    public void gerarArquivo(List<Produtos> produtos) {

        try
            (BufferedWriter writer = new BufferedWriter(new FileWriter("produtos.xml"))) {

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.newLine();

            writer.write("<produtos>");
            writer.newLine();

            for (Produtos produto : produtos) {

                writer.write("    <produto>");
                writer.newLine();

                writer.write("        <nome>" + produto.getNome() + "</nome>");
                writer.newLine();

                writer.write("        <quantidade>" + produto.getQuantidade() + "</quantidade>");
                writer.newLine();

                writer.write("        <preco>" + produto.getPreco() + "</preco>");
                writer.newLine();

                writer.write("    </produto>");
                writer.newLine();
            }

            writer.write("</produtos>");
            System.out.println("Arquivo XML gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
