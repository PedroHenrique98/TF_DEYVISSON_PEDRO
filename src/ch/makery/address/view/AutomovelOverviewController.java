package ch.makery.address.view;

import ch.makery.address.model.Automovel;
import ch.makery.address.model.EscritaArquivos;
import ch.makery.address.model.GerenciadorAbastecimento;
import ch.makery.address.model.GerenciadorAutomovel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;

public class AutomovelOverviewController {
    @FXML
    private TableView<Automovel> automovelTable;
    @FXML
    private TableColumn<Automovel, String> placaColumn;

    @FXML
    private Label placaLabel;
    @FXML
    private Label modeloLabel;
    @FXML
    private Label anoLabel;
    @FXML
    private Label fabricanteLabel;
    @FXML
    private Label capacidadeLabel;
    @FXML
    private Label odometroLabel;

    // Reference to the main application.
    private MainApp mainApp;

    public AutomovelOverviewController() {
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        placaColumn.setCellValueFactory(cellData -> cellData.getValue().getPlacaVeiculoP());
        
        // Clear person details.
        showAutomovelDetails(null);

        // Listen for selection changes and show the person details when changed.
        automovelTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAutomovelDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        automovelTable.setItems(mainApp.getAutomovelData());
    }

    private void showAutomovelDetails(Automovel automovel) {
        if (automovel != null) {
            // Fill the labels with info from the automovel object.
            placaLabel.setText(automovel.getPlacaVeiculo());
            modeloLabel.setText(automovel.getModelo());
            anoLabel.setText(String.valueOf(automovel.getAno()));
            fabricanteLabel.setText(automovel.getFabricante());
            capacidadeLabel.setText(String.valueOf(automovel.getCapTanque()));
            odometroLabel.setText(String.valueOf(automovel.getOdometro()));
        } else {
            // Automovel is null, remove all the text.
            placaLabel.setText("");
            modeloLabel.setText("");
            anoLabel.setText("");
            fabricanteLabel.setText("");
            capacidadeLabel.setText("");
            odometroLabel.setText("");
        }
    }

    @FXML
    private void handleDeleteAutomovel() {
        int selectedIndex = automovelTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            automovelTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sem selecao");
            alert.setHeaderText("Automovel nao selecionado");
            alert.setContentText("Por favor, selecione um automovel na tabela.");
            
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewAutomovel() {
        Automovel tempAutomovel = new Automovel();
        boolean okClicked = mainApp.showAutomovelEditDialog(tempAutomovel);
        if (okClicked) {
            mainApp.getAutomovelData().add(tempAutomovel);
        }
    }

    @FXML
    private void handleEditAutomovel() {
        Automovel selectedAutomovel = automovelTable.getSelectionModel().getSelectedItem();
        if (selectedAutomovel != null) {
            boolean okClicked = mainApp.showAutomovelEditDialog(selectedAutomovel);
            if (okClicked) {
                showAutomovelDetails(selectedAutomovel);
            }

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sem selecao");
            alert.setHeaderText("Nenhum automovel Selecionado");
            alert.setContentText("Por favor, Selecione um automovel.");
            
            alert.showAndWait();
        }
    }
}