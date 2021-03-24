/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary model;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboLingua"
    private ComboBox<String> comboLingua; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea"
    private TextArea txtArea; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtAreaWrong"
    private TextArea txtAreaWrong; // Value injected by FXMLLoader

    @FXML // fx:id="lblErrori"
    private Label lblErrori; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearAll"
    private Button btnClearAll; // Value injected by FXMLLoader

    @FXML // fx:id="lblTempo"
    private Label lblTempo; // Value injected by FXMLLoader

   

    @FXML
    void doSpellCheck(ActionEvent event) {
    	double tempo=(double) System.nanoTime();
    	String testo= txtArea.getText();
    	testo= testo.toLowerCase();
    	testo= testo.replaceAll("“[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	
    	StringTokenizer parole= new StringTokenizer(testo," ");

    	ArrayList<String> listaParole= new ArrayList<String>();
    	while(parole.hasMoreTokens()) {
    		listaParole.add(parole.nextToken());
    	}
    	this.model.loadDictionary((String)comboLingua.getValue());
    	ArrayList<String> paroleErrate= new ArrayList<String>();
    	String s="";
    	for (String parola:paroleErrate) {
    		s+=parola+"\n";
    	}
    	

    	double tempo2= System.nanoTime();
    	lblErrori.setText("The text contains"+paroleErrate.size()+"errors");
    	txtAreaWrong.setText(s);
    	lblTempo.setText("Spell check completed in"+((tempo2-tempo)/1e9)+"secondi");
        
    }
    
    @FXML
    void doClear(ActionEvent event) {
    	txtArea.clear();
    	txtAreaWrong.clear();
    	lblTempo.setText("Tempo");
    	lblErrori.setText("Numero Errori");
    
    }
    
    public void setModel(Dictionary model2) {
    	this.model=model2;
    	String lingue[]={"English","Italian"};
    	comboLingua.getItems().addAll(lingue);
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert comboLingua != null : "fx:id=\"comboLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaWrong != null : "fx:id=\"txtAreaWrong\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblTempo != null : "fx:id=\"lblTempo\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

