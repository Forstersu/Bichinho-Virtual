package BichinhoVirtual;

public class Animal {
	private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int força;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.força = 10;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void mostrarEstado() {
        System.out.printf("\nO animal se chama %s, é da classe %s, da família %s. Força: %d, Caloria: %d, Idade: %d.\n", 
                           nome, classe, familia, força, caloria, idade);
    }

    public void comer() {
        if (vivo && caloria < 100) {
            caloria = Math.min(caloria + 10, 100);
            força = Math.max(força - 2, 0);
            System.out.printf("\nO animal comeu! Agora sua força é %d e suas calorias valem %d.\n", força, caloria);
        } else {
            System.out.println("\nO animal está cheio ou morto e não pode comer.");
        }
    }

    public void correr() {
        if (vivo && caloria > 0) {
            força = Math.max(força - 5, 0);
            caloria = Math.max(caloria - 5, 0);
            System.out.printf("\nO animal está correndo! Agora sua força é de %d e suas calorias valem %d.\n", força, caloria);
        } else {
            System.out.println("\nO animal está exausto ou morto e não pode correr.");
        }
    }

    public void dormir() {
        if (vivo) {
            força = Math.min(força + 10, 100);
            caloria = Math.max(caloria - 2, 0);
            System.out.printf("\nO animal está dormindo! Sua força aumentou para %d e suas calorias diminuíram para %d.\n", força, caloria);
        } else {
            System.out.println("O animal está morto e não pode dormir.");
        }
    }

    public void morrer() {
        vivo = false;
        força = 0;
        System.out.println("\nO animal morreu!");
        System.out.println(ANSI_YELLOW + "GAME OVER!" + ANSI_RESET);
    }
}
