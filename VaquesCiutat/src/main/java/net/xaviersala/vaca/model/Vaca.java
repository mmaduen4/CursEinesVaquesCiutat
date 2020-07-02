package net.xaviersala.vaca.model;

public class Vaca {
	
	private String nom;
    private double pes;
    private Raca raca;
    
    public Vaca(String nom, double pes, Raca raca)
    {
    	this.nom = nom;
    	this.pes = pes;
    	this.raca = raca;
    }    

    public String getNom() {
		return nom;
	}

	public double getPes() {
		return pes;
	}

	public Raca getRaca() {
		return raca;
	}

	/**
	 * Cada vaca produeix de mitjana una quantitat de llet que depèn dels quilograms que pesa i de la mitjana de llet de la raça
	 * @return
	 */
	public double getLitres() {
    	return pes * raca.getLitresPerKg();
    }

    public String crida()
    {
        String crit = "";
        for (int i = 0; i < pes; i += 100)
        {
            crit += " Mu";
        }
        return crit;
    }

    @Override
    public String toString()
    {
        return nom +  " (" + raca.getNom() + ") - pes:" + pes;
    }


}
