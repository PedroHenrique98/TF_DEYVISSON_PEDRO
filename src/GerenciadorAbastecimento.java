import java.util.*;

public class GerenciadorAbastecimento {

    private List<Abastecimento> abastecimentos;

    public GerenciadorAbastecimento() {
        abastecimentos = new ArrayList<>();
    }

    public void solicitarAbastecimento(Automovel auto, String tipoc, double odometroa, double lit, double precol) {
        Abastecimento ab = new Abastecimento(auto.getPlacaVeiculo(), tipoc, odometroa, lit, precol);
        abastecimentos.add(ab);
    }

    public String toString() {
        String str = "[";
        for(Abastecimento abast: abastecimentos) {
            str = str + abast.toString();
            str = str + ", ";
        }
        str = str.substring(0,str.length()-2);
        return str + "]";
    }

}