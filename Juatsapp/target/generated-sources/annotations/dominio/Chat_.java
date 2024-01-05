package dominio;

import dominio.Imagen;
import dominio.Mensaje;
import dominio.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-01-04T22:14:06")
@StaticMetamodel(Chat.class)
public class Chat_ { 

    public static volatile ListAttribute<Chat, Mensaje> mensajes;
    public static volatile SingularAttribute<Chat, Imagen> miniatura;
    public static volatile ListAttribute<Chat, Usuario> usuarios;
    public static volatile SingularAttribute<Chat, Long> idChat;
    public static volatile SingularAttribute<Chat, String> nombre;

}