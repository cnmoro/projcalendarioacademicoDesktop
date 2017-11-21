package calendarioacademico.utils;

import calendarioacademico.commons.Usuario;
import calendarioacademico.servicos.UsuarioManager;
import java.util.List;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author moro
 */
public class SendMail {

    public SendMail() {
    }
    
    public static void enviaEmail(String nivelAcesso) {
//        Thread thread = new Thread() {
//            public void run() {
                try {
                    Email email = new SimpleEmail();
                    email.setHostName("smtp.gmail.com");
                    email.setSmtpPort(587);
                    email.setAuthenticator(new DefaultAuthenticator("calendarioeventosbsi@gmail.com", "disciplinabsi"));
                    email.setTLS(true);
                    email.setFrom("calendarioeventosbsi@gmail.com");
                    email.setSubject("[ UTFPR - Calendário de Eventos ] Requisição de Acesso");
                    email.setMsg("O usuário '" + UsuarioManager.getUsuario().getLogin()
                                + "' está requisitando o privilégio de '" + nivelAcesso + "'.");
                    List<Usuario> users = EManager.getInstance().createNamedQuery("Usuario.findAdmin", Usuario.class).getResultList();
                    if (users.size() > 0) {
                        email.addTo(users.get(0).getEmail());
                        email.send();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }
//        };
//    thread.start();  
    }
}
