import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainWindow extends JFrame {
    private JPanel taskItemList;
    private JPanel listContainer;
    private ArrayList<Task> taskList;

    public MainWindow() {
        super("To Do List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(570, 760));  //originally width was 540
        pack();
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(new Color(69, 69, 69));
        setLocationRelativeTo(null);
        setLayout(null);
        this.taskList = new ArrayList<Task>();

        this.initializeFrame();
    }

    public void initializeFrame() {
        this.taskItemList = new JPanel();
        this.listContainer = new JPanel();

        taskItemList.setLayout(new BoxLayout(taskItemList, BoxLayout.Y_AXIS));
        listContainer.add(taskItemList);
        listContainer.setBackground(new Color(156, 156, 156));

        //scroll:
        JScrollPane scrollPane = new JScrollPane(listContainer);
        scrollPane.setBounds(8, 10, 540, 585);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setMaximumSize(new Dimension(540, 585));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        //add new task button:
        JButton addNewTaskButton = new JButton("Add Task");
        addNewTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addNewTaskButton.setBounds(10, 630, 120, 50);
        addNewTaskButton.setFocusPainted(false);

        //clear finished button:
        JButton clearButton = new JButton("Clear Finished");
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.setBounds(140, 630, 120, 50);
        clearButton.setFocusPainted(false);

        //sort button:
        JButton sortButton = new JButton("Sort");
        sortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sortButton.setBounds(270, 630, 120, 50);
        sortButton.setFocusPainted(false);

        //add them to the frame:
        this.getContentPane().add(addNewTaskButton);
        this.getContentPane().add(clearButton);
        this.getContentPane().add(sortButton);
        this.getContentPane().add(scrollPane);

        //Action listeners:
        //add new task ActionListener:
        addNewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create new Task and TaskItem:
                Task newTask = new Task("", Priority.LOW);
                taskList.add(newTask);

                TaskItem newTaskItem = new TaskItem(taskItemList);
                newTaskItem.setTask(newTask);
                taskItemList.add(newTaskItem);


                //if there were any previous tasks, it loses the focus:
                if(taskItemList.getComponentCount() > 1) {
                    TaskItem previousTask = (TaskItem) taskItemList.getComponent((taskItemList.getComponentCount() - 2));
                    previousTask.getTaskDescription().setBackground(null);
                }

                //the new task gets the focus:
                newTaskItem.getTaskDescription().requestFocus();
                repaint();
                revalidate();
            }
        });

        //clear finished tasks ActionListener:
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //need to use iterator for delete:
                Iterator<Component> iterator = Arrays.stream(taskItemList.getComponents()).iterator();
                while (iterator.hasNext()) {
                    Component i = iterator.next();
                    if(((TaskItem) i).getTask().getIsDone()) {
                        ((TaskItem) i).deleteTask();
                    }
                }
            }
        });

        //sort button ActionListener:
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
    }
}
