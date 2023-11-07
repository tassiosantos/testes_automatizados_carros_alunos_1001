import model.Carro;

public class Main {
    /**
     *
     * Um carro tem os seguintes atributos:
     *  - cor
     *  - marca
     *  - modelo
     *  - ligado
     *  - velocidadeAtual
     *  - velocidadeMáxima
     *
     *  Enquanto o carro estiver desligado deve ser capaz de:
     *  - Ligar
     *  - Mostrar estado atual (toString())
     *
     * Enquanto o carro estiver ligado deve ser capaz de:
     * - Desligar
     * - Acelerar
     * - Frear
     * - Motrar estado atual
     *
     * Regras:
     *
     * - Só podemos realizar as ações como acelerar e frear com o carro ligado
     * - Só podemos desligar o carro quando ele parar totalmente (velocidadeAtual = 0)
     * - Não existe velocidade negativa
     * - O carro não pode passar de sua velocidade máxima
     *
     */

    public static void main(String[] args) {
    }

    public void testes() {
        // Junit

        // Gherkin



        // Teste #4 - Deve desligar corretamente um carro ligado
        // Given (Dado)
        Carro carro_04 = new Carro();

        // When (Quando)
        carro_04.ligar();
        carro_04.desligar();

        // Then (Então)
        System.out.println("Teste 04");
        System.out.println(carro_04.getLigado() == false);





    }


}
