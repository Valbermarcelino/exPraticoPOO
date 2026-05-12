package main;

public abstract class Sala {
    private final String nome;

    public Sala(String nome) {
        this.nome = nome;
    }

    public abstract String getTipo();

    public String getNome() {
        return nome;
    }
}
