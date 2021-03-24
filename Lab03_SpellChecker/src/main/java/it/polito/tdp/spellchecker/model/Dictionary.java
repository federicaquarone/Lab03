package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	private List <String> dizionario= new LinkedList<String>();
	
	public void loadDictionary(String language) {
		dizionario.clear();
		try {
			FileReader fr = new FileReader("src/main/resources/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionario.add(word);
			
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		LinkedList<RichWord> paroleErrate=new LinkedList<RichWord>();
		for( String word: inputTextList) {
			if (!dizionario.contains(word)) {
				RichWord rw= new RichWord(word,false);
				paroleErrate.add(rw);
			}
		}
		return paroleErrate;
	}

}
