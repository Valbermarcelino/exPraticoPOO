package main;

class SalaIndividual extends Sala {
    public SalaIndividual(String nome) {
        super(nome);
    }

    public String getTipo() {
        return "Estudo Individual";
    }
}
