import java.io.Serializable;
import java.util.*;

public class GerenciadorAutomovel implements Serializable {

    private List<Automovel> automoveis;

    public GerenciadorAutomovel(){
        super();
        automoveis = new ArrayList<>();
        automoveis.clear();
    }

    public void cadastraAutomovel(String placa, String mod, int ano, String fab, int capt, double odo){
        if(buscarAutomovel(placa) != null) {
            throw new IllegalArgumentException("Placa do veiculo duplicada!");
        }
        Automovel auto = new Automovel(placa, mod, ano, fab, capt, odo);
        automoveis.add(auto);
    }

    public Automovel buscarAutomovel(String placa) {
        if(automoveis.isEmpty()) {
            return null;
        }
        for (Automovel auto : automoveis) {
            if (auto.getPlacaVeiculo().equals(placa)) {
                return auto;
            }
        }
        return null;
    }

    public String toString() {
        String str = "[";
        for(Automovel auto: automoveis) {
            str = str + auto.toString();
            str = str + ", ";
        }
        str = str.substring(0,str.length()-2);
        return str + "]";
    }

    public double mediaVolumeAbastecimentos(List<Abastecimento> lista){
        double soma = 0;
        for(Abastecimento abast: lista){
            soma = soma + abast.getLitros();
        }

        return soma / lista.size();
    }

    public double mediaValorAbastecimentos(List<Abastecimento> lista){
        double soma = 0;
        for(Abastecimento abast: lista){
            soma = soma + abast.getPrecoTotal();
        }

        return soma / lista.size();
    }

    public double mediaCustoQuilometroAbastecimentos(List<Abastecimento> lista){
        double soma = 0;
        for(Abastecimento abast: lista){
            soma = soma + abast.getPrecoTotal();
        }
        
        return soma / (lista.get(lista.size()-1).getOdometroAtual() - lista.get(0).getOdometroAtual());
    }

    public double rendimentoPorLitro(List<Abastecimento> lista){
        if(lista.size() < 2){
            throw new IllegalArgumentException("Rendimento Incalculável");
        }
        return (lista.get(lista.size()-1).getOdometroAtual() - lista.get(lista.size()-2).getOdometroAtual()) / lista.get(lista.size()-1).getLitros();
    }

}