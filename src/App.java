public class App {
    public static void main(String args[]){
        System.out.println("Hello World cara.\n");

        GerenciadorAbastecimento gerenciaA = new GerenciadorAbastecimento();
        GerenciadorAutomovel gerenciaB = new GerenciadorAutomovel();
        gerenciaB.cadastraAutomovel("APQ-172", "Celta", 2018, "ford",20,16);
        gerenciaA.solicitarAbastecimento(gerenciaB.buscarAutomovel("APQ-172"), "Gasolina", 15, 20, 3 );
        gerenciaA.solicitarAbastecimento(gerenciaB.buscarAutomovel("APQ-172"), "Gasolina", 20, 25, 3 );

        System.out.printf(gerenciaA.toString());
        System.out.println("\n\n");
        System.out.printf("\n" + gerenciaB.mediaCustoQuilometroAbastecimentos(gerenciaA.getAbastecimentosAutomovel("APQ-172")));
        System.out.printf("\n" + gerenciaB.mediaValorAbastecimentos(gerenciaA.getAbastecimentosAutomovel("APQ-172")));
        System.out.printf("\n" + gerenciaB.mediaVolumeAbastecimentos(gerenciaA.getAbastecimentosAutomovel("APQ-172")));
        System.out.printf("\n" + gerenciaB.rendimentoPorLitro(gerenciaA.getAbastecimentosAutomovel("APQ-172")));

        //System.out.println(gerenciaB);
    }
}