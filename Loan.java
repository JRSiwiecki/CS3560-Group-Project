import javax.swing.*;
import java.awt.*;

public class Loan extends JFrame {
    
    // components
    private JLabel loanNumberLabel, loanItemLabel, loanDateLabel, loanDaysLabel;
    private JTextField loanNumberField, loanItemField, loanDateField, loanDaysField;
    private JButton enterButton, searchButton, deleteButton;
    private JTextArea receiptArea;
    
    public Loan() {
        // set up frame
        setTitle("Loan GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // create components
        loanNumberLabel = new JLabel("Loan Number: ");
        loanItemLabel = new JLabel("Loan Item: ");
        loanDateLabel = new JLabel("Date (MM/DD/YYYY): ");
        loanDaysLabel = new JLabel("Loan For How Many ? ");
        
        loanNumberField = new JTextField(10);
        loanItemField = new JTextField(10);
        loanDateField = new JTextField(10);
        loanDaysField = new JTextField(10);
        
        enterButton = new JButton("Enter");
        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete");
        
        receiptArea = new JTextArea(10, 40);
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        
        // set up layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(loanNumberLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(loanNumberField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(loanItemLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(loanItemField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(loanDateLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loanDateField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(loanDaysLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(loanDaysField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(enterButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(searchButton, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        add(deleteButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        add(scrollPane, gbc);
        
        // show frame
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Loan();
    }
}




