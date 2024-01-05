package fachadaDAO;

import dominio.Chat;
import dominio.Mensaje;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IFachadaDAO {

    public Chat createChat(Chat chat);

    public Chat readChat(Chat chat);

    public List<Chat> readAllChat();

    public Chat updateChat(Chat chat);

    public Mensaje createMensaje(Mensaje mensaje);

    public Mensaje readMensaje(Mensaje mensaje);

    public void deleteMensaje(Mensaje mensaje);

    public List<Mensaje> readAllMensaje();

    public Usuario createUsuario(Usuario usuario);

    public Usuario readUsuario(Usuario usuario);

    public Usuario updateUsuario(Usuario usuario);

    public List<Usuario> readAllUsuario();

}
