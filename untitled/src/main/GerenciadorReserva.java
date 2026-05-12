package main;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorReserva {
    private static GerenciadorReserva instancia;
    private List<Sala> salas;
    private PoliticaReserva politica;
    private List<Observador> observadores = new ArrayList<>();

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

    public void inscrever(Observador obs) { observadores.add(obs); }

    private void notificarTodos(String mensagem) {
        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
        }
    }

    public boolean realizarReserva(Sala sala, String usuario) {
        if (politica.validar(usuario)) {
            String msg = "Reserva confirmada para " + usuario + " na sala " + sala.getNome();
            System.out.println(msg);
            notificarTodos(msg); //
            return true;
        }
        return false;
    }

    public void setPolitica(PoliticaReserva novaPolitica) { this.politica = novaPolitica; }
    public void adicionarSala(Sala sala) { salas.add(sala); }
    public List<Sala> getSalas() { return new ArrayList<>(salas); }
}