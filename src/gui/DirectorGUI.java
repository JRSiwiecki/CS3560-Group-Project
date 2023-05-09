package gui;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class DirectorGUI extends JFrame {
    private JLabel directorIdLabel, nameLabel, nationalityLabel, styleLabel;
    private JTextField directorIdField, nameField, nationalityField, styleField;
    private JButton searchButton, addButton, updateButton, deleteButton;

    public DirectorGUI() {
        super("Director Management");
        
        setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        directorIdLabel = new JLabel("Director ID:");
		nameLabel = new JLabel("Name:");
        nationalityLabel = new JLabel("Nationality:");
        styleLabel = new JLabel("Style:");

        directorIdField = new JTextField(20);
        nameField = new JTextField(20);
        nationalityField = new JTextField(20);
        styleField = new JTextField(20);

        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        directorIdField.setEnabled(false);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(directorIdLabel, c);
        
        c.gridx = 1;
        c.gridy = 0;
        panel.add(directorIdField, c);
        
        c.gridx = 0;
        c.gridy = 1;
        panel.add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(nameField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(nationalityLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(nationalityField, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(styleLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(styleField, c);

        c.gridx = 2;
        c.gridy = 4;
        panel.add(searchButton, c);

        c.gridx = 3;
        c.gridy = 4;
        panel.add(addButton, c);

        c.gridx = 4;
        c.gridy = 4;
        panel.add(updateButton, c);

        c.gridx = 5;
        c.gridy = 4;
        panel.add(deleteButton, c);

        add(panel);

        setSize(800, 250);
        setLocationRelativeTo(null);
        setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public void showWindow()
	{
		setVisible(true);
	}

    public static void main(String[] args) {
        new DirectorGUI();
    }
}