package calendarioacademico.servicos;

import calendarioacademico.commons.Usuario;

/**
 *
 * @author moro
 */
public class UsuarioManager {
    public static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioManager.usuario = usuario;
    }

    
}
