package main;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorReserva {
    private static GerenciadorReserva instancia;
    private List<Sala> salas;
    private PoliticaReserva politica;

    private GerenciadorReserva() {
        salas = new ArrayList<>();
        politica = new RegraPadrao();
    }

    public static synchronized GerenciadorReserva getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorReserva();
        }
        return instancia;
    }

    // Permite trocar a estratégia em tempo de execução (Exigência do professor)
    public void setPolitica(PoliticaReserva novaPolitica) {
        this.politica = novaPolitica;
    }

    public boolean realizarReserva(Sala sala, String usuario) {
        if (politica.validar(usuario)) {
            System.out.println("Reserva confirmada para " + usuario + " na sala " + sala.getNome());
            return true;
        }
        System.out.println("Reserva negada para " + usuario + " devido à política atual.");
        return false;
    }

    public void adicionarSala(Sala sala) { salas.add(sala); }
    public List<Sala> getSalas() { return new ArrayList<>(salas); }
}