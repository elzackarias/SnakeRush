import java.io.Serializable;

public class JugadorObject implements Serializable {
    private String usuario, puntaje;
    protected String contrasenia;

    JugadorObject() {
        usuario = "usuario";
        contrasenia = "contrasenia";
        puntaje = "00000000";
    }

    JugadorObject(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        puntaje = "00000000";
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
