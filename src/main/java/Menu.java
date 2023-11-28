import javax.swing.*;
import components.*;
public class Menu extends JFrame {
    public PrimaryButton BtnPrim; //Componentes usuados del Github de Zacarias xD
    public SecondaryButton BtnSec;
    private JLabel tituloEtq, usuarioEtq, scoreEtq; // Etiquetas para cada parte de la ventana

    public Menu() {
        // Configuración del nombre de la ventanita
        setTitle("Menú");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Mostrar la ventanita en medio de la pantalla
        setLayout(null); // Sólo para la ventanita, habría que modificar manualmente por si se pone en pantalla completa

        // Uso de componentes
        tituloEtq = new JLabel("MENÚ");
        tituloEtq.setBounds(130, 1, 100, 30);
        add(tituloEtq);

        usuarioEtq = new JLabel("Usuario"); // Modificar con los archivos, la información de usuario y esas cosas :b
        usuarioEtq.setBounds(10, 10, 150, 30);
        add(usuarioEtq);

        scoreEtq = new JLabel("Score: 0"); // También modifcar esto y que el "0" sea puntuación por default 
        scoreEtq.setBounds(220, 10, 100, 30);
        add(scoreEtq);

        BtnPrim = new PrimaryButton("Iniciar sesión");
        BtnPrim.setBounds(70, 70, 150, 40);
        add(BtnPrim);

        BtnSec = new SecondaryButton("Ranking");
        BtnSec.setBounds(104, 120, 85, 30);
        add(BtnSec);

        setVisible(true); // "Activar" la visibilidad
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new); // Mostrar la ventana :000
    }
}
