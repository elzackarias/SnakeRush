public class TestRanking {
    public static void main(String[] args) {
        ModeloRanking modelo = new ModeloRanking();
        VistaRankings vista = new VistaRankings();
        ControladorRanking controlador = new ControladorRanking(vista, modelo);
        Archivo.recuperarObjetos();
        controlador.todosLosJugadores();
    }
}
