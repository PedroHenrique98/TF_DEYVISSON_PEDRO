import java.time.*;

public class Abastecimento {
    private String placaAutomovel;

    private String tipoCombustivel;

    private LocalDate data;

    private double odometroAtual;

    private double litros;

    private double precoLitro;

    private double precoTotal;

    public Abastecimento(String auto, String tipoc, double odometroa, double lit, double precol) {
        placaAutomovel = auto;
        tipoCombustivel = tipoc;
        odometroAtual = odometroa;
        litros = lit;
        precoLitro = precol;
        precoTotal = litros*precoLitro;
        data = LocalDate.now();
    }

    @Override
    public String toString() {
        return "\nCodigo Automóvel: " + placaAutomovel + "\nTipo de Combustível: " + tipoCombustivel +"\nData do Abastecimento: " + data.toString() + "\nOdometro Atual"
                + odometroAtual + "\nLitros Abastecidos: " + litros + "\nPreço por litro: " + precoLitro
                + "\nPreço Total: " + precoTotal;
    }
}