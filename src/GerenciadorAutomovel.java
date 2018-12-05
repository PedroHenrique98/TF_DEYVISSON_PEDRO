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

}