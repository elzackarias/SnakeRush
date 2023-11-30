import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

// También cuando se obtenga un nuevo record global se tenga que organizar, es decir cuando se actualice el puntaje

public class Archivo extends JugadorObject {
    // Tenemos los arreglos de jugadores aquí, uno en forma de lista para poder
    // agregarle nuevos jugadores más facilmente y otro en forma de arreglo para
    // poder manipular la información que contiene cada jugador
    private static List<JugadorObject> listaJugadores = new ArrayList<>();
    private static JugadorObject[] jugadoresData;

    // Funcion que permite guardar los jugadores en un archivo serializable dentro
    // de la carpeta data en el archivo dataBase.ser
    public static void guardarObjetos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data\\dataBase.ser"))) {
            oos.writeObject(jugadoresData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funcion que permite que se recuperen los objetos del mismo archivo
    // dataBase.ser y los guarda dentro de la lista y el arreglo estático de esta
    // clase para poder manipular sus datos
    public static void recuperarObjetos() {
        JugadorObject[] listaRecuperada = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data\\dataBase.ser"))) {
            listaRecuperada = (JugadorObject[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        jugadoresData = listaRecuperada;
        listaJugadores = Arrays.asList(jugadoresData);
        organizarObjetos();
    }

    // Funcion que organiza los jugadores por puntaje siendo el de mayor puntaje el
    // primero (0) y tambien guarda la lista ordenada (bubble sort)
    public static void organizarObjetos() {
        JugadorObject temp;
        int n = listaJugadores.size();
        boolean intercambiado;

        do {
            intercambiado = false;

            for (int i = 1; i < n; i++) {
                if (Integer.parseInt(jugadoresData[i - 1].getPuntaje()) < Integer
                        .parseInt(jugadoresData[i].getPuntaje())) {
                    temp = jugadoresData[i - 1];
                    jugadoresData[i - 1] = jugadoresData[i];
                    jugadoresData[i] = temp;
                    intercambiado = true;
                }
            }
            n--;
        } while (intercambiado);
        listaJugadores = Arrays.asList(jugadoresData);
    }

    // Funcion que agrega un jugador a la lista actual dados su usario y contraseña
    // y lo guarda también en el serializable, sin ordenar pero no hay problema al
    // hacer eso pues al recuperar los jugadores se ordenan
    public static void agregarJugador(String usuario, String contrasenia) {
        listaJugadores.add(new JugadorObject(usuario, contrasenia));
        jugadoresData = listaJugadores.toArray(new JugadorObject[20]);
        guardarObjetos();
    }

    // Funcion que comprueba si las credenciales existen dentro de los jugadores
    // dados un usuario y contraseña, devuelve true si dichas credenciales
    // ingresadas ecisten y false si no
    public static boolean comprobarCredenciales(String usuario, String contrasenia) {
        int n = listaJugadores.size();
        for (int i = 0; i < n; i++) {
            if (usuario.equals(jugadoresData[i].getUsuario())) {
                if (contrasenia.equals(jugadoresData[i].contrasenia)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Función que permite actualizar el puntaje de un usuario dado su nombre y el
    // nuevo puntaje
    public static void actualizarPuntaje(String usuario, String puntaje) {
        int n = listaJugadores.size();
        for (int i = 0; i < n; i++) {
            if (usuario.equals(jugadoresData[i].getUsuario())) {
                jugadoresData[i].setPuntaje(puntaje);
            }
        }
        organizarObjetos();
    }

    // Función que permite leer el puntaje de un usuario dado su nombre
    public static String leerPuntaje(String usuario) {
        int n = listaJugadores.size();
        for (int i = 0; i < n; i++) {
            if (usuario.equals(jugadoresData[i].getUsuario())) {
                return jugadoresData[i].getPuntaje();
            }
        }
        return "0";
    }
}
