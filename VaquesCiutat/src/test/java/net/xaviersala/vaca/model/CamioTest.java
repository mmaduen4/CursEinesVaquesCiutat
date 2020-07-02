package net.xaviersala.vaca.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class CamioTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	

	static Stream<Arguments> createPesMaxCamioPesVacaOK() {
		return Stream.of(Arguments.of(1000, 100), Arguments.of(1000, 900), Arguments.of(1000, 1000));
	}

	@ParameterizedTest
	@MethodSource("createPesMaxCamioPesVacaOK")
	void testEntraVacaAmbPesSotaOIgualALimit(double pesMaxim, double pesVaca) {
		// ARRANGE
		Vaca vacaFalsa = Mockito.mock(Vaca.class);
		Mockito.when(vacaFalsa.getPes()).thenReturn(pesVaca);

		Camio sut = new Camio(pesMaxim);
		double pesActual = sut.getPesActual();

		// ACT
		boolean result = sut.entraVaca(vacaFalsa);

		// ASSERT
		assertTrue(result);
		assertEquals(pesActual + pesVaca, sut.getPesActual());

	}
	
	static Stream<Arguments> createPesMaxCamioPesVacaX() {
		return Stream.of(Arguments.of(1000, 1001));
	}

	@ParameterizedTest
	@MethodSource("createPesMaxCamioPesVacaX")
	void testEntraVacaAmbPesSobreLimit(double pesMaxim, double pesVaca) {
		// ARRANGE
		Vaca vacaFalsa = Mockito.mock(Vaca.class);
		Mockito.when(vacaFalsa.getPes()).thenReturn(pesVaca);

		Camio sut = new Camio(pesMaxim);
		double pesActual = sut.getPesActual();

		// ACT
		boolean result = sut.entraVaca(vacaFalsa);

		// ASSERT
		assertFalse(result);
		assertEquals(pesActual, sut.getPesActual());
	}
	
	static Stream<Arguments> createPesVaca() {
		return Stream.of(Arguments.of(100), Arguments.of(200), Arguments.of(300));
	}

	@ParameterizedTest
	@MethodSource("createPesVaca")
	void testTreuVacaOK(double pesVaca) {

		// ARRANGE
		Camio sut = new Camio(1000);		
		for (int i = 0; i < 10; i++) {
			Vaca vacaFalsa = Mockito.mock(Vaca.class);
			Mockito.when(vacaFalsa.getPes()).thenReturn(pesVaca);
			sut.entraVaca(vacaFalsa);
		}
		double pesActual = sut.getPesActual();

		// ACT + ASSERT
		while (sut.getVaques().size() > 0) {
			assertTrue(sut.treuVaca((sut.getVaques().get(0))));
			assertEquals(pesActual - pesVaca, sut.getPesActual());
			pesActual = sut.getPesActual();
		}

	}
	

}
