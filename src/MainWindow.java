import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel taskList;
    private JPanel listContainer;

    public MainWindow() {
        super("To Do List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(540, 760));
        pack();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        this.initializeFrame();
    }

    public void initializeFrame() {
        this.taskList = new JPanel();
        this.listContainer = new JPanel();

        this.taskList.setLayout(new BoxLayout(taskList, BoxLayout.Y_AXIS));

    }
}
