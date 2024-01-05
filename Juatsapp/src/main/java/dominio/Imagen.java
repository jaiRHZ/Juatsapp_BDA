package dominio;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "imagen")
public class Imagen implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Lob // Utilizado para campos grandes, como datos binarios
    private byte[] datosImagen;

    public Imagen() {
    }

    public Imagen(String nombre, byte[] datosImagen) {
        this.nombre = nombre;
        this.datosImagen = datosImagen;
    }

    public Imagen(Long idImagen, String nombre, byte[] datosImagen) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.datosImagen = datosImagen;
    }

    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getDatosImagen() {
        return datosImagen;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }
}
