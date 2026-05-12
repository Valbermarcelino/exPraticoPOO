package main;

class SalaGrupo extends Sala {
    public SalaGrupo(String nome) {
        super(nome);
    }

    public String getTipo() {
        return "Trabalho em Grupo";
    }
}
