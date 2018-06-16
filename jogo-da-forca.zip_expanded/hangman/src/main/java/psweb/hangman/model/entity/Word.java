package psweb.hangman.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="palavras")
public class Word implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id_palavra;
	
	@Transient
	private char[] wordChars;
	
	@Transient
	private char[] wordMask;
	
	@Column
	private String descr_palavra;
	
	@Column
	private String dica_palavra;
	
	public Word() {
		
	}
	
	public Word(String word)
	{
		this.wordChars = word.toUpperCase().toCharArray();
		this.wordMask  = new char[wordChars.length];
		
		for (int i=0;i<wordMask.length;i++)
			wordMask[i] = '_';		
	}
	
	
	public boolean input(char chr)
	{
		chr = Character.toUpperCase(chr);
		
		boolean match = false;
		
		for (int i=0;i<wordChars.length;i++)
		{
			if (wordChars[i] == chr && wordMask[i] == '_')
			{
				match = true;
				wordMask[i] = chr;
			}									
		}
		
		return match;
	}

	public boolean isComplete()
	{
		for (int i=0;i<wordChars.length;i++)
		{
			if (wordMask[i] == '_')
			{
				return false;
			}									
		}
		
		return true;
	}
	
	public String getWordAsString()
	{
		return new String(wordMask);
	}
	
	public String getDicaAsString()
	{
		return new String(getDica_palavra());
	}

	
	public String getAnswerAsString()
	{
		return new String(wordChars);
	}


	public String getDescr_palavra() {
		return descr_palavra;
	}


	public void setDescr_palavra(String descr_palavra) {
		this.descr_palavra = descr_palavra;
	}


	public String getDica_palavra() {
		return dica_palavra;
	}


	public void setDica_palavra(String dica_palavra) {
		this.dica_palavra = dica_palavra;
	}	
	
	
}
