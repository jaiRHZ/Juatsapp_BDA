
package factoryDAO;

import conexionBD.ConexionBD;
import conexionBD.IConexionBD;
import implementacionDAO.ChatDAO;
import implementacionDAO.MensajeDAO;
import implementacionDAO.UsuarioDAO;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class FactoryDAO implements IFactoryDAO{
    
    private IConexionBD conexion;

    public FactoryDAO() {
        this.conexion = new ConexionBD();
    }
    
    
    @Override
    public UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAO(conexion);
    }

    @Override
    public ChatDAO createChatDAO() {
        return new ChatDAO(conexion);
    }

    @Override
    public MensajeDAO createMensajeDAO() {
        return new MensajeDAO(conexion);
    }
    
}
