import javax.swing.*;
import java.awt.*;

public class Student extends JFrame {
    private JLabel nameLabel, broncoIdLabel, courseLabel;
    private JTextField nameField, broncoIdField, courseField;
    private JButton searchButton, addButton, updateButton, deleteButton;

    public Student() {
        super("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 250);

        nameLabel = new JLabel("Name:");
        broncoIdLabel = new JLabel("Bronco ID:");
        courseLabel = new JLabel("Course:");

        nameField = new JTextField(20);
        broncoIdField = new JTextField(20);
        courseField = new JTextField(20);

        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(broncoIdLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(broncoIdField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(courseLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(courseField, c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(searchButton, c);

        c.gridx = 2;
        c.gridy = 3;
        panel.add(addButton, c);

        c.gridx = 3;
        c.gridy = 3;
        panel.add(updateButton, c);

        c.gridx = 4;
        c.gridy = 3;
        panel.add(deleteButton, c);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Student();
    }
}