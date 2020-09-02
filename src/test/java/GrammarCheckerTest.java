import edu.eci.arsw.springdemo.EnglishSpellChecker;
import edu.eci.arsw.springdemo.GrammarChecker;
import edu.eci.arsw.springdemo.SpanishSpellChecker;
import edu.eci.arsw.springdemo.SpellChecker;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GrammarCheckerTest {

    SpellChecker esc = new EnglishSpellChecker();

    SpellChecker ssc = new SpanishSpellChecker();

    @Test
    public void debeMainSpanish(){
        String text = "la la la ";
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        GrammarChecker gc = ac.getBean(GrammarChecker.class);
        StringBuffer result = new StringBuffer();
        StringBuffer expected=new StringBuffer();

        result.append(gc.check(text));

        expected.append("Spell checking output :"+ssc.checkSpell(text)+"\n");
        expected.append("Plagiarism checking output: Not available yet");
        Assert.assertEquals(expected.toString(),result.toString());

    }

    @Test
    public void noDebeMainSpanish(){
        String text = "la la la ";
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        GrammarChecker gc = ac.getBean(GrammarChecker.class);
        StringBuffer result = new StringBuffer();
        StringBuffer expected=new StringBuffer();

        result.append(gc.check(text));

        expected.append("Spell checking output :"+esc.checkSpell(text)+"\n");
        expected.append("Plagiarism checking output: Not available yet");
        Assert.assertNotEquals(expected.toString(),result.toString());

    }

    @Test
    public void debeRealizarSpanishCheck(){
        String hola = ssc.checkSpell("Hola");
        Assert.assertEquals(hola,"revisando (Hola) con el verificador de sintaxis del espanol");

    }

    @Test
    public void debeRealizarEnglishCheck(){
        String hola = esc.checkSpell("Hi");
        Assert.assertEquals(hola,"Checked with english checker:Hi");
    }


}
