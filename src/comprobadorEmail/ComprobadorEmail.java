package comprobadorEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobadorEmail {

	
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
    public boolean emailValido (String email) {
    	Matcher mather = pattern.matcher(email);
    	return (mather.find());
    }
}