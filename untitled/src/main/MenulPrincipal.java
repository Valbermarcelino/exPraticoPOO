package main;

import java.util.Scanner;

public class MenuPrincipal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GerenciadorReserva gerenciador = GerenciadorReserva.getInstancia();

    public static void main(String[] args) {
        configurarDadosIniciais();
        exibirMenu();
    }

    private static void configurarDadosIniciais() {
        gerenciador.adicionarSala(SalaFactory.criarSala("individual", "Cabine 01"));
        gerenciador.adicionarSala(SalaFactory.criarSala("grupo", "Sala de Reunião A"));
        gerenciador.adicionarSala(SalaFactory.criarSala("laboratorio", "Laboratório de Redes"));

        gerenciador.inscrever(new Usuario("Valber"));
    }

    private static void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DE RESERVA DE SALAS ===");
            System.out.println("1. Listar Salas Disponíveis (RF-01)");
            System.out.println("2. Realizar Reserva (RF-02)");
            System.out.println("3. Mudar Política de Acesso (Strategy - RF-03)");
            System.out.println("4. Adicionar Equipamento (Decorator - Bônus)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida.");
            }
        }
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> listarSalas();
            case 2 -> fazerReserva();
            case 3 -> mudarPolitica();
            case 4 -> decorarSala();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void listarSalas() {
        System.out.println("\n--- Salas Cadastradas ---");
        for (int i = 0; i < gerenciador.getSalas().size(); i++) {
            Sala s = gerenciador.getSalas().get(i);
            System.out.println(i + ". " + s.getNome() + " [" + s.getTipo() + "]");
        }
    }

    private static void fazerReserva() {
        listarSalas();
        System.out.print("Escolha o número da sala: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de usuário (estudante/professor): ");
        String tipo = scanner.nextLine();
        
        Sala sala = gerenciador.getSalas().get(index);
        gerenciador.realizarReserva(sala, tipo); // Aciona Strategy e Observer
    }

    private static void mudarPolitica() {
        System.out.println("1. Padrão (Livre)");
        System.out.println("2. Restrita (Apenas Professores)");
        System.out.print("Escolha a política: ");
        int pol = Integer.parseInt(scanner.nextLine());
        
        if (pol == 1) gerenciador.setPolitica(new RegraPadrao());
        else gerenciador.setPolitica(new RegraPrioridadeDocente());
        System.out.println("Política atualizada.");
    }

    private static void decorarSala() {
        listarSalas();
        System.out.print("Escolha a sala para adicionar multimídia: ");
        int index = Integer.parseInt(scanner.nextLine());
        
        Sala salaOriginal = gerenciador.getSalas().get(index);
        Sala salaComBonus = new EquipamentoMultimidia(salaOriginal);
        
        System.out.println("Upgrade concluído: " + salaComBonus.getTipo());
    }
}
