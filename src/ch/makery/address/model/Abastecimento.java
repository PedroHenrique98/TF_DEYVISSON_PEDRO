package ch.makery.address.model;
import java.time.LocalDate;
public class Abastecimento {
    private String placaAutomovel;

    public String tipoCombustivel;

    private LocalDate data;

    private double odometroAtual;

    private double litros;

    private double precoLitro;

    private double precoTotal;

    public Abastecimento(String auto, String tipoc, double odometroa, double lit, double precol) {
        if(odometroa<0){
            throw new IllegalArgumentException("Odometro não pode ser negativo!");
        }
        if(lit<=0){
            throw new IllegalArgumentException("Litros abastecidos não podem ser negativo!");
        }
        if(precol<=0){
            throw new IllegalArgumentException("Preco não pode ser negativo, nem de graça!");
        }

        placaAutomovel = auto;
        tipoCombustivel = tipoc;
        odometroAtual = odometroa;
        litros = lit;
        precoLitro = precol;
        precoTotal = litros*precoLitro;
        data = LocalDate.now();
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setOdometroAtual(double odometroAtual) {
        this.odometroAtual = odometroAtual;
    }

    public void setPlacaAutomovel(String placaAutomovel) {
        this.placaAutomovel = placaAutomovel;
    }

    public void setPrecoLitro(double precoLitro) {
        this.precoLitro = precoLitro;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getOdometroAtual() {
        return odometroAtual;
    }

    public double getLitros() {
        return litros;
    }

    public double getPrecoLitro() {
        return precoLitro;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public String getPlacaAutomovel() {
        return placaAutomovel;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    @Override
    public String toString() {
        return "(" + placaAutomovel + ", " + tipoCombustivel + ", " + data.toString() + ", "
                + odometroAtual + ", " + litros + ", " + precoLitro
                + ", " + precoTotal + ")";
    }
}