package net.xaviersala.vaca.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class CiutatTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
		
	static Stream<Arguments> createLitresCamioParell() {
		return Stream.of(Arguments.of(0.0),Arguments.of(20.0),Arguments.of(102.0),Arguments.of(204.0),Arguments.of(306.0),Arguments.of(400.0));
	}
	
	@ParameterizedTest
	@MethodSource("createLitresCamioParell")
	void testPreuCamioLitresParellSenseLletCiutat(double litresCamio) {
		
		double preuBaseLlet=1.1;
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio);
		Mockito.when(camioFals1.litresEsParell()).thenReturn(1);
		Ciutat ciutat =new Ciutat();
		
		// ACT
		double resultat = ciutat.getPreuPagarCamio(camioFals1);
		
		// ASSERT		
		assertEquals(litresCamio*(preuBaseLlet+0.1),resultat,0.01F);

	}	
	
	static Stream<Arguments> createLitresCamioSenar() {
		return Stream.of(Arguments.of(1.0),Arguments.of(21.0),Arguments.of(103.0),Arguments.of(205.0),Arguments.of(305.0),Arguments.of(401.0));
	}
	
	@ParameterizedTest
	@MethodSource("createLitresCamioSenar")
	void testPreuCamioLitresSenarSenseLletCiutat(double litresCamio) {
		
		double preuBaseLlet=1.1;
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio);
		Mockito.when(camioFals1.litresEsParell()).thenReturn(-1);
		Ciutat ciutat =new Ciutat();
		
		// ACT
		double resultat = ciutat.getPreuPagarCamio(camioFals1);
		
		// ASSERT		
		assertEquals(litresCamio*(preuBaseLlet-0.1),resultat,0.01F);

	}	
		
	static Stream<Arguments> createLitres2Camions() {
	return Stream.of(Arguments.of(0.00,100.00),Arguments.of(0.00,101.00),Arguments.of(0.00,202.00),
					 Arguments.of(102.0,100.00),Arguments.of(102.0,101.00),Arguments.of(102.0,202.00),
					 Arguments.of(202.0,100.00),Arguments.of(202.0,101.00),Arguments.of(202.0,202.00));
	}
	
	@ParameterizedTest
	@MethodSource("createLitres2Camions")
	void testPreuCamioLitresSenarAmbLletCiutat(double litresCamio1,double litresCamio2) {
		
		double preuBaseLlet=1.1;
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio1);
		
		Camio camioFals2 = Mockito.mock(Camio.class);
		Mockito.when(camioFals2.getLitres()).thenReturn(litresCamio2);
		Mockito.when(camioFals1.litresEsParell()).thenReturn(-1);
		
		Ciutat ciutat =new Ciutat();
		
		// ACT
		ciutat.getPreuPagarCamio(camioFals1);
		double resultat = ciutat.getPreuPagarCamio(camioFals2);
		
		// ASSERT		
		assertEquals(litresCamio2*(preuBaseLlet-0.1-(int)(litresCamio1/100)*0.1),resultat,0.01F);

	}	
	
	@ParameterizedTest
	@MethodSource("createLitres2Camions")
	void testPreuCamioLitresParellAmbLletCiutat(double litresCamio1,double litresCamio2) {
		
		double preuBaseLlet=1.1;
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio1);
		
		Camio camioFals2 = Mockito.mock(Camio.class);
		Mockito.when(camioFals2.getLitres()).thenReturn(litresCamio2);
		Mockito.when(camioFals1.litresEsParell()).thenReturn(1);
		
		Ciutat ciutat =new Ciutat();
		
		// ACT
		ciutat.getPreuPagarCamio(camioFals1);
		double resultat = ciutat.getPreuPagarCamio(camioFals2);
		
		// ASSERT		
		assertEquals(litresCamio2*(preuBaseLlet+0.1-(int)(litresCamio1/100)*0.1),resultat,0.01F);

	}
	
	
	
	static Stream<Arguments> createLitres3Camions() {
	return Stream.of(Arguments.of(900.0,100.00,100.00),Arguments.of(900.0,101.00,100.00),Arguments.of(900.0,202.00,100.00));
	}
	
	@ParameterizedTest
	@MethodSource("createLitres3Camions")
	void testPreuCamioAmbLletCiutatPerSobre1000(double litresCamio1,double litresCamio2,double litresCamio3) {		
		
		// ARRANGE		
		Camio camioFals1 = Mockito.mock(Camio.class);
		Mockito.when(camioFals1.getLitres()).thenReturn(litresCamio1);
		
		Camio camioFals2 = Mockito.mock(Camio.class);
		Mockito.when(camioFals2.getLitres()).thenReturn(litresCamio2);
		
		Camio camioFals3 = Mockito.mock(Camio.class);
		Mockito.when(camioFals3.getLitres()).thenReturn(litresCamio3);
		
		Ciutat ciutat =new Ciutat();
		
		// ACT
		ciutat.getPreuPagarCamio(camioFals1);
		ciutat.getPreuPagarCamio(camioFals2);
		double resultat = ciutat.getPreuPagarCamio(camioFals3);
		
		// ASSERT		
		assertEquals(0.0,resultat,0.01F);
	}
	
}
