package main;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorReserva {
    private static GerenciadorReserva instancia;
    private List<Sala> salas;

    private GerenciadorReserva() {
        salas = new ArrayList<>();
    }

    public static synchronized GerenciadorReserva getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorReserva();
        }
        return instancia;
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public List<Sala> getSalas() {
        return new ArrayList<>(salas);
    }
}