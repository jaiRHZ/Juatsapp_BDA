
package factoryDAO;

import implementacionDAO.ChatDAO;
import implementacionDAO.MensajeDAO;
import implementacionDAO.UsuarioDAO;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IFactoryDAO {
    
    public UsuarioDAO createUsuarioDAO();
    
    public ChatDAO createChatDAO();
    
    public MensajeDAO createMensajeDAO();
}
