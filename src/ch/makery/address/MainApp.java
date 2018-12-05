package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ch.makery.address.view.AutomovelEditDialogController;
import ch.makery.address.view.AutomovelOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    

    private ObservableList<Automovel> automoveisList = FXCollections.observableArrayList();


    public MainApp() {
        GerenciadorAbastecimento gabast = new GerenciadorAbastecimento();
        GerenciadorAutomovel gauto = new LeituraArquivos().lerArquivoAutomovel();

        /*
        gauto.cadastraAutomovel("ABC1234", "UNO", 2018, "FIAT", 45, 0.0);
        gauto.cadastraAutomovel("ABC4321", "PALIO", 2015, "FIAT", 40, 45000.40);
        gauto.cadastraAutomovel("CBA1234", "SANDERO", 2013, "RENAULT", 55, 135480.90);
        gauto.cadastraAutomovel("CBA4321", "KAPTUR", 2017, "RENAULT", 60, 69815.65);
        gauto.cadastraAutomovel("ACB1234", "GOL", 2016, "VOLKSWAGEN", 35, 8000.0);
        gauto.cadastraAutomovel("ACB4321", "T-CROSS", 2018, "VOLKSWAGEN", 50, 300.84);

        gauto.cadastraAutomovel("QWE1234", "ARGO", 2018, "FIAT", 40, 125.0);
        gauto.cadastraAutomovel("QWE4321", "MOBI", 2015, "FIAT", 34, 48000.40);
        gauto.cadastraAutomovel("EWQ1234", "DUSTER", 2013, "RENAULT", 55, 863880.90);
        gauto.cadastraAutomovel("EWQ4321", "NOVA", 2017, "RENAULT", 10, 1315.65);
        gauto.cadastraAutomovel("WQE1234", "GOL", 2014, "VOLKSWAGEN", 35, 805600.0);
        gauto.cadastraAutomovel("WQE4321", "T-CROSS", 2018, "VOLKSWAGEN", 50, 900.84);

        gauto.cadastraAutomovel("JKL1234", "DOBLO", 2018, "FIAT", 34, 0.0);
        gauto.cadastraAutomovel("JKL4321", "STRADA", 2015, "FIAT", 34, 21000.40);
        gauto.cadastraAutomovel("LJK1234", "DUSTER", 2013, "RENAULT", 55, 135480.90);
        gauto.cadastraAutomovel("KJL1234", "VIRTUS", 2016, "VOLKSWAGEN", 33, 3000.0);

        gauto.cadastraAutomovel("BNM4321", "DUCATO", 2015, "FIAT", 34, 45000.40);
        gauto.cadastraAutomovel("MBN1234", "DUSTER", 2013, "RENAULT", 55, 905480.90);
        gauto.cadastraAutomovel("MBN4321", "NOVA", 2017, "RENAULT", 10, 32815.65);
        gauto.cadastraAutomovel("NMB4321", "GOLF", 2018, "VOLKSWAGEN", 50, 3100.84);
*/

        Automovel a1 = gauto.buscarAutomovel("ABC1234");
        Automovel a2 = gauto.buscarAutomovel("ABC4321");
        //System.out.println(a1);

        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 20, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 10, 4.69);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 10, 3.59);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 12, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 35, 4.69);


        /*
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(0), "Etanol", gauto.getAutomoveis().get(0).getOdometro(), 20, 3.59);
        /*gabast.solicitarAbastecimento(gauto.getAutomoveis().get(7), "Etanol", gauto.getAutomoveis().get(7).getOdometro(), 10, 3.59);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(0), "Etanol", gauto.getAutomoveis().get(0).getOdometro(), 12.4, 3.59);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(4), "Etanol", gauto.getAutomoveis().get(4).getOdometro(), 13.9, 3.59);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(0), "Etanol", gauto.getAutomoveis().get(0).getOdometro(), 2.1, 3.59);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(7), "Etanol", gauto.getAutomoveis().get(7).getOdometro(), 6, 3.59);

        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(1), "GNV", gauto.getAutomoveis().get(1).getOdometro(), 14, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(1), "GNV", gauto.getAutomoveis().get(1).getOdometro(), 6, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(4), "GNV", gauto.getAutomoveis().get(4).getOdometro(), 5.4, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(1), "GNV", gauto.getAutomoveis().get(1).getOdometro(), 4.9, 3.59);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(4), "GNV", gauto.getAutomoveis().get(4).getOdometro(), 2.1, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(5), "GNV", gauto.getAutomoveis().get(5).getOdometro(), 6, 3.59);

        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(1), "Gasolina", gauto.getAutomoveis().get(1).getOdometro(), 14, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(12), "Gasolina", gauto.getAutomoveis().get(12).getOdometro(), 6, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(4), "Gasolina", gauto.getAutomoveis().get(4).getOdometro(), 5.4, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(20), "Gasolina", gauto.getAutomoveis().get(20).getOdometro(), 4.9, 3.59);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(14), "Gasolina", gauto.getAutomoveis().get(14).getOdometro(), 2.1, 4.69);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(21), "Gasolina", gauto.getAutomoveis().get(21).getOdometro(), 6, 3.59);

        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(9), "Etanol", gauto.getAutomoveis().get(9).getOdometro(), 14, 5.14);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(17), "Etanol", gauto.getAutomoveis().get(17).getOdometro(), 6, 5.14);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(17), "Etanol", gauto.getAutomoveis().get(17).getOdometro(), 5.4, 5.14);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(13), "Etanol", gauto.getAutomoveis().get(13).getOdometro(), 4.9, 5.14);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(13), "Etanol", gauto.getAutomoveis().get(13).getOdometro(), 2.1, 5.14);
        gabast.solicitarAbastecimento(gauto.getAutomoveis().get(10), "Etanol", gauto.getAutomoveis().get(10).getOdometro(), 6, 5.14);
*/




        automoveisList = FXCollections.observableList(gauto.getAutomoveis());
        EscritaArquivos escritaArquivos = new EscritaArquivos();
        escritaArquivos.escreveArquivos(gauto, gabast);
    }

    public ObservableList<Automovel> getAutomovelData() {
        return automoveisList;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gerenciador Bolado");

        initRootLayout();

        showAutomovelOverview();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAutomovelOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AutomovelOverview.fxml"));
            AnchorPane automovelOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(automovelOverview);

            // Give the controller access to the main app.
            AutomovelOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showAutomovelEditDialog(Automovel automovel) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AutomovelEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edite seu Automovel");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the automovel into the controller.
            AutomovelEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAutomovel(automovel);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}