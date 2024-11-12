// AcaoDoAnimal.java
package BichinhoVirtual;

import java.util.Scanner;

public class AcaoDoAnimal {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";

    private Animal animal;
    private Scanner scanner;

    public AcaoDoAnimal(Animal animal) {
        this.animal = animal;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        animal.mostrarEstado();
        
        while (animal.isVivo()) {
            exibirMenu();
            int opcao = lerOpcao();
            executarAcao(opcao);
        }
    }

    private void exibirMenu() { //Os códigos dos emojis foram retirados do site Unicode
        System.out.println("\n----------------------------------------");
        System.out.printf(ANSI_CYAN + "O que o " + animal.getNome() + " vai fazer agora?" + ANSI_RESET);
        System.out.println("\n----------------------------------------");
        System.out.println("1- \uD83E\uDD69 Comer"); 
        System.out.println("2- \uD83C\uDFC3\u200D\u2642\uFE0F Correr");  
        System.out.println("3- \uD83D\uDE34 Dormir");  
        System.out.println("4- \u26B0\uFE0F Morrer");
        System.out.println("----------------------------------------");
        System.out.print(ANSI_CYAN + "Escolha uma opção: " + ANSI_RESET);
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void executarAcao(int opcao) {
        switch (opcao) {
            case 1 -> animal.comer();
            case 2 -> animal.correr();
            case 3 -> animal.dormir();
            case 4 -> animal.morrer();
            default -> System.out.println(ANSI_RED + "\nOpção inválida." + ANSI_RESET);
        }
    }
}
