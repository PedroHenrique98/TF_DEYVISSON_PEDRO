import java.io.Serializable;

public class Automovel  implements Serializable {

    private String placaVeiculo;

    private String modelo;

    private int ano;

    private String fabricante;

    private int capTanque;

    private double odometro;

    public Automovel(String pv, String m, int a, String f, int ct, double o) {
        if(a < 1769) {
            throw new IllegalArgumentException("Ano do veiculo invalido!");
        }
        if(ct <= 0) {
            throw new IllegalArgumentException("Capacidade do tanque do veiculo invalido!");
        }
        if(o < 0) {
            throw new IllegalArgumentException("Odometro do veiculo invalido!");
        }
        placaVeiculo = pv;
        modelo = m;
        ano = a;
        fabricante = f;
        capTanque = ct;
        odometro = o;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public void setOdometro(double odometro) {
        this.odometro = odometro;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapTanque(int capTanque) {
        this.capTanque = capTanque;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getOdometro() {
        return odometro;
    }

    public int getAno() {
        return ano;
    }

    public int getCapTanque() {
        return capTanque;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String toString() {
        return "(" + placaVeiculo + ", "  + modelo + ", "  + ano + ", " + capTanque +  ", " + odometro + ", " + fabricante + ")";
    }
}
