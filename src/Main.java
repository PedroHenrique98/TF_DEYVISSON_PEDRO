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
import java.util.List;

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

        Path caminhoAutomoveis = Paths.get("ArquivoVeiculos.bin");
        Path caminhoAbastecimentos = Paths.get("ArquivoAbastecimentos.bin");

        System.out.println("Lendo arquivos...");

        try (ObjectInputStream lendo = new ObjectInputStream(Files.newInputStream(caminhoAutomoveis))) {
            gauto = (GerenciadorAutomovel) lendo.readObject();
            System.out.println(gauto);
            System.out.println("Arquivo Serializado lido com sucesso! :)");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Falha ao ler arquivo Serializado! :(");
            e.printStackTrace();
        }








        gauto.cadastraAutomovel("ABC1234", "UNO", 2018, "FIAT", 45, 0.0);
        gauto.cadastraAutomovel("ABC4321", "PALIO", 2015, "FIAT", 40, 45000.40);
        gauto.cadastraAutomovel("CBA1234", "SANDERO", 2013, "RENAULT", 55, 135480.90);
        gauto.cadastraAutomovel("CBA4321", "KAPTUR", 2017, "RENAULT", 60, 69815.65);
        gauto.cadastraAutomovel("ACB1234", "GOL", 2016, "VOLKSWAGEN", 35, 8000.0);
        gauto.cadastraAutomovel("ACB4321", "T-CROSS", 2018, "VOLKSWAGEN", 50, 300.84);

        Automovel a1 = gauto.buscarAutomovel("ABC1234");
        Automovel a2 = gauto.buscarAutomovel("ABC4321");
        //System.out.println(a1);

        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 20, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 10, 4.69);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 10, 3.59);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 12, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 35, 4.69);

        List<Abastecimento> teste = gabast.getAbastecimentosAutomovel("ABC1234");
        System.out.println(teste);

        launch(args);

        System.out.println("Gravando arquivos:");

        try(ObjectOutputStream gravador = new ObjectOutputStream(Files.newOutputStream(caminhoAutomoveis))) {
            gravador.writeObject(gauto);
            System.out.println("...");
            System.out.println("Arquivo Veiculo atualizado com sucesso! :)");
        } catch(IOException e){
            System.out.println("...");
            System.out.println("Falha ao atualizar arquivo Veiculos! :(");
            e.printStackTrace();
        }
        try(ObjectOutputStream gravador = new ObjectOutputStream(Files.newOutputStream(caminhoAbastecimentos))) {
            gravador.writeObject(gabast);
            System.out.println("...");
            System.out.println("Arquivo Abastecimento atualizado com sucesso! :)");
        } catch(IOException e){
            System.out.println("...");
            System.out.println("Falha ao atualizar arquivo Abastecimento! :(");
            e.printStackTrace();
        }

    }
}