import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setTitle("Abastecimento - O negócio");
        primaryStage.setScene(new Scene(root, 600, 468));
        primaryStage.show();
    }

    public static void main(String[] args) {
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
        GerenciadorAutomovel gauto = new LeituraArquivos().lerArquivoAutomovel();
        GerenciadorAbastecimento gabast = new LeituraArquivos().lerArquivoAbastecimentos(gauto);

        launch(args);

    }
}