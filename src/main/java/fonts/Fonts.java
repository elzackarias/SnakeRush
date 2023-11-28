package fonts;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Fonts {
    public void loadAndRegisterFonts() {
        // Rutas a tus fuentes personalizadas
        String SFBold = "src/main/java/fonts/SF-Pro-Display-Bold.otf";
        String SFMedium = "src/main/java/fonts/SF-Pro-Display-Medium.otf";
        String SFRegular = "src/main/java/fonts/SF-Pro-Display-Regular.otf";
        String SFSemibold = "src/main/java/fonts/SF-Pro-Display-Semibold.otf";

        loadAndRegisterFont(SFBold);
        loadAndRegisterFont(SFMedium);
        loadAndRegisterFont(SFRegular);
        loadAndRegisterFont(SFSemibold);
    }

    private void loadAndRegisterFont(String fontPath) {
        try {
            File fontFile = new File(fontPath);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 12);
            // Registra la fuente en el entorno gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            System.out.println("Fuente cargada: " + fontFile.getName());
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}