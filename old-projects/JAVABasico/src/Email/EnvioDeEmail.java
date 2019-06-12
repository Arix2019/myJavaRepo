/*
 * enviar email sem formatação sem anexo
 */
package Email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Arix
 */
public class EnvioDeEmail {
    
    public static void main(String[] args){
        
        String msg = "Teste envio de email - JavaMail.";
        SimpleEmail email = new SimpleEmail();
        email.setSSLOnConnect(true);
        email.setHostName("smtp.gmail.com"); 
        email.setSslSmtpPort("25");
        email.setAuthenticator(new DefaultAuthenticator("arix0001@gmail.com",""));
        try {
            email.setFrom("arix0001@gmail.com");
            email.setDebug(true);
            email.setSubject("Teste JavaMail");
            email.setMsg(msg);
            email.addTo("arb.contato@hotmail.com");
            
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        
    }

}
