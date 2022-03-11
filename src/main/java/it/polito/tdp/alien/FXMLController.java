package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.HashSet;
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
    		if(!Character.isAlphabetic(s.charAt(i)) && s.charAt(i)!=' ' && s.charAt(i)!='?')
    		{
    			txtArea.setText(txtArea.getText() + "\nFormato Errato");
    			return;
    		}
    			
    	}
    	int flDomanda=0;
    	for(int i = 0;i<s.length();i++)
    	{
    		if(s.charAt(i)=='?')
    			flDomanda++;
    			
    	}
    	
    	if(flDomanda>1)
    	{
    		txtArea.setText(txtArea.getText() + "\nFormato Errato");
			return;
    	}
    	
    	
    	if(s.contains(" "))
    	{		//GESTISCO INSERIMENTO PAROLA
    		
    		if(s.contains("?"))
    		{
    			txtArea.setText(txtArea.getText() + "\nFormato Errato");
    			return;
    		}
    		
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
    	
    	
    	//GESTISCO PRESENZA DI '?'
    	if(s.contains("?"))
    	{
    		List<Parola> pTrovate = new ArrayList<Parola>();
    		for(int i = 0;i<lp.size();i++)
    		{
    			if(lp.get(i).getpAliena().length()==s.length())
    			{
	    			int flUguaglianza=1;
	    			String pAliena = lp.get(i).getpAliena();
	    			for(int j = 0;j<pAliena.length();j++)
	    			{
	    				if(pAliena.charAt(j)!=s.charAt(j) && s.charAt(j)!='?')
	    					flUguaglianza=0;	
	    			}
	    			if(flUguaglianza==1)
	    				pTrovate.add(lp.get(i));	
    			}	
    		}
    		
    		if(pTrovate.size()==0)
    		{
    			txtArea.setText(txtArea.getText() + "\nNessuna traduzione trovata");
    			return;
    		}
    		if(pTrovate.size()==1)
    		{
    			List<String> ls1 = new ArrayList<String>(pTrovate.get(0).getpUmana());
    			for(int j = 0;j<ls1.size();j++)
    			{
    				txtArea.setText(txtArea.getText()+ "\n" + ls1.get(j));
    			}
    			return;
    		}
    		if(pTrovate.size()>1)
    		{
    			txtArea.setText(txtArea.getText() + "\nPiù di una parola è stata trovata");
    			
    			for(int i = 0;i<pTrovate.size();i++)
    			{
    				List<String> ls1 = new ArrayList<String>(pTrovate.get(i).getpUmana());
        			for(int j = 0;j<ls1.size();j++)
        			{
        				txtArea.setText(txtArea.getText()+ "\n" +
        				pTrovate.get(i).getpUmana() + "///" + ls1.get(j));
        			}
    			}
    			return;
    		}
    	}
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
