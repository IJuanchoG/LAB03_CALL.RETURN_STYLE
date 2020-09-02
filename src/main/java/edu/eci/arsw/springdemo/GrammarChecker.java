package edu.eci.arsw.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * The type Grammar checker.
 */
@Service
public class GrammarChecker {

	/**
	 * The Sc.
	 */
	@Autowired
	@Qualifier("SpanishSpell")
	SpellChecker sc;

	/**
	 * The X.
	 */
	String x;


	/**
	 * Gets spell checker.
	 *
	 * @return the spell checker
	 */
	public SpellChecker getSpellChecker() {
		return sc;
	}

	/**
	 * Sets spell checker.
	 *
	 * @param sc the sc
	 */
	public void setSpellChecker(SpellChecker sc) {
		this.sc = sc;
	}


	/**
	 * Check string.
	 *
	 * @param text the text
	 * @return the string
	 */
	public String check(String text){
		
		StringBuffer sb=new StringBuffer();
		sb.append("Spell checking output :"+sc.checkSpell(text)+"\n");
		sb.append("Plagiarism checking output: Not available yet");
		
		
		return sb.toString();
		
	}
	
	
}
