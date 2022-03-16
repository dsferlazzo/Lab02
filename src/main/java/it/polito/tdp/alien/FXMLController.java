package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

import it.polito.alien.model.Dizionario;
import it.polito.alien.model.PAliena;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario model;

    @FXML
    private TextField txtParola;	//DA CONVERTIRE IN MINUSCOLO

    @FXML
    private TextArea txtTraduzioni;

    @FXML
    void handleClearText(ActionEvent event) {
    	txtTraduzioni.clear();
    	txtParola.clear();

    }

    @FXML
    void handleTranslate(ActionEvent event) {	//ERRORI DI INPUT DA GESTIRE
    	String s = txtParola.getText().toLowerCase();	//CONVERTITO IN MINUSCOLO
    	txtParola.clear();
    	
    	//CONTROLLO SUL FORMATO DELLA STRINGA
    	int flWildCard=0;
    	for(int i = 0;i<s.length();i++)
    	{	//CONTROLLO CHE NON CI SIANO CARATTERI NON VALIDI
    		Character c = s.charAt(i);
    		if(!Character.isAlphabetic(c) && c!=' ' && c!='?')
    		{
    			txtTraduzioni.appendText("ERRORE: formato della stringa inserita errato\n");
    			return;
    		}
    		if(c=='?')
    			flWildCard++;
    	}
    	if(flWildCard>1)
    	{	//NON POSSO RICHIEDERE TRADUZIONE DI PAROLA CON PIU DI UN '?'
    		txtTraduzioni.appendText("ERRORE: formato della stringa inserita errato\n");
			return;
    	}
    	if(s.contains("?") && s.contains(" "))
    	{	//NON POSSO INSERIRE PAROLA CON ? NEL DIZIONARIO
    		txtTraduzioni.appendText("ERRORE: formato della stringa inserita errato\n");
			return;
    	}
    	
    	
    	
    	String array[] = s.split(" ");
    	
    	if(array.length==1)	//GESTISCI TRADUZIONE, DA MODIFICARE CAUSA AGGIUNTA WILDCARD
    	{
    		try {
    			List<PAliena> lpa = model.cercaParola(s);
    			
    			for(int i = 0;i<lpa.size();i++)
    			{
    				txtTraduzioni.appendText(lpa.get(i).toString());
    			}
    			
    		//txtTraduzioni.appendText(model.cercaParola(s).toString());
    		} catch (NullPointerException npe ) //GESTISCO PAROLA NON TROVATA
    		{
    			txtTraduzioni.appendText("Traduzione non trovata\n");
    			
    		}	
    		return;
    	}
    	
    	//GESTISCI INSERIMENTO PAROLA, IDENTICA A METODO SENZA WILDCARD
    	
    	List<String> trad = new ArrayList<String>();
    	for(int i = 1;i<array.length;i++)
    	{
    		trad.add(array[i]);
    	}
    	model.addParola(array[0], trad);
    	

    }
    
    public void setModel(Dizionario model) {
    	this.model=model;
    }

}
