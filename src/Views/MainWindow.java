package Views;

import TaskData.Task;
import TaskData.TaskManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame mainFrame;
    private JPanel titleBar;
    private ButtonBar buttonBar;
    private JPanel taskPanel;
    private TaskManager allTasks;

    public MainWindow() {
        allTasks = new TaskManager();
        this.buttonBar = new ButtonBar();
        prepareWindow();
    }

    public void prepareWindow() {
        mainFrame = new JFrame("To Do App");
        mainFrame.setSize(450, 660);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setBackground(new Color(204, 0, 0));

        mainFrame.add(buttonBar, BorderLayout.NORTH);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
