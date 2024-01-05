package dominio;

import dominio.Chat;
import dominio.Imagen;
import dominio.Usuario;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-01-05T15:14:29")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, String> texto;
    public static volatile SingularAttribute<Mensaje, Chat> chat;
    public static volatile SingularAttribute<Mensaje, Imagen> imagen;
    public static volatile SingularAttribute<Mensaje, Usuario> usuario;
    public static volatile SingularAttribute<Mensaje, Integer> id;
    public static volatile SingularAttribute<Mensaje, Calendar> fechaHoraRegistro;

}