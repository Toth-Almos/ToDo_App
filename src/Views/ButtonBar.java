package Views;

import javax.swing.*;

public class ButtonBar extends JPanel {
    private JButton addButton;
    private JButton clearButton;
    private JButton sortButton;
    private JComboBox<String> sortOptions;

    public ButtonBar() {
        this.setVisible(true);

        addButton = new JButton("Add Task");
        clearButton = new JButton("Clear Finished");
        sortButton = new JButton("Sort");
        sortOptions = new JComboBox<>(new String[] {"Name", "Priority", "Status"} );

        setBorder(BorderFactory.createEmptyBorder());

        this.add(addButton);
        this.add(clearButton);
        this.add(sortButton);
        this.add(sortOptions);

    }
}
