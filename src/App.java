public class App {
    public static void main(String args[]){
        public class App {
            public static void main(String args[]){
                System.out.println("Hello World cara.");

                Abastecimento ab = new Abastecimento("ABC-132","Gasolina",12.5,3.98,20);

                GerenciadorAbastecimento gerenciaA = new GerenciadorAbastecimento();
                GerenciadorAutomovel gerenciaB = new GerenciadorAutomovel();
                gerenciaB.cadastraAutomovel("APQ-172", "Celta", 2018, "ford",20,16);
                gerenciaA.solicitarAbastecimento(gerenciaB.buscarAutomovel("APQ-172"), "Gasolina", 15, 20, 3 );
                gerenciaA.solicitarAbastecimento(gerenciaB.buscarAutomovel("APQ-172"), "Gasolina", 15, 25, 3 );

                System.out.printf(gerenciaA.toString());
                //System.out.println(gerenciaB);
                System.out.println(ab);
            }
        }
    }
}
