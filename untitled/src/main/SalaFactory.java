package main;

class SalaFactory {
    public static Sala criarSala(String tipo, String nome) {
        return switch (tipo.toLowerCase()) {
            case "individual" -> new SalaIndividual(nome);
            case "grupo" -> new SalaGrupo(nome);
            case "laboratorio" -> new Laboratorio(nome);
            default -> throw new IllegalArgumentException("Tipo de sala desconhecido.");
        };
    }
}