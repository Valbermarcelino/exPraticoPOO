package main;

public class RegraPrioridadeDocente implements PoliticaReserva {
    @Override
    public boolean validar(String tipoUsuario) {
        return "professor".equalsIgnoreCase(tipoUsuario);
    }
}