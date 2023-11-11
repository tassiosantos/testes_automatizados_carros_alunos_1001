package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Annotations
 *
 * @Before // Junit 4 - Roda uma vez antes de cada teste
 * @BeforeEach // Junit 5
 *
 * @BeforeClass // Junit 4 - Roda uma vez antes de TODOS os tests
 * @BeforeAll // Junit 5
 *
 * @After // Junit 4 - Roda uma vez após cada teste
 * @AfterEach // Junit 5
 *
 * @AfterClass // Junit 4 - Roda uma vez após TODOS os testes
 * @AfterAll // Junit 5
 *
 *
 * @Ignore // Junit 4 - Ignora um teste
 * @Disabled
 *
 * Novo:
 * @DisplayName // Junit 5
 *
 * Assert // Junit 4
 * Assertion // Junit 5
 *
 * fail - fail
 * assertTrue - assertTrue
 * assertSame - assertSame
 * assertNull - assertNull
 * assertNotSame - assertNotSame
 * assertNotNull - assertNotNull
 * assertFalse - assertFalse
 * assertEquals - assertEquals
 * assertArrayEquals - assertArrayEquals
 * assertThat - N/A
 * assertThrows (4.13) - assertThrows
 *
 * Nova:
 * assertAll
 * assertThrows
 *
 */

public class CarroTest {
    // F.I.R.S.T - Principios
    // F - Fast
    // I - Isolado/Independente
    // R - Repetable
    // S - Self-validating
    // T - Oportuno (TDD)

    @BeforeAll
    public static void beforeClass() {
        System.out.println("roda uma vez antes de todos testes");
    }

    @BeforeEach
    public void before() {
        System.out.println("roda uma vez antes da cada teste");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("roda uma vez depois de todos testes");
    }

    @AfterEach
    public void after() {
        System.out.println("roda uma vez depois da cada teste");
    }



    @Test
    public void deveCriarUmCarroComTodosOsCampos() {
        // public Carro(String cor, String marca, String modelo, Integer velocidadeMaxima)
        Carro carro = new Carro("Preto", "BMW", "X1", 350);

        assertAll("Testando atributos do carro",
                () -> assertEquals("Preto", carro.getCor()),
                () -> assertEquals("BMW", carro.getMarca()),
                () -> assertEquals("X1", carro.getModelo()),
                () -> assertEquals(350, carro.getVelocidadeMaxima())
        );
    }

    @Test
    public void deveIniciarDesligado() {
        System.out.println("deveIniciarDesligado");
        // Given (Dado)
        Carro carro = new Carro();
        // When (Quando)// Then (Então)
        assertFalse(carro.getLigado());
    }


    @Test
    @Disabled // TODO
    public void deveLigarCorretamente() {
        System.out.println("deveLigarCorretamente");
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro();

        // When (Quando)
        carro.ligar();

        // Then (Então)
        assertTrue(carro.getLigado());
    }

    @Test
    @DisplayName("Meu teste com nome bonito")
    public void deveIniciarComVelocidadeZero() {
        System.out.println("deveIniciarComVelocidadeZero");
        // Teste #2 - Deve iniciar com velocidade Zero
        // Given (Dado)
        Carro carro = new Carro();
        // When (Quando)
        // Then (Então)
        assertEquals((Integer) 0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveAcelerarCorretamente() throws Exception {
        System.out.println("deveAcelerarCorretamente");
        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado)
        Carro carro = new Carro();

        // When (Quando)
        carro.ligar();
        carro.acelerar(10);

        // Then (Então)
        assertEquals((Integer) 10, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveUltrapassarAVelocidadeMaxima() throws Exception {
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
        assertEquals((Integer) 200, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveTerVelocidadeInferiorAZero() throws Exception {
        System.out.println("naoDeveTerVelocidadeInferiorAZero");
        // Given
        Carro carro = new Carro();
        carro.getLigado();
        carro.acelerar(100);

        // When
        carro.frear(50);
        carro.frear(51);

        // Then
        assertEquals((Integer) 0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveLancarExceptionEmCasoDeAceleracaoNegativa() {
        Carro carro = new Carro();
        carro.ligar();

        Throwable throwable =                               // runnable
                Assertions.assertThrows(Exception.class, () -> carro.acelerar(-10));

        Assertions.assertEquals("A aceleracao não pode ser menor que zero!", throwable.getMessage());
    }

    @Test
    public void testeSemAssert() {
        //  Testes sem assert vão passar
    }

    @Test
    public void aoTrancarUmCarroJaTrancadoNaoDeveFazerNada() {
        // Given
        Carro carro = new Carro();
        carro.ligar();

        // When
        carro.trancar();
        carro.trancar();

        // Then
        assertEquals(true, carro.getTrancado());
    }
}
