package psweb.hangman.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import psweb.hangman.control.WordServices;

public class Hangman implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int chances = 6;
	private Word currentWord;
	private List<Character> history;
	
	public Hangman()
	{
		history = new ArrayList<Character>();
	}
	
	// Sorteia uma nova palavra
	public void reset()
	{
		reset(WordServices.buscarPalavra());
	}
	
	public void reset(Word palavra)
	{
		
		currentWord = new Word(palavra.getDescr_palavra());
		currentWord.setDica_palavra(palavra.getDica_palavra());
		chances = 6;
		history = new ArrayList<Character>();
	}
	
	// Faz input de um caractere
	public boolean input(char chr)
	{
		boolean match = currentWord.input(chr);				
		
		// Atualiza o contador de vidas
		if (!match)
			chances--;
		
		// Atualiza o histórico
		history.add(Character.toUpperCase(chr));
		
		return match;
	}
	
	public boolean isComplete()
	{
		return currentWord.isComplete();
	}	
	
	public boolean isGameOver()
	{
		return chances==0 || isComplete(); 
	}
	
	//
	// Métodos de acesso
	//
	public int getChances() {
		return chances;
	}
	
	public String getWordAsString() {
		return currentWord.getWordAsString();
	}
	
	public String getDicaAsString() {
		return currentWord.getDicaAsString();
	}
	
	public String getAnswerAsString() {
		return currentWord.getAnswerAsString();
	}
	
	public List<Character> getInputHistory() {
		return history;
	}
}
