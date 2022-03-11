package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

import it.polito.alien.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	List<Parola> lp = new ArrayList<Parola>();

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtWord;

    @FXML
    void handleClearText(ActionEvent event) {
    	txtArea.clear();

    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String s = txtWord.getText().toLowerCase();
    	txtWord.clear();
    	
    	for(int i = 0;i<s.length();i++)
    	{
    		if(!Character.isAlphabetic(s.charAt(i)) && s.charAt(i)!=' ')
    		{
    			txtArea.setText(txtArea.getText() + "\nFormato Errato");
    			return;
    		}
    			
    	}
    	
    	
    	if(s.contains(" "))
    	{		//GESTISCO INSERIMENTO PAROLA
    		String array[] = s.split(" ");
    		if(array.length>2)
    		{
    			txtArea.setText(txtArea.getText() + "\nFormato Errato");
    			return;
    		}
    		lp.add(new Parola(array[0],array[1]));
    		System.out.println(array[0] + "       " + array[1]);
    		return;
    		
    	}
    	
    	//GESTISCO RICHIESTA DI TRADUZIONE
    	for(int i = 0;i<lp.size();i++)
    	{
    		if(lp.get(i).getpAliena().compareTo(s)==0)
    		{
    			txtArea.setText(txtArea.getText()+ "\n" + lp.get(i).getpUmana());
    			return;
    		}
    	}
    	txtArea.setText(txtArea.getText() + "\nNessuna traduzione trovata");

    }

}
