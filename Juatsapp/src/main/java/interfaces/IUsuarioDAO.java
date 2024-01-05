
package interfaces;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IUsuarioDAO {
    
    public Usuario createUsuario(Usuario usuario);
    
    public Usuario readUsuario(Usuario usuario);
    
    public Usuario updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
    
    public List<Usuario> readAllUsuario();
}
