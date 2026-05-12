package main;

public class SistemaReserva {
    public static void main(String[] args) {
        GerenciadorReserva gerenciador = GerenciadorReserva.getInstancia();

        gerenciador.adicionarSala(SalaFactory.criarSala("individual", "Sala 101"));
        gerenciador.adicionarSala(SalaFactory.criarSala("grupo", "Auditório B"));

        for (Sala s : gerenciador.getSalas()) {
            System.out.println("Sala disponível: " + s.getNome() + " [" + s.getTipo() + "]");
        }
    }
}