package Principal;

import Modelos.ApiConectar;
import Modelos.MeuMenu;


import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        MeuMenu menuinicial = new MeuMenu();
        Scanner leitura = new Scanner(System.in);
        menuinicial.mostrarMenuCompleto();
        double valorParaConversao = 0;
        var opcaoEscolhida = 1;
        ApiConectar conversao = new ApiConectar();

        while (opcaoEscolhida > 0 && opcaoEscolhida <= 7) {
            if (opcaoEscolhida == 7) {
                System.out.println("Programa finalizado !");
                break;
            }

            System.out.println("\nDigite a opção desejada: ");
            try {
                opcaoEscolhida = leitura.nextInt();
                if (opcaoEscolhida > 0 && opcaoEscolhida <= 7) {
                    if (opcaoEscolhida == 7) {
                        System.out.println("Programa finalizado!");
                        break;
                    }
                    System.out.println("Digite o valor a ser convertido: ");
                    valorParaConversao = leitura.nextDouble();
                    System.out.println("O valor convertido é: " + "\n" + conversao.conversor(opcaoEscolhida, valorParaConversao));
                    menuinicial.mostrarMenuDenovo();

                } else {
                    System.out.println("A opção digitada não é valida, tente novamente (Opção de 1 a 7): \n ");
                    opcaoEscolhida = leitura.nextInt();
                }


            } catch (RuntimeException | IOException | InterruptedException e) {
                System.out.println(e);

            }

        }
    }
}