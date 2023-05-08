import javax.swing.*;
import java.awt.*;

public class Item extends JFrame {
    private JLabel idLabel, titleLabel, descriptionLabel, locationLabel;
    private JTextField idField, titleField, descriptionField, locationField;
    private JButton searchButton, addButton, updateButton, deleteButton;

    public Item() {
        super("Item Information");

        idLabel = new JLabel("ID#:");
        titleLabel = new JLabel("Title:");
        descriptionLabel = new JLabel("Description:");
        locationLabel = new JLabel("Location:");

        idField = new JTextField(20);
        titleField = new JTextField(20);
        descriptionField = new JTextField(25);
        locationField = new JTextField(20);

        searchButton = new JButton("Enter");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(idLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(idField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(titleLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(titleField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(locationLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(locationField, c);
        
        c.gridx = 0;
        c.gridy = 3;
        panel.add(descriptionLabel, c);
        
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        panel.add(descriptionField, c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        panel.add(searchButton, c);

        c.gridx = 1;
        c.gridy = 6;
        panel.add(addButton, c);

        c.gridx = 0;
        c.gridy = 7;
        panel.add(updateButton, c);

        c.gridx = 1;
        c.gridy = 7;
        panel.add(deleteButton, c);

        add(panel);

        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Item();
    }
}