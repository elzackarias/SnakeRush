import controller.LoginController;
import fonts.Fonts;
import model.LoginModel;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginController controller = new LoginController();
        LoginView view = new LoginView(controller);
        LoginModel model = new LoginModel();
        controller.setModel(model);
        controller.setView(view);
        Fonts fontLoader = new Fonts();
        fontLoader.loadAndRegisterFonts();
        view.setVisible(true);
       }
}
