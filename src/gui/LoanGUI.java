package gui;

import javax.swing.*;

import api.AuthorDAO;
import api.BookDAO;
import api.DirectorDAO;
import api.DocumentaryDAO;
import api.LoanDAO;
import domain.Author;
import domain.Director;

import java.awt.*;
import java.sql.Date;

@SuppressWarnings("serial")
public class LoanGUI extends JFrame {
    
    // components
    private JLabel loanNumberLabel, loanItemLabel, loanStudentLabel, loanStartLabel, loanEndLabel, loanReturnLabel, loanDaysLabel;
    private JTextField loanNumberField, loanItemField, loanStudentField, loanStartField, loanEndField, loanReturnField, loanDaysField;
    private JButton enterButton, searchButton, updateButton, deleteButton;
    private JTextArea receiptArea;
    private JRadioButton bookButton, documentaryButton;
    private ButtonGroup itemGroup;

    
    public LoanGUI() {
        // set up frame
        setTitle("Loan Management");
        setSize(800, 600);
        setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // create components
        loanNumberLabel = new JLabel("Loan Number: ");
        loanItemLabel = new JLabel("Loan Item Name: ");
        loanStudentLabel = new JLabel("Student Name: ");
        loanStartLabel = new JLabel("Start Date (yyyy-[m]m-[d]d): ");
        loanEndLabel = new JLabel("End Date (yyyy-[m]m-[d]d): ");
        loanReturnLabel = new JLabel("Return Date (yyyy-[m]m-[d]d): ");
        loanDaysLabel = new JLabel("Loan For How Many Days? ");
        
        loanNumberField = new JTextField(10);
        loanItemField = new JTextField(10);
        loanStudentField = new JTextField(10);
        loanStartField = new JTextField(10);
        loanEndField = new JTextField(10);
        loanReturnField = new JTextField(10);
        loanDaysField = new JTextField(10);
        
        enterButton = new JButton("Enter");
        searchButton = new JButton("Search");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        
        // Create radio buttons
        bookButton = new JRadioButton("Book");
        documentaryButton = new JRadioButton("Documentary");
        
        // Create item radio button group and add radio buttons
        itemGroup = new ButtonGroup();
        itemGroup.add(bookButton);
        itemGroup.add(documentaryButton);
        
        loanNumberField.setEnabled(false);
        
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
        add(loanStudentLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loanStudentField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(loanStartLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(loanStartField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(loanEndLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(loanEndField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(loanReturnLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(loanReturnField, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 5;
        add(bookButton, gbc);
           
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(loanDaysLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(loanDaysField, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 6;
        add(documentaryButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(enterButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(searchButton, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 7;
        add(updateButton, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 7;
        add(deleteButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        add(scrollPane, gbc);  
        
        // Create loan
        enterButton.addActionListener(e -> {
        	String itemName = loanItemField.getText();
            String studentName = loanStudentField.getText();
            Date startDate = Date.valueOf(loanStartField.getText());
            Date endDate = Date.valueOf(loanEndField.getText());
                  
            // check if book is selected, and when creating the loan, check if the item is on loan or not.
            if (bookButton.isSelected())
            {
            	 boolean success = LoanDAO.createLoan(itemName, studentName, startDate, endDate, true);
            	 
            	 if (!success)
            	 {
            		 JOptionPane.showMessageDialog(null, "Book: [" + itemName + "] is already on loan!");
                	 return;
            	 }
            		 
            	 JOptionPane.showMessageDialog(null, "Loan For Book: [" + itemName + "] successfully added.");
            	 clearFields();
            }
                      
            else if (documentaryButton.isSelected())
            {
            	boolean success = LoanDAO.createLoan(itemName, studentName, startDate, endDate, false);
            	
            	if (!success)
           	 	{
           		 JOptionPane.showMessageDialog(null, "Documentary: [" + itemName + "] is already on loan!");
               	 return;
           	 	}
            	
            	JOptionPane.showMessageDialog(null, "Loan For Documentary: [" + itemName + "] successfully added.");
           	 	clearFields();
            }
            
            else 
            {
            	JOptionPane.showMessageDialog(null, "ERROR: Please select Book or Documentary.");
            }  
        });
        
    }
    
	public void clearFields()
	{
		loanItemField.setText("");
		loanStudentField.setText("");
	    loanStartField.setText("");
	    loanEndField.setText("");
	    loanReturnField.setText("");
	    loanDaysField.setText("");
	    receiptArea.setText("");
	}
    
    public void showWindow()
	{
		setVisible(true);
	}
    
    public static void main(String[] args) {
        LoanGUI loanGUI = new LoanGUI();
        loanGUI.showWindow();
    }
}




