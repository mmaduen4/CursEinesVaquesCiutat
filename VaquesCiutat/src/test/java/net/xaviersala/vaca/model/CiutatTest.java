package net.xaviersala.vaca.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class CiutatTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
		
	static Stream<Arguments> createLitresCamio() {
		return Stream.of(Arguments.of(0),Arguments.of(20.0),Arguments.of(102.0),Arguments.of(204.0),Arguments.of(305.0),Arguments.of(400.0));
	}

	@ParameterizedTest
	@MethodSource("createLitresCamio")
	void testPreuCamioSenseLletCiutat(double litresCamio) {
		
		double preuBaseLlet=1.1;
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio);
		
		Ciutat ciutat =new Ciutat();
		
		// ACT
		ciutat.arribaCamio(camioFals1);

		// ASSERT
		assertEquals(litresCamio*preuBaseLlet,ciutat.getPreuPagarCamio(camioFals1));

	}	
	
	static Stream<Arguments> createLitres2Camions() {
	return Stream.of(Arguments.of(0.00,100.00),Arguments.of(0.00,101.00),Arguments.of(0.00,202.00),
					 Arguments.of(102.0,100.00),Arguments.of(102.0,101.00),Arguments.of(102.0,202.00),
					 Arguments.of(202.0,100.00),Arguments.of(202.0,101.00),Arguments.of(202.0,202.00));
	}
	
	@ParameterizedTest
	@MethodSource("createLitres2Camions")
	void testPreuCamioAmbLletCiutat(double litresCamio1,double litresCamio2) {
		
		double preuBaseLlet=1.1;
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio1);
		
		Camio camioFals2 = Mockito.mock(Camio.class);
		Mockito.when(camioFals2.getLitres()).thenReturn(litresCamio2);
		
		Ciutat ciutat =new Ciutat();
		
		// ACT
		ciutat.arribaCamio(camioFals1);
		ciutat.arribaCamio(camioFals2);
		
		// ASSERT		
		assertEquals(litresCamio2*(preuBaseLlet-(int)(litresCamio1/100)*0.1),ciutat.getPreuPagarCamio(camioFals2),0.01F);

	}	
	
}
