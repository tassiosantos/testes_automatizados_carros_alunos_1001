package model;

import org.junit.*;

public class CarroTest {
    @Test
    public void deveIniciarDesligado() {
        System.out.println("deveIniciarDesligado");
        // Given (Dado)
        Carro carro = new Carro();
        // When (Quando)// Then (Então)
        Assert.assertFalse(carro.getLigado());
    }

    @Test
    public void deveLigarCorretamente() {
        System.out.println("deveLigarCorretamente");
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro();

        // When (Quando)
        carro.ligar();

        // Then (Então)
        Assert.assertTrue(carro.getLigado());
    }

    @Test
    public void deveIniciarComVelocidadeZero() {
        System.out.println("deveIniciarComVelocidadeZero");
        // Teste #2 - Deve iniciar com velocidade Zero
        // Given (Dado)
        Carro carro = new Carro();
        // When (Quando)
        // Then (Então)
        Assert.assertEquals((Integer) 0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveAcelerarCorretamente() {
        System.out.println("deveAcelerarCorretamente");
        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado)
        Carro carro = new Carro();

        // When (Quando)
        carro.ligar();
        carro.acelerar(10);

        // Then (Então)
        Assert.assertEquals((Integer) 10, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveUltrapassarAVelocidadeMaxima() {
        System.out.println("naoDeveUltrapassarAVelocidadeMaxima");
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro(200);

        // When
        carro.ligar();
        carro.acelerar(100);
        carro.acelerar(100);
        carro.acelerar(100);

        // Then
        Assert.assertEquals((Integer) 200, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveTerVelocidadeInferiorAZero() {
        System.out.println("naoDeveTerVelocidadeInferiorAZero");
        // Given
        Carro carro = new Carro();
        carro.getLigado();
        carro.acelerar(100);

        // When
        carro.frear(50);
        carro.frear(51);

        // Then
        Assert.assertEquals((Integer) 0, carro.getVelocidadeAtual());
    }
}
