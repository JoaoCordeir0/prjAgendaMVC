package br.com.prjagendamvc.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Android
 */
public class ValidaEmailAdapter implements IValidacaoEmail
{
    @Override
    public boolean validaEmail(String email) {
        String expression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(email);
       
        return matcher.matches();
    }    
}
