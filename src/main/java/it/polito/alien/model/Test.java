package it.polito.alien.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Dizionario d = new Dizionario();
		List<String> ls = new ArrayList<String>();
		ls.add("puzza");
		ls.add("profuma poco");
		d.addParola("daniele", ls);		//TEST AGGIUNTA MULTIPLA
		System.out.println(d.cercaParola("daniele"));

	}

}
