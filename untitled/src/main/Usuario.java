package main;

public class Usuario implements Observador {
    private String nome;

    public Usuario(String nome) { this.nome = nome; }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("[Notificação para " + nome + "]: " + mensagem);
    }
}