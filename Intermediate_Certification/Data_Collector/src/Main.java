import javax.swing.SwingUtilities;    // Ivanov Ivan Ivanovich 12.12.1990 9182552550 m
import controller.Controller;
import data.Data;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Controller controller = new Controller(data);
        UserView userView = new UserView(controller);
        SwingUtilities.invokeLater(() -> {
        userView.Init();
        });
        
    }
}
