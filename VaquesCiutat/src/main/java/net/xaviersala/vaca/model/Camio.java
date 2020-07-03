package net.xaviersala.vaca.model;

import java.util.ArrayList;
import java.util.List;

public class Camio {
		
	/**
	 * Els camions de vaques, poden portar una càrrega amb un pes màxim que no es pot superar.
	 * 
	 */
	private double pesMaxim;
    private double pesActual;
    private List<Vaca> vaques;
	
    public Camio(double pesMax)
    {
   	
    	if (pesMax<=0)
    		throw new AssertionError();
    	
        pesMaxim = pesMax;
        pesActual = 0;
        vaques = new ArrayList<>();
    }
    
    
    public double getPesMaxim() {
		return pesMaxim;
	}


	public double getPesActual() {
		return pesActual;
	}


	public List<Vaca> getVaques() {
		return vaques;
	}

	public double getLitres() { 
    	return vaques.stream().mapToDouble(i -> i.getLitres()).sum();
    }

    public boolean entraVaca(Vaca vaca)
    {
        if (pesActual + vaca.getPes() > pesMaxim)
        {
            return false;
        }

        vaques.add(vaca);
        pesActual += vaca.getPes();
        return true;
    }

    public boolean treuVaca(Vaca vaca)
    {
        boolean resultat = vaques.remove(vaca);
        if (resultat) { pesActual -= vaca.getPes(); }
        return resultat;
    }

    @Override
    public String toString() {
    	return "Camio max: " + pesMaxim + "(" + pesActual + " - vaques: " + vaques.size();
    }
    
	public int litresEsParell()
	{
		int parell=1;
		if (((int) getLitres())%2==1)
			parell=-1;
		return parell;
	}

}
