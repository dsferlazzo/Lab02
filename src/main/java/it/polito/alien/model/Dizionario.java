package it.polito.alien.model;

import java.util.ArrayList;
import java.util.List;

public class Dizionario {
	
	List<PAliena> parole = new ArrayList<PAliena>();

	public List<PAliena> getParole() {
		return parole;
	}
	
	public void addParola(String parola, List<String> traduzioni) {
		//CONTROLLER DEVE TRASFORMARE STRINGA IN SINGOLE PARTI
		PAliena p = new PAliena (parola, traduzioni);
		parole.add(p);
	}
	
	public PAliena cercaParola(String parola) {
		
		for(PAliena pa:parole)
		{
			if(pa.getParola().equals(parola))
				return pa;
		}
		
	
		return null;		//ECCEZIONE DA GESTIRE IN CONTROLLER
	}

}
