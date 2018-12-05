import java.io.Serializable;
import java.util.*;

public class GerenciadorAbastecimento implements Serializable {

    private List<Abastecimento> abastecimentos;

    public GerenciadorAbastecimento() {
        super();
        abastecimentos = new ArrayList<>();
    }

    public void solicitarAbastecimento(Automovel auto, String tipoc, double odometroa, double lit, double precol) {
        auto.setOdometro(odometroa);
        Abastecimento ab = new Abastecimento(auto.getPlacaVeiculo(), tipoc, odometroa, lit, precol);
        abastecimentos.add(ab);
    }

    public String toString() {
        String str = "[";
        for(Abastecimento abast : abastecimentos) {
            str = str + abast.toString();
            str = str + ", ";
        }
        str = str.substring(0,str.length()-2);
        return str + "]";
    }

    public List<Abastecimento> getAbastecimentosAutomovel(String placa){
        List<Abastecimento> listaAbAutomovel = new ArrayList<>();
        if(abastecimentos.isEmpty()) {
            return null;
        }
        for (Abastecimento abast : abastecimentos) {
            if(abast.getPlacaAutomovel().equals(placa)) {
                listaAbAutomovel.add(abast);
            }
        }
        return listaAbAutomovel;
    }
    public void Printa(){
        System.out.println("Show.");
    }
}