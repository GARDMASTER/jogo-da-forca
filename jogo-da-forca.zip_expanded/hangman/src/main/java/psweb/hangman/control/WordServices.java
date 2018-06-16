package psweb.hangman.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import psweb.hangman.model.dao.GenericDAO;
import psweb.hangman.model.dao.PersistenceManager;
import psweb.hangman.model.entity.Word;

public class WordServices {

	public static Word buscarPalavra() {
		GenericDAO<Word> wordDAO = PersistenceManager.createGenericDAO(Word.class);
		List<Word> palavras = new ArrayList<Word>();
		Word palavra = null;
		
		Random gerador = new Random();

		palavras = wordDAO.buscarTodos();
		
		
		if(palavras.size() != 0) {
			Integer aux = gerador.nextInt(palavras.size()) + 1;
			
			
			
			System.out.println("aux:"+aux);
			
			palavra = palavras.get(aux);
			
			System.out.println(palavra.getDescr_palavra());
			System.out.println(palavra.getDica_palavra());
			
			return palavra;
		} else {
			
			return new Word("Hello");
			
		}
		
	}
	
	
}
