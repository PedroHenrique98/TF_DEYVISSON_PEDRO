import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root,300,250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        GerenciadorAutomovel gauto = new GerenciadorAutomovel();

        GerenciadorAbastecimento gabast = new GerenciadorAbastecimento();

        Path caminhoAutomoveis = Paths.get("ArquivoAutomoveis.txt");
        Path caminhoAbastecimentos = Paths.get("ArquivoAbastecimentos.txt");

        System.out.println("Lendo arquivos...");

        try (ObjectInputStream lendo1 = new ObjectInputStream(Files.newInputStream(caminhoAutomoveis))) {
            String tudo = lendo1.readUTF();
            tudo = tudo.substring(1,tudo.length()-2);
            tudo = tudo.replaceAll("\\(", "");
            tudo = tudo.replaceAll(", ", " ");
            tudo = tudo.replaceAll("\\); ", " \n");
            String[] quebra = tudo.split(" ");
            for(int i = 0; i < quebra.length; i=i+6) {
                String placa = quebra[i];
                if(i>0) {
                    placa = placa.substring(1, placa.length());
                }
                String mod = quebra[i+1];
                int ano = Integer.parseInt(quebra[i+2]);
                String fab = quebra[i+5];
                int cap = Integer.parseInt(quebra[i+3]);
                double odo = Double.parseDouble(quebra[i+4]);
                gauto.cadastraAutomovel(placa, mod, ano, fab, cap, odo);
            }
            System.out.println("Arquivo de Automoveis lido com sucesso! :)");
        } catch (IOException e) {
            System.out.println("Falha ao ler arquivo de Automoveis! :(");
            e.printStackTrace();
        }

        try (ObjectInputStream lendo2 = new ObjectInputStream(Files.newInputStream(caminhoAbastecimentos))) {
            String tudo = lendo2.readUTF();
            tudo = tudo.substring(1,tudo.length()-2);
            tudo = tudo.replaceAll("\\(", "");
            tudo = tudo.replaceAll(", ", " ");
            tudo = tudo.replaceAll("\\); ", " \n");
            String[] quebra1 = tudo.split(" ");
            for(int i = 0; i < quebra1.length; i=i+7) {
                String pla = quebra1[i];
                if(i>0) {
                    pla = pla.substring(1, pla.length());
                }
                String tipo = quebra1[i+1];
                double odoa = Double.parseDouble(quebra1[i+3]);
                double lit = Double.parseDouble(quebra1[i+4]);
                double pl = Double.parseDouble(quebra1[i+5]);
                gabast.solicitarAbastecimento(gauto.buscarAutomovel(pla), tipo, odoa, lit, pl);
            }
            System.out.println("Arquivo de Abastecimento lido com sucesso! :)");
        } catch (IOException e) {
            System.out.println("Falha ao ler arquivo de Abastecimento! :(");
            e.printStackTrace();
        }


/*
        gauto.cadastraAutomovel("ABC1234", "UNO", 2018, "FIAT", 45, 0.0);
        gauto.cadastraAutomovel("ABC4321", "PALIO", 2015, "FIAT", 40, 45000.40);
        gauto.cadastraAutomovel("CBA1234", "SANDERO", 2013, "RENAULT", 55, 135480.90);
        gauto.cadastraAutomovel("CBA4321", "KAPTUR", 2017, "RENAULT", 60, 69815.65);
        gauto.cadastraAutomovel("ACB1234", "GOL", 2016, "VOLKSWAGEN", 35, 8000.0);
        gauto.cadastraAutomovel("ACB4321", "T-CROSS", 2018, "VOLKSWAGEN", 50, 300.84);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 20, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 10, 4.69);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 10, 3.59);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 12, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 35, 4.69);
*/
        launch(args);

        System.out.println("Gravando arquivos:");

        try(ObjectOutputStream gravador1 = new ObjectOutputStream(Files.newOutputStream(caminhoAutomoveis))) {
            gravador1.writeUTF(gauto.toString());
            System.out.println("...");
            System.out.println("Arquivo de Automoveis atualizado com sucesso! :)");
        } catch(IOException e){
            System.out.println("...");
            System.out.println("Falha ao atualizar arquivo de Automoveis! :(");
            e.printStackTrace();
        }
        try(ObjectOutputStream gravador2 = new ObjectOutputStream(Files.newOutputStream(caminhoAbastecimentos))) {
            gravador2.writeUTF(gabast.toString());
            System.out.println("...");
            System.out.println("Arquivo de Abastecimento atualizado com sucesso! :)");
        } catch(IOException e){
            System.out.println("...");
            System.out.println("Falha ao atualizar arquivo de Abastecimento! :(");
            e.printStackTrace();
        }

    }
}