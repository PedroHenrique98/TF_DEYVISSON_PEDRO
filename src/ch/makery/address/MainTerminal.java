package ch.makery.address;

import ch.makery.address.model.GerenciadorAbastecimento;
import ch.makery.address.model.GerenciadorAutomovel;
import ch.makery.address.model.LeituraArquivos;

import java.util.Scanner;

public class MainTerminal {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in) ;
        GerenciadorAutomovel gauto = new LeituraArquivos().lerArquivoAutomovel();
        GerenciadorAbastecimento gabast = new LeituraArquivos().lerArquivoAbastecimentos(gauto);

        System.out.println("Sistema de Abastecimentos");
        System.out.println("Seleciona a opção:");
        System.out.println("1 - Cadastro de automóveis");
        System.out.println("2 - Listar Automoveis");
        System.out.println("3 - Listar Abastecimentos");
        System.out.println("4 - Custo medio de KMs abastecidos: ");
        int o = scan.nextInt();
        scan.nextLine();
        switch(o){
            case 1: {
                System.out.println("Informe a placa: ");
                String placa = scan.nextLine();
                System.out.println("Informe o modelo: ");
                String mod = scan.nextLine();
                System.out.println("Informe o ano: ");
                int ano = scan.nextInt();
                scan.nextLine();
                System.out.println("Informe o fabricante: ");
                String fab= scan.nextLine();
                System.out.println("Informe a capacidade do tanque: ");
                int ct = scan.nextInt();
                System.out.println("Informe o odometro atual: ");
                double odo = scan.nextDouble();

                gauto.cadastraAutomovel(placa,mod, ano, fab, ct, odo);

                break;
            }
            case 2: {
                System.out.println("\nLista de automóveis\n");
                System.out.println(gauto.toString());
                break;
            }
            case 3: {
                System.out.println("\nLista de abastecimentos cadastrados\n");
                System.out.println(gabast.toString());
                break;
            }
            case 4: {
                System.out.println("Informe a placa do veículo");
                String placa = scan.nextLine();
                System.out.println("" + gauto.mediaCustoQuilometroAbastecimentos(gabast.getAbastecimentosAutomovel(placa)));
            }

        }


    }

}