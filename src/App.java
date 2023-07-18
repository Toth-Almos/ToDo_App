import javax.swing.*;

public class App {
    public static void main(String[] args) {
        //MainWindow mw = new MainWindow();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
