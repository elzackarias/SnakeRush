public class ControladorRanking {
    VistaRankings vista;
    ModeloRanking modelo;

    public ControladorRanking(VistaRankings vista, ModeloRanking modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void todosLosJugadores() {
        vista.crearJLabel("Jugador" + "   " + "Puntaje");
        for (int i = 0; i < 20; i++) {
            try {
                vista.crearJLabel(Archivo.getUsuarioByID(i) + "   " + Archivo.getPuntajeByID(i));
            } catch (NullPointerException e) {
                System.out.println("Ya no hay mas jugadores");
            }
        }
    }
}
