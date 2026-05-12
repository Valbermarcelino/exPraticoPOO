package test;

// --- CLASSES DO SISTEMA (Removido o 'public' para funcionar em um único arquivo) ---

abstract class Sala {
    private String nome;
    public Sala(String nome) { this.nome = nome; }
    public abstract String getTipo();
    public String getNome() { return nome; }
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

// --- CLASSE DE TESTE (Esta é a única que pode ser public e ter o nome do arquivo) ---

public class SalaFactoryTest {

    public static void main(String[] args) {
        System.out.println("Iniciando testes da SalaFactory...");
        testarCriacaoSalaIndividual();
        testarCriacaoSalaGrupo();
        testarCriacaoLaboratorio();
        testarCriacaoTipoInvalido();
        testarCaseInsensitive();
        System.out.println("Fim dos testes.");
    }

    static void testarCriacaoSalaIndividual() {
        Sala sala = SalaFactory.criarSala("individual", "Sala 101");
        if (sala instanceof SalaIndividual && "Estudo Individual".equals(sala.getTipo())) {
            System.out.println("Sucesso: Sala Individual criada corretamente.");
        } else {
            System.out.println("Erro: Falha ao criar Sala Individual.");
        }
    }

    static void testarCriacaoSalaGrupo() {
        Sala sala = SalaFactory.criarSala("grupo", "Sala Reunião A");
        if (sala instanceof SalaGrupo && "Trabalho em Grupo".equals(sala.getTipo())) {
            System.out.println("Sucesso: Sala de Grupo criada corretamente.");
        } else {
            System.out.println("Erro: Falha ao criar Sala de Grupo.");
        }
    }

    static void testarCriacaoLaboratorio() {
        Sala sala = SalaFactory.criarSala("laboratorio", "Lab de Informática");
        if (sala instanceof Laboratorio && "Laboratório".equals(sala.getTipo())) {
            System.out.println("Sucesso: Laboratório criado corretamente.");
        } else {
            System.out.println("Erro: Falha ao criar Laboratório.");
        }
    }

    static void testarCaseInsensitive() {
        Sala sala = SalaFactory.criarSala("LABORATORIO", "Lab Teste");
        if (sala != null) {
            System.out.println("Sucesso: Factory aceita nomes em maiúsculas.");
        }
    }

    static void testarCriacaoTipoInvalido() {
        try {
            SalaFactory.criarSala("auditorio", "Espaço Grande");
            System.out.println("Erro: A fábrica não deveria aceitar tipos desconhecidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Sucesso: Exceção capturada para tipo inválido.");
        }
    }
}