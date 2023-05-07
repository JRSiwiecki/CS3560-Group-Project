package gui;

import api.*;
import domain.*;

import javax.swing.*;

public class ItemGUI
{
	private JFrame frame;
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 600;
	
	// Generic item fields
	JTextField titleField;
    JTextField descriptionField;
    JTextField locationField;
    JTextField dailyPriceField;
    
    // Book fields
    JTextField pagesField;
    JTextField publisherField;
    JTextField publicationDateField;
    
    // Documentary fields
    JTextField lengthField;
    JTextField releaseDateField;
    
	public ItemGUI()
	{
		frame = new JFrame("Item Management");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Create components and add them to the JFrame
		JPanel panel = new JPanel();
		panel.setLayout(null);
        
        // Create labels
        JLabel titleLabel = new JLabel("Title");
        JLabel descriptionLabel = new JLabel("Description");
        JLabel locationLabel = new JLabel("Location");
        JLabel dailyPriceLabel = new JLabel("Daily Price");
        
        // Book related labels
        JLabel bookLabel = new JLabel("Book");
        JLabel pagesLabel = new JLabel("Pages");
        JLabel publisherLabel = new JLabel("Publisher");
        JLabel publicationDateLabel = new JLabel("Publication Date");
        
        // Documentary related labels
        JLabel documentaryLabel = new JLabel("Documentary");
        JLabel lengthLabel = new JLabel("Length");
        JLabel releaseDateLabel = new JLabel("Release Date");

        
        // Create text fields
        titleField = new JTextField(20);
        descriptionField = new JTextField(30);
        locationField = new JTextField(20);
        dailyPriceField = new JTextField(20);
        
        // Book related text fields
        pagesField = new JTextField(20);
        publisherField = new JTextField(20);
        
        // Documentary related text fields
        publicationDateField = new JTextField(20);
        lengthField = new JTextField(20);
        releaseDateField = new JTextField(20);
        
        // Create buttons
        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Add title components
        titleLabel.setBounds(25, 25, 100, 25); 
        titleField.setBounds(25, 50, 925, 25); 
        panel.add(titleLabel);
        panel.add(titleField);
        
        // Add description components
        descriptionLabel.setBounds(25, 100, 100, 25);
        descriptionField.setBounds(25, 125, 925, 25);
        panel.add(descriptionLabel);
        panel.add(descriptionField);
        
        // Add location components
        locationLabel.setBounds(25, 175, 100, 25);
        locationField.setBounds(25, 200, 450, 25);
        panel.add(locationLabel);
        panel.add(locationField);
        
        // Add daily price components
        dailyPriceLabel.setBounds(500, 175, 100, 25);
        dailyPriceField.setBounds(500, 200, 100, 25);
        panel.add(dailyPriceLabel);
        panel.add(dailyPriceField);
           
        
        // Add book components
        bookLabel.setBounds(25, 275, 100, 25);
        panel.add(bookLabel);
        
        // Add page components
        pagesLabel.setBounds(50, 300, 100, 25);
        pagesField.setBounds(50, 325, 250, 25);
        panel.add(pagesLabel);
        panel.add(pagesField);
        
        
        publisherLabel.setBounds(50, 375, 100, 25);
        publisherField.setBounds(50, 400, 250, 25);
        panel.add(publisherLabel);
        panel.add(publisherField);
        
        
        publicationDateLabel.setBounds(50, 450, 100, 25);
        publicationDateField.setBounds(50, 475, 250, 25);
        panel.add(publicationDateField);
        panel.add(publicationDateLabel);
          
        // Add documentary components
        documentaryLabel.setBounds(500, 275, 100, 25);
        panel.add(documentaryLabel);
        
        // Add length components
        lengthLabel.setBounds(525, 300, 100, 25);
        lengthField.setBounds(525, 325, 250, 25);
        panel.add(lengthLabel);
        panel.add(lengthField);
        
        // Add release date components
        releaseDateLabel.setBounds(525, 375, 100, 25);
        releaseDateField.setBounds(525, 400, 250, 25);
        panel.add(releaseDateLabel);
        panel.add(releaseDateField);
        
        
        // Add buttons to panel
        createButton.setBounds(575, 500, 75, 30);
        readButton.setBounds(675, 500, 75, 30);
        updateButton.setBounds(775, 500, 75, 30);
        deleteButton.setBounds(875, 500, 75, 30);
        panel.add(createButton);
        panel.add(readButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        
        frame.getContentPane().add(panel);

        
//        // Create item
//        createButton.addActionListener(e -> {
//        	String broncoId = broncoIdField.getText();
//            String name = nameField.getText();
//            String course = courseField.getText();
//            
//            StudentDAO.createStudent(broncoId, name, course);
//            
//            clearFields();
//            
//            JOptionPane.showMessageDialog(null, "Student: [" + name + "] successfully added.");
//        });
//        
//        // read item
//        readButton.addActionListener(e -> {
//        	String name = nameField.getText();
//        	
//        	Student tempStudent = StudentDAO.readStudent(name);
//        	
//        	if (tempStudent == null)
//        	{
//        		JOptionPane.showMessageDialog(null, "No student found!");
//        		return;
//        	}
//        	
//        	broncoIdField.setText(tempStudent.getBroncoId());
//        	nameField.setText(tempStudent.getName());
//        	courseField.setText(tempStudent.getCourse());    	
//        });
//        
//        // Update item
//        updateButton.addActionListener(e -> {
//        	Student tempStudent = new Student();
//            
//        	tempStudent.setBroncoId(broncoIdField.getText());
//        	tempStudent.setName(nameField.getText());
//        	tempStudent.setCourse(courseField.getText());
//            
//            StudentDAO.updateStudent(tempStudent);
//            
//            clearFields();
//            
//            JOptionPane.showMessageDialog(null, "Student: [" + tempStudent.getName() + "] successfully updated.");
//        });
//        
//        // Delete item
//        deleteButton.addActionListener(e -> {
//        	Student tempStudent = new Student();
//            
//            tempStudent.setBroncoId(broncoIdField.getText());
//            tempStudent.setName(nameField.getText());
//            tempStudent.setCourse(courseField.getText());
//     
//            StudentDAO.deleteStudent(tempStudent);
//            
//            clearFields();
//            
//            JOptionPane.showMessageDialog(null, "Student: [" + tempStudent.getName() + "] successfully deleted.");
//        });
    }
	
	public void showWindow()
	{
		frame.setVisible(true);
	}
	
	public void clearFields()
	{
		titleField.setText("");
	    descriptionField.setText("");
	    locationField.setText("");
	    dailyPriceField.setText("");
	    pagesField.setText("");
	    publisherField.setText("");
	    publicationDateField.setText("");
	    lengthField.setText("");
	    releaseDateField.setText("");
	}

	
	public static void main(String[] args)
	{
		ItemGUI itemGUI = new ItemGUI();
		itemGUI.showWindow();
	}
}
