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
	
	public List<PAliena> cercaParola(String parola) {	//DA MODIFICARE PER IMPLEMENTARE RICERCA CON WILDCARD
		List<PAliena> output = new ArrayList<PAliena>();
		for(PAliena pa:parole)
		{
			int pTrovata=0;
			String s = pa.getParola();
			if(s.length()==parola.length())
			{
				pTrovata=1;
				for(int i = 0;i<s.length();i++)
				{
					if(s.charAt(i)!=parola.charAt(i) && parola.charAt(i)!='?')
						pTrovata=0;
				}
				if(pTrovata==1)
					output.add(pa);
			}
		}
		
		if(output.size()>0)
		return output;		
		else return null;		//ECCEZIONE DA GESTIRE IN CONTROLLER
	}

}
