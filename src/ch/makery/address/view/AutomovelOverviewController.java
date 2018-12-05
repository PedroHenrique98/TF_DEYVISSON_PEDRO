package ch.makery.address.view;

import ch.makery.address.model.Automovel;
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

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public AutomovelOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
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

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        automovelTable.setItems(mainApp.getAutomovelData());
    }
    
    /**
     * Fills all text fields to show details about the automovel.
     * If the specified automovel is null, all text fields are cleared.
     * 
     * @param automovel the automovel or null
     */
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
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteAutomovel() {
        int selectedIndex = automovelTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            automovelTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Automovel Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewAutomovel() {
        Automovel tempAutomovel = new Automovel();
        boolean okClicked = mainApp.showAutomovelEditDialog(tempAutomovel);
        if (okClicked) {
            mainApp.getAutomovelData().add(tempAutomovel);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditAutomovel() {
        Automovel selectedAutomovel = automovelTable.getSelectionModel().getSelectedItem();
        if (selectedAutomovel != null) {
            boolean okClicked = mainApp.showAutomovelEditDialog(selectedAutomovel);
            if (okClicked) {
                showAutomovelDetails(selectedAutomovel);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Automovel Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
}