package fachadaDAO;

import dominio.Chat;
import dominio.Mensaje;
import dominio.Usuario;
import factoryDAO.FactoryDAO;
import factoryDAO.IFactoryDAO;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class FachadaDAO implements IFachadaDAO {

    IFactoryDAO iFactoryDAO;

    public FachadaDAO() {
        this.iFactoryDAO = new FactoryDAO();
    }

    @Override
    public Chat createChat(Chat chat) {
        return iFactoryDAO.createChatDAO().createChat(chat);
    }

    @Override
    public Chat readChat(Chat chat) {
        return iFactoryDAO.createChatDAO().readChat(chat);
    }

    @Override
    public List<Chat> readAllChat() {
        return iFactoryDAO.createChatDAO().readAllChat();
    }

    @Override
    public Mensaje createMensaje(Mensaje mensaje) {
        return iFactoryDAO.createMensajeDAO().createMensaje(mensaje);
    }

    @Override
    public Mensaje readMensaje(Mensaje mensaje) {
        return iFactoryDAO.createMensajeDAO().readMensaje(mensaje);
    }

    @Override
    public void deleteMensaje(Mensaje mensaje) {
        iFactoryDAO.createMensajeDAO().deleteMensaje(mensaje);
    }

    @Override
    public List<Mensaje> readAllMensaje() {
        return iFactoryDAO.createMensajeDAO().readAllMensaje();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return iFactoryDAO.createUsuarioDAO().createUsuario(usuario);
    }

    @Override
    public Usuario readUsuario(Usuario usuario) {
        return iFactoryDAO.createUsuarioDAO().readUsuario(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return iFactoryDAO.createUsuarioDAO().updateUsuario(usuario);
    }

    @Override
    public List<Usuario> readAllUsuario() {
        return iFactoryDAO.createUsuarioDAO().readAllUsuario();
    }

    @Override
    public Chat updateChat(Chat chat) {
        return iFactoryDAO.createChatDAO().updateChat(chat);
    }

}
