package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    		
    		
    		HashSet<String> lParole = new HashSet<String>();
    		
    		for(int i = 1;i<array.length;i++)
    		{
    			lParole.add(array[i]);
    		}
    		
    		lp.add(new Parola(array[0], lParole));
    		System.out.println(array[0] + "       " + array[1]);		//DEBUGGING
    		return;
    		
    	}
    	
    	//GESTISCO RICHIESTA DI TRADUZIONE
    	for(int i = 0;i<lp.size();i++)
    	{
    		if(lp.get(i).getpAliena().compareTo(s)==0)
    		{
    			
    			ArrayList<String> ls = new ArrayList<String>(lp.get(i).getpUmana());
    			
    			
    			for(int j = 0;j<ls.size();j++)
    			{
    				txtArea.setText(txtArea.getText()+ "\n" + ls.get(j));
    			}
    			
    			
    			return;
    		}
    	}
    	txtArea.setText(txtArea.getText() + "\nNessuna traduzione trovata");

    }

}
