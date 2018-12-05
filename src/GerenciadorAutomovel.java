import java.util.*;

public class GerenciadorAutomovel {

    private List<Automovel> automoveis;

    public GerenciadorAutomovel(){
        automoveis = new ArrayList<>();
    }

    public void cadastraAutomovel(String pv, String m, int a, String f, int ct, double o){
        if(buscarAutomovel(pv) != null) {
            throw new IllegalArgumentException("Placa do veiculo duplicada!");
        }
        Automovel auto = new Automovel(pv, m, a, f, ct, o);
        automoveis.add(auto);
    }

    public Automovel buscarAutomovel(String placa) {
        for(Automovel auto: automoveis) {
            if(auto.getPlacaVeiculo() == placa);
            return auto;
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