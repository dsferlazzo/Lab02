package it.polito.alien.model;

import java.util.HashSet;
import java.util.Set;

public class Parola {
	
	String pAliena;
	String pUmana;
	
	Set<String> listaPUmane;
	
	
	public Parola(String pAliena, HashSet<String> hs) {
		super();
		this.pAliena = pAliena;
		this.listaPUmane = hs;
		
	}


	public String getpAliena() {
		return pAliena;
	}



	public Set<String> getpUmana() {
		return listaPUmane;
	}


	
	

}
