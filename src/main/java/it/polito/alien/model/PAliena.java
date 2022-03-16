package it.polito.alien.model;

import java.util.List;

public class PAliena {
	
	private String parola;
	private List<String> traduzioni;
	public PAliena(String parola, List<String> traduzioni) {
		super();
		this.parola = parola;
		this.traduzioni = traduzioni;
	}
	
	
	public String getParola() {
		return parola;
	}
	public List<String> getTraduzioni() {
		return traduzioni;
	}
	
	public String getTraduzione(int i){
		return traduzioni.get(i);
	}


	@Override
	public String toString() {
		String s="";
		for(String p:traduzioni)
		{
			s+= this.parola + " --> " + p + "\n";
		}
		return s;
	}
	
	
	
	

	
	

}
