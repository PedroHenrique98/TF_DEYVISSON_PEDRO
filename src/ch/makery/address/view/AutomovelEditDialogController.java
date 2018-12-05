package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Automovel;

public class AutomovelEditDialogController {

    @FXML
    private TextField placaField;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField anoField;
    @FXML
    private TextField fabricanteField;
    @FXML
    private TextField capacidadeField;
    @FXML
    private TextField odometroField;


    private Stage dialogStage;
    private Automovel automovel;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;

        placaField.setText(automovel.getPlacaVeiculo());
        modeloField.setText(automovel.getModelo());
        anoField.setText(String.valueOf(automovel.getAno()));
        fabricanteField.setText(automovel.getFabricante());
        capacidadeField.setText(String.valueOf(automovel.getCapTanque()));
        odometroField.setText(String.valueOf(automovel.getOdometro()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            automovel.setPlacaVeiculo(placaField.getText());
            automovel.setModelo(modeloField.getText());
            automovel.setAno(Integer.parseInt(anoField.getText()));
            automovel.setFabricante(fabricanteField.getText());
            automovel.setCapTanque(Integer.parseInt(capacidadeField.getText()));
            automovel.setOdometro(Double.parseDouble(odometroField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (placaField.getText() == null || placaField.getText().length() == 0) {
            errorMessage += "placa invalida!\n";
        }
        if (modeloField.getText() == null || modeloField.getText().length() == 0) {
            errorMessage += "modelo invalido!\n";
        }
        if (anoField.getText() == null || anoField.getText().length() == 0) {
            errorMessage += "ano invalido!\n";
        } else {
            try {
                Integer.parseInt(anoField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Ano invalido!\n";
            }
        }

        if (fabricanteField.getText() == null || fabricanteField.getText().length() == 0) {
            errorMessage += "fabricante invalido!\n";
        }

        if (capacidadeField.getText() == null || capacidadeField.getText().length() == 0) {
            errorMessage += "Capacidade do Tanque invalida!\n";
        } else {
            try {
                Integer.parseInt(capacidadeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Capacidade Invalida, tente um inteiro!\n";
            }
        }

        if (odometroField.getText() == null || odometroField.getText().length() == 0) {
            errorMessage += "Odometro Invalido!\n";
        } else {
            try {
                Double.parseDouble(odometroField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Odometro Invalido, tente um double!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos Invalidos!");
            alert.setHeaderText("Gentileza, corrigir erros dos campos");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
            }
        }
    }
