package main;

class Laboratorio extends Sala {
    public Laboratorio(String nome) {
        super(nome);
    }

    public String getTipo() {
        return "Laboratório";
    }
}
