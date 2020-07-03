package net.xaviersala.vaca.model;

public class Ciutat {
	
	private double preuBaseLlet;
	private double preuActualLlet;
	private double litresActualsLlet;
	
	public Ciutat() {
		litresActualsLlet=0;
		preuBaseLlet=1.1;
		preuActualLlet=preuBaseLlet;
	}
	
	public void arribaCamio(Camio camio) {
		// Nou preu de la llet
		setPreuActualLlet(); 
		// Augmenta litres de llet a la ciutat 
		setLitresActualsLlet(camio);
	}
	
	private void setPreuActualLlet() {							
		int reduccioPerCada100=reduccioMultipleCent();			
		preuActualLlet=preuActualLlet-reduccioPerCada100*0.1;		
	}
	
	/**
	 * Per cada 100 litres de llet que hi ha a la ciutat, quan arriba el camió, 
	 * el preu es redueix 0,1 euros per litres
	 * @return
	 */
	private int reduccioMultipleCent() {	
		return (int)(litresActualsLlet/100);
	}	
	
	/**
	 * Permet indicar quan cobrarà un camió en arribar a la ciutat
	 * @param camio
	 * @return
	 */
	public double getPreuPagarCamio(Camio camio) {		
		return camio.getLitres()*getPreuActualLlet();
	}
	
	public double getPreuActualLlet() {
		return preuActualLlet;
	}

	public double getLitresActualsLlet()
	{
		return litresActualsLlet;
	}
	
	private void setLitresActualsLlet(Camio camio)
	{
		litresActualsLlet+=camio.getLitres();
	}

}
