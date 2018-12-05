package ch.makery.address.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscritaArquivos {

    public EscritaArquivos(){}

    public void escreveArquivos(GerenciadorAutomovel gauto){
        System.out.println("Gravando arquivos:");

        Path caminhoAutomoveis = Paths.get("ArquivoAutomoveis.txt");
        Path caminhoAbastecimentos = Paths.get("ArquivoAbastecimentos.txt");

        try(ObjectOutputStream gravador1 = new ObjectOutputStream(Files.newOutputStream(caminhoAutomoveis))) {
            gravador1.writeUTF(gauto.toString());
            System.out.println("...");
            System.out.println("Arquivo de Automoveis atualizado com sucesso! :)");
        } catch(IOException e){
            System.out.println("...");
            System.out.println("Falha ao atualizar arquivo de Automoveis! :(");
            e.printStackTrace();
        }
        /*
        try(ObjectOutputStream gravador2 = new ObjectOutputStream(Files.newOutputStream(caminhoAbastecimentos))) {
            gravador2.writeUTF(gabast.toString());
            System.out.println("...");
            System.out.println("Arquivo de Abastecimento atualizado com sucesso! :)");
        } catch(IOException e){
            System.out.println("...");
            System.out.println("Falha ao atualizar arquivo de Abastecimento! :(");
            e.printStackTrace();
        }
        */
    }
}
