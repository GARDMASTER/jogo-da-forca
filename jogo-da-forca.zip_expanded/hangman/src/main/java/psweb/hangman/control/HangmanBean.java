package psweb.hangman.control;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import psweb.hangman.model.entity.Hangman;

@Component
@ManagedBean
@SessionScoped
public class HangmanBean extends _Bean implements Serializable
{    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//
	// Atributos
	//
	private Hangman hangman;
	
	//
	// Campos do Formulário
	//
	private String letter = "";
	
	//
	// Construtor
	//
	public HangmanBean()
	{
		this.hangman = new Hangman();
		this.hangman.reset();
	}
	
	//
	// Operações
	//
	public void guess()
	{
		char chr = letter.toCharArray()[0];
		hangman.input(chr);
		letter = "";
	}
	
	public void reset()
	{
		hangman.reset();
		letter = "";
	}
	
	//
	// Métodos de Acesso
	//
	public String getWord()
	{
		return hangman.getWordAsString();
	}
	
	public String getDica()
	{
		return hangman.getDicaAsString();
	}
	
	public Integer getChances()
	{
		return hangman.getChances();
	}
	
	public String getAttempts()
	{
		return hangman.getInputHistory().toString();
	}
	
	public boolean isGameOver()
	{
		return hangman.isGameOver();
	}
	
	public boolean isGameWin()
	{
		return hangman.isComplete();
	}
	
	public boolean isGameLose()
	{
		return hangman.getChances()==0;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public String getImage() {
		
		int count = this.hangman.getChances();
		
		if(count == 6) {
			return "forca-gg.png";
		} else if (count == 5) {
			return "forca-gg02.png";
		} else if (count == 4){
			return "forca-gg03.png";
		} else if (count == 3){
			return "forca-gg04.png";
		} else if (count == 2){
			return "forca-gg05.png";
		} else if (count == 1){
			return "forca-gg06.png";
		} else{
			return "forca-gg07.png";
		}
		
	}
}  



