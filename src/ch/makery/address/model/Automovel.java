package ch.makery.address.model;

import javafx.beans.property.*;


/**
 * Model class for a Automovel.
 *
 * @author Marco Jakob
 */
public class Automovel {

    private final StringProperty placaVeiculo;

    private final StringProperty modelo;

    private final IntegerProperty ano;

    private final StringProperty fabricante;

    private final IntegerProperty capTanque;

    private final DoubleProperty odometro;


    public Automovel(String pv, String m, int a, String f, int ct, double o) {
        super();
        placaVeiculo = new SimpleStringProperty(pv);
        modelo = new SimpleStringProperty(m);
        ano = new SimpleIntegerProperty(a);
        fabricante = new SimpleStringProperty(f);
        capTanque = new SimpleIntegerProperty(ct);
        odometro = new SimpleDoubleProperty(o);
    }

    public Automovel(){this(null, null, 2018,null, 40, 0.0);}

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo.setValue(placaVeiculo);
    }

    public void setOdometro(double odometro) {
        this.odometro.setValue(odometro);
    }

    public void setAno(int ano) {
        this.ano.setValue(ano);
    }

    public void setModelo(String modelo) {
        this.modelo.setValue(modelo);
    }

    public void setCapTanque(int capTanque) {
        this.capTanque.setValue(capTanque);
    }

    public void setFabricante(String fabricante) {
        this.fabricante.setValue(fabricante);
    }

    public DoubleProperty getOdometroP() {
        return odometro;
    }
    public double getOdometro() {
        return odometro.doubleValue();
    }

    public IntegerProperty getAnoP() {
        return ano;
    }
    public int getAno() {
        return ano.intValue();
    }

    public IntegerProperty getCapTanqueP() {
        return capTanque;
    }
    public int getCapTanque() {
        return capTanque.intValue();
    }

    public StringProperty getFabricanteP() {
        return fabricante;
    }
    public String getFabricante() {
        return fabricante.get();
    }

    public StringProperty getModeloP() {
        return modelo;
    }
    public String getModelo() {
        return modelo.get();
    }

    public StringProperty getPlacaVeiculoP() {
        return placaVeiculo;
    }
    public String getPlacaVeiculo() {
        return placaVeiculo.get();
    }

    public String toString() {
        return "(" + placaVeiculo.get() + ", "  + modelo.get() + ", "  + ano.get() + ", "
                + capTanque.get() +  ", " + odometro.get() + ", " + fabricante.get() + ")";
    }
}