import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;

public class TaskItem extends JPanel {
    private JCheckBox isDoneBox;
    private JComboBox priorityComboBox;
    private JButton deleteButton;
    private MainWindow mainWindow;
    private JPanel containerPanel;
    private Task task;

    public TaskItem(JPanel givenContainerPanel, MainWindow givenMainWindow, Task givenTask) {
        this.mainWindow = givenMainWindow;
        this.task = givenTask;
        this.containerPanel = givenContainerPanel;
        this.setBackground(new Color(237, 237, 142));
        initializeTaskItem(givenContainerPanel);

        //set isDone checkbox:
        if(this.task.getIsDone()) {
            checkCheckBox();
        }

        //set priority combo-box:
        setPriorityComboBoxToTaskPriority();
    }

    public TaskItem(JPanel givenContainerPanel, Task task) {
        this.containerPanel = givenContainerPanel;
        this.setBackground(new Color(237, 237, 142));
        initializeTaskItem(givenContainerPanel);
        this.task = task;
    }

    public void initializeTaskItem(JPanel givenContainerPanel) {
        //Task Name:
        JLabel taskNameLabel = new JLabel(task.getName());
        taskNameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        taskNameLabel.setPreferredSize(new Dimension(310, 50));
        taskNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //is Done checkbox:
        this.isDoneBox = new JCheckBox();
        isDoneBox.setPreferredSize(new Dimension(20, 20));
        isDoneBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        isDoneBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!isDoneBox.isSelected()) {
                    task.setIsDone(false);
                }
                else {
                    task.setIsDone(true);
                }
                reColor();
            }
        });


        //priority combo-box:
        Priority[] comboList = {Priority.LOW, Priority.MEDIUM, Priority.HIGH};
        this.priorityComboBox = new JComboBox<>(comboList);
        priorityComboBox.setPreferredSize(new Dimension(80, 30));
        priorityComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        priorityComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //we can cast it since the combo-box only contains Priority values:
                task.setPriority((Priority) priorityComboBox.getSelectedItem());
                reColor();
            }
        });


        //delete button:
        this.deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(70, 50));
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
                mainWindow.deleteTask(task);
            }
        });


        //add them to the panel:
        //add(taskDescription);
        add(taskNameLabel);
        add(isDoneBox);
        add(priorityComboBox);
        add(deleteButton);
    }


    //delete operation:
    public void deleteTask() {
        containerPanel.remove(this);
        containerPanel.repaint();
        containerPanel.revalidate();
    }

    //color changer method:
    public void reColor() {
        if(task.getIsDone()) {
            this.setBackground(new Color(108, 173, 108));
        }
        else {
            if(task.getPriority().equals(Priority.LOW)) {
                this.setBackground(new Color(237, 237, 142));
            }
            else if (task.getPriority().equals(Priority.MEDIUM)) {
                this.setBackground(new Color(224, 171, 90));
            }
            else if (task.getPriority().equals(Priority.HIGH)) {
                this.setBackground(new Color(194, 84, 56));
            }
        }
    }


    public void checkCheckBox() { this.isDoneBox.setSelected(true); }
    public void setPriorityComboBoxToTaskPriority() {
        this.priorityComboBox.setSelectedItem(this.task.getPriority());
    }

    //getters and setters:
    public Task getTask() { return this.task; }

    public void setTask(Task task) { this.task = task; }
}