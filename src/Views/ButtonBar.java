package Views;

import javax.swing.*;

public class ButtonBar extends JPanel {
    private JButton addButton;
    private JButton clearButton;
    private JButton sortButton;
    private JComboBox<String> sortOptions;

    public ButtonBar() {
        addButton = new JButton();
        clearButton = new JButton();
        sortButton = new JButton();
        sortOptions = new JComboBox<>(new String[] {"Name", "Priority", "Status"} );



    }
}
