package main;

public class StrategyTest {
    public static void main(String[] args) {
        GerenciadorReserva gerenciador = GerenciadorReserva.getInstancia();
        Sala sala = SalaFactory.criarSala("grupo", "Sala de Reunião 01");

        System.out.println("--- Testando Regra Padrão ---");
        gerenciador.setPolitica(new RegraPadrao());
        gerenciador.realizarReserva(sala, "estudante");

        System.out.println("\n--- Testando Regra Prioridade Docente ---");
        gerenciador.setPolitica(new RegraPrioridadeDocente());

        System.out.print("Tentativa Estudante: ");
        gerenciador.realizarReserva(sala, "estudante");

        System.out.print("Tentativa Professor: ");
        gerenciador.realizarReserva(sala, "professor");
    }
}