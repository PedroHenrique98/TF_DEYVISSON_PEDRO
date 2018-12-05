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

        /*gauto.cadastraAutomovel("ABC1234", "UNO", 2018, "FIAT", 45, 0.0);
        gauto.cadastraAutomovel("ABC4321", "PALIO", 2015, "FIAT", 40, 45000.40);
        gauto.cadastraAutomovel("CBA1234", "SANDERO", 2013, "RENAULT", 55, 135480.90);
        gauto.cadastraAutomovel("CBA4321", "KAPTUR", 2017, "RENAULT", 60, 69815.65);
        gauto.cadastraAutomovel("ACB1234", "GOL", 2016, "VOLKSWAGEN", 35, 8000.0);
        gauto.cadastraAutomovel("ACB4321", "T-CROSS", 2018, "VOLKSWAGEN", 50, 300.84);
        */
        GerenciadorAutomovel gauto = new LeituraArquivos().lerArquivoAutomovel();

        Automovel a1 = gauto.buscarAutomovel("ABC1234");
        Automovel a2 = gauto.buscarAutomovel("ABC4321");
        //System.out.println(a1);

        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 20, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 10, 4.69);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 10, 3.59);
        gabast.solicitarAbastecimento(a1, "Etanol", a1.getOdometro(), 12, 3.59);
        gabast.solicitarAbastecimento(a2, "Gasolina", a2.getOdometro(), 35, 4.69);

        automoveisList = FXCollections.observableList(gauto.getAutomoveis());
        EscritaArquivos escritaArquivos = new EscritaArquivos();
        escritaArquivos.escreveArquivos(gauto);
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