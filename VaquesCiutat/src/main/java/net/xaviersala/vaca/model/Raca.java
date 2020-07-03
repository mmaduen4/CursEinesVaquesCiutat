/**
 * 
 */
package net.xaviersala.vaca.model;

/**
 * @author xavier
 *
 */
public class Raca {

	public static final String DESCONEGUDA = "Desconeguda";	
    private String nom;    
    /**
     * Cada raça produeix de mitjana una quantitat de llet associada al seu pes.
     */
    private double litresPerKg;
	
    public Raca(String nom, double litres)
    {
    	if (nom == null || nom.isBlank() || nom.isEmpty()) {
    		nom = DESCONEGUDA;
    	}
        this.nom = nom;
        litresPerKg = litres;
    }

    public String getNom() {
		return nom;
	}
    
	public double getLitresPerKg() {
		return litresPerKg;
	}

	@Override
	public String toString()
    {
        return nom;
    }

}
