public abstract class Sala {
    private String nome;

    public Sala(String nome) { this.nome = nome; }
    public abstract String getTipo();
}

class SalaIndividual extends Sala {
    public SalaIndividual(String nome) { super(nome); }
    public String getTipo() { return "Estudo Individual"; }
}

class SalaGrupo extends Sala {
    public SalaGrupo(String nome) { super(nome); }
    public String getTipo() { return "Trabalho em Grupo"; }
}

class Laboratorio extends Sala {
    public Laboratorio(String nome) { super(nome); }
    public String getTipo() { return "Laboratório"; }
}

public class SalaFactory {
    public static Sala criarSala(String tipo, String nome) {
        return switch (tipo.toLowerCase()) {
            case "individual" -> new SalaIndividual(nome);
            case "grupo" -> new SalaGrupo(nome);
            case "laboratorio" -> new Laboratorio(nome);
            default -> throw new IllegalArgumentException("Tipo de sala desconhecido.");
        };
    }
}