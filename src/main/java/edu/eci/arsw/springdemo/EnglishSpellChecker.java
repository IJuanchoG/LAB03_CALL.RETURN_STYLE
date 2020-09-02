package edu.eci.arsw.springdemo;

import org.springframework.stereotype.Component;

/**
 * The type English spell checker.
 */
@Component("EnglishSpell")
public class EnglishSpellChecker implements SpellChecker {

	@Override
	public String checkSpell(String text) {		
		return "Checked with english checker:"+text;
	}

        
}
