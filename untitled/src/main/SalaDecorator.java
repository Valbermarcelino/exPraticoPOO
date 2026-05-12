package main;

public abstract class SalaDecorator extends Sala {
    protected Sala salaDecorada;

    public SalaDecorator(Sala sala) {
        super(sala.getNome());
        this.salaDecorada = sala;
    }

    @Override
    public abstract String getTipo();
}