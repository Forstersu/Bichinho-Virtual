package BichinhoVirtual;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------- Crie seu novo animal ---------\n");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();

        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        Animal animal = new Animal(nome, classe, familia);
        AcaoDoAnimal jogo = new AcaoDoAnimal(animal);

        jogo.iniciar();
        scanner.close();
    }
}

