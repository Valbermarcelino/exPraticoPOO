package main;

public class DecoratorTest {
    public static void main(String[] args) {
        Sala salaComum = SalaFactory.criarSala("grupo", "Sala 202");
        System.out.println("Antes: " + salaComum.getTipo());
        
        Sala salaTurbinada = new EquipamentoMultimidia(salaComum);

        System.out.println("Depois: " + salaTurbinada.getTipo());
        System.out.println("Nome mantido: " + salaTurbinada.getNome());
    }
}