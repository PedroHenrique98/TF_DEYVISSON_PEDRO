import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeituraArquivos {

    public LeituraArquivos(){};

    public GerenciadorAutomovel lerArquivoAutomovel() {
        GerenciadorAutomovel gauto = new GerenciadorAutomovel();
        Path caminhoAutomoveis = Paths.get("ArquivoAutomoveis.txt");
        Path caminhoAbastecimentos = Paths.get("ArquivoAbastecimentos.txt");

        System.out.println("Lendo arquivos...");

        try (
                ObjectInputStream lendo1 = new ObjectInputStream(Files.newInputStream(caminhoAutomoveis))) {
            String tudo = lendo1.readUTF();
            tudo = tudo.substring(1, tudo.length() - 2);
            tudo = tudo.replaceAll("\\(", "");
            tudo = tudo.replaceAll(", ", " ");
            tudo = tudo.replaceAll("\\); ", " \n");
            String[] quebra = tudo.split(" ");
            for (int i = 0; i < quebra.length; i = i + 6) {
                String placa = quebra[i];
                if (i > 0) {
                    placa = placa.substring(1, placa.length());
                }
                String mod = quebra[i + 1];
                int ano = Integer.parseInt(quebra[i + 2]);
                String fab = quebra[i + 5];
                int cap = Integer.parseInt(quebra[i + 3]);
                double odo = Double.parseDouble(quebra[i + 4]);
                gauto.cadastraAutomovel(placa, mod, ano, fab, cap, odo);
            }
            System.out.println("Arquivo de Automoveis lido com sucesso! :)");
        } catch (
                IOException e) {
            System.out.println("Falha ao ler arquivo de Automoveis! :(");
            e.printStackTrace();
        }
        return gauto;
    }

    public GerenciadorAbastecimento lerArquivoAbastecimentos(GerenciadorAutomovel gauto){
        GerenciadorAbastecimento gabast = new GerenciadorAbastecimento();

        Path caminhoAutomoveis = Paths.get("ArquivoAutomoveis.txt");
        Path caminhoAbastecimentos = Paths.get("ArquivoAbastecimentos.txt");

        try (ObjectInputStream lendo2 = new ObjectInputStream(Files.newInputStream(caminhoAbastecimentos))) {
            String tudo = lendo2.readUTF();
            tudo = tudo.substring(1, tudo.length() - 2);
            tudo = tudo.replaceAll("\\(", "");
            tudo = tudo.replaceAll(", ", " ");
            tudo = tudo.replaceAll("\\); ", " \n");
            String[] quebra1 = tudo.split(" ");
            for (int i = 0; i < quebra1.length; i = i + 7) {
                String pla = quebra1[i];
                if (i > 0) {
                    pla = pla.substring(1, pla.length());
                }
                String tipo = quebra1[i + 1];
                double odoa = Double.parseDouble(quebra1[i + 3]);
                double lit = Double.parseDouble(quebra1[i + 4]);
                double pl = Double.parseDouble(quebra1[i + 5]);
                gabast.solicitarAbastecimento(gauto.buscarAutomovel(pla), tipo, odoa, lit, pl);
            }
            System.out.println("Arquivo de Abastecimento lido com sucesso! :)");
        } catch (IOException e) {
            System.out.println("Falha ao ler arquivo de Abastecimento! :(");
            e.printStackTrace();
        }
        return gabast;
    }
}
