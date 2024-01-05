package dominio;

import dominio.Chat;
import dominio.Imagen;
import dominio.Usuario;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-01-05T03:53:18")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, String> texto;
    public static volatile SingularAttribute<Mensaje, Chat> chat;
    public static volatile SingularAttribute<Mensaje, Imagen> imagen;
    public static volatile SingularAttribute<Mensaje, Usuario> usuario;
    public static volatile SingularAttribute<Mensaje, Integer> id;
    public static volatile SingularAttribute<Mensaje, Calendar> fechaHoraRegistro;

}