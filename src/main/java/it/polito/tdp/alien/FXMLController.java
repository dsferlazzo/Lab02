package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

import it.polito.alien.model.Dizionario;
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
    	
    	String array[] = s.split(" ");
    	
    	if(array.length==1)	//GESTISCI TRADUZIONE
    	{
    		try {
    		txtTraduzioni.appendText(model.cercaParola(s).toString());
    		} catch (NullPointerException npe ) //GESTISCO PAROLA NON TROVATA
    		{
    			txtTraduzioni.appendText("Traduzione non trovata\n");
    			
    		}	
    		return;
    	}
    	
    	//GESTISCI INSERIMENTO PAROLA
    	
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
