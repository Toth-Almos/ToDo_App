import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskItem extends JPanel {
    private JCheckBox isDoneBox;
    private JTextPane taskDescription;
    private JButton deleteButton;
    private JPanel containerPanel;
    private boolean isDone;

    public TaskItem(JPanel givenContainerPanel) {
        this.containerPanel = givenContainerPanel;
        this.isDone = false;
        initializeTaskItem(givenContainerPanel);
    }

    public void initializeTaskItem(JPanel givenContainerPanel) {
        //task description:
        this.taskDescription = new JTextPane();
        taskDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskDescription.setPreferredSize(new Dimension(335, 50));
        taskDescription.setContentType("text/html");
        taskDescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                taskDescription.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskDescription.setBackground(null);
                if(isDone) {
                    taskDescription.setBackground(new Color(108, 173, 108));
                }
            }
        });


        //is Done checkbox:
        this.isDoneBox = new JCheckBox();
        isDoneBox.setPreferredSize(new Dimension(40, 50));
        isDoneBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        isDoneBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!isDoneBox.isSelected()) {
                    isDone = false;
                    taskDescription.setBackground(Color.WHITE);
                }
                else {
                    isDone = true;
                    taskDescription.setBackground(new Color(108, 173, 108));
                }
            }
        });
        /*isDoneBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isDoneBox.isSelected()) {
                    isDone = false;
                    taskDescription.setBackground(Color.WHITE);
                }
                else {
                    isDone = true;
                    taskDescription.setBackground(new Color(108, 173, 108));
                }

                isDoneBox.getParent().revalidate();
                containerPanel.revalidate();
            }
        });*/


        //delete button:
        this.deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(80, 50));
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
        add(deleteButton);
    }


    //delete operation:
    public void deleteTask() {
        containerPanel.remove(this);
        containerPanel.repaint();
        containerPanel.revalidate();
    }


    //getters and setters:
    public boolean getIsDone() { return this.isDone; }
    public JTextPane getTaskDescription() { return this.taskDescription; }
}
