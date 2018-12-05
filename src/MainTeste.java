public class MainTeste {
    public static void main(String args[]){
        GerenciadorAutomovel gauto = new GerenciadorAutomovel();

        GerenciadorAbastecimento gabast = new GerenciadorAbastecimento();

        Automovel a1 = new Automovel("ABC1234", "UNO", 2018, "FIAT", 45, 0.0);
        Automovel a2 = new Automovel("ABC4321", "PALIO", 2015, "FIAT", 40, 45000.40);
        Automovel a3 = new Automovel("CBA1234", "SANDERO", 2013, "RENAULT", 55, 135480.90);
        Automovel a4 = new Automovel("CBA4321", "KAPTUR", 2017, "RENAULT", 60, 69815.65);
        Automovel a5 = new Automovel("ACB 1234", "GOL", 2016, "VOLKSWAGEN", 35, 8000.0);
        Automovel a6 = new Automovel("ACB 4321", "T-CROSS", 2018, "VOLKSWAGEN", 50, 300.84);


    }
}
