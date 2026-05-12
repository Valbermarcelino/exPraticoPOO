package main;

public class ObserverTest {
    public static void main(String[] args) {
        GerenciadorReserva gerenciador = GerenciadorReserva.getInstancia();
        Sala sala = SalaFactory.criarSala("individual", "Cabine 05");

        Usuario aluno1 = new Usuario("Valber");
        Usuario aluno2 = new Usuario("Marcelino");

        gerenciador.inscrever(aluno1);
        gerenciador.inscrever(aluno2);

        gerenciador.realizarReserva(sala, "professor");
    }
}