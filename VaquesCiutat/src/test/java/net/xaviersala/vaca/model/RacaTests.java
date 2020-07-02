/**
 * 
 */
package net.xaviersala.vaca.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import net.xaviersala.vaca.model.Raca;

/**
 * @author xavier
 *
 */
public class RacaTests {

	Raca sut;

	@BeforeEach
	public void setUp() throws Exception {

	}

	/*
	 * Comprova que es retorna el nom que hem posat
	 */
	@ParameterizedTest
	@ValueSource(strings = { "Holdstein", "X", "XXXXXXXXXX" })
	public void testQueElNomEsElQueLiHemDonat(String nom) {
		// ARRANGE
		sut = new Raca(nom, 5);

		// ACT
		String resultat = sut.getNom();

		// ASSERT
		assertEquals(nom, resultat, "El nom de la Raça no s'esta inicialitzant bé");
	}

	/*
	 * Comprova que si rep null retorna raça desconeguda
	 */
	@Test
	public void testQueSiNoLiDonemNomLaMarcaDesconeguda() {
		// ARRANGE
		sut = new Raca(null, 10);

		// ACT
		String resultat = sut.getNom();

		// ASSERT
		assertEquals(Raca.desconeguda, resultat);
	}

	@Test
	public void testQueSiElNomEsBuitRetornaRaçaDesconeguda() {
		// ARRANGE
		sut = new Raca("", 10);

		// ACT
		String resultat = sut.getNom();

		// ASSERT
		assertEquals(Raca.desconeguda, resultat);
	}

	@ParameterizedTest
	@ValueSource(strings = { "  ", "\t", "\n" })
	public void testQueElsNomsBuitsRetornenDesconeguda(String nom) {
		// ARRANGE
		sut = new Raca(nom, 10);

		// ACT
		String resultat = sut.getNom();

		// ASSERT
		assertEquals(Raca.desconeguda, resultat);
	}

}
