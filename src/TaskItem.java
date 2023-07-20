import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskItem extends JPanel {
    private JCheckBox isDoneBox;
    private JTextPane taskDescription;
    private JComboBox priorityComboBox;
    private JButton deleteButton;
    private JPanel containerPanel;
    private boolean isDone;
    private Priority priority;

    public TaskItem(JPanel givenContainerPanel) {
        this.containerPanel = givenContainerPanel;
        this.isDone = false;
        this.priority = Priority.LOW;
        this.setBackground(new Color(237, 237, 142));
        initializeTaskItem(givenContainerPanel);
    }

    public void initializeTaskItem(JPanel givenContainerPanel) {
        //task description:
        this.taskDescription = new JTextPane();
        taskDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskDescription.setPreferredSize(new Dimension(310, 50));
        taskDescription.setContentType("text/html");
        taskDescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                taskDescription.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskDescription.setBackground(null);
                reColor();
                /*if(isDone) {
                    taskDescription.setBackground(new Color(108, 173, 108));

                }*/
            }
        });


        //is Done checkbox:
        this.isDoneBox = new JCheckBox();
        isDoneBox.setPreferredSize(new Dimension(20, 20));
        isDoneBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        isDoneBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!isDoneBox.isSelected()) {
                    isDone = false;
                }
                else {
                    isDone = true;
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
                priority = (Priority) priorityComboBox.getSelectedItem();
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
            }
        });


        //add them to the panel:
        add(taskDescription);
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
        if(isDone) {
            this.setBackground(new Color(108, 173, 108));
        }
        else {
            if(priority.equals(Priority.LOW)) {
                this.setBackground(new Color(237, 237, 142));
            }
            else if (priority.equals(Priority.MEDIUM)) {
                this.setBackground(new Color(224, 171, 90));
            }
            else if (priority.equals(Priority.HIGH)) {
                this.setBackground(new Color(194, 84, 56));
            }
        }
    }


    //getters and setters:
    public boolean getIsDone() { return this.isDone; }
    public JTextPane getTaskDescription() { return this.taskDescription; }
}
