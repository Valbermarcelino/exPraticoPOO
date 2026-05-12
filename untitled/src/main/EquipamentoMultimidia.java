package main;

public class EquipamentoMultimidia extends SalaDecorator {
    public EquipamentoMultimidia(Sala sala) {
        super(sala);
    }

    @Override
    public String getTipo() {
        return salaDecorada.getTipo() + " + Projetor Multimídia";
    }
}