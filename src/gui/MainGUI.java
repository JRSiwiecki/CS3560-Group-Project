package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JFrame frame;
    private JPanel panel;

    private JButton authorButton;
    private JButton bookButton;
    private JButton directorButton;
    private JButton itemButton;
    private JButton loanButton;
    private JButton studentButton;

    public MainGUI() {
        frame = new JFrame("Main");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();

        authorButton = new JButton("Author");
//        authorButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AuthorGUI authorGUI = new AuthorGUI();
//                authorGUI.showWindow();
//            }
//        });

        bookButton = new JButton("Book");
//        bookButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                BookGUI bookGUI = new BookGUI();
//                bookGUI.showWindow();
//            }
//        });

        directorButton = new JButton("Director");
//        directorButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                DirectorGUI directorGUI = new DirectorGUI();
//                directorGUI.showWindow();
//            }
//        });

        itemButton = new JButton("Item");
//        itemButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ItemGUI itemGUI = new ItemGUI();
//                itemGUI.showWindow();
//            }
//        });

        loanButton = new JButton("Loan");
//        loanButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                LoanGUI loanGUI = new LoanGUI();
//                loanGUI.showWindow();
//            }
//        });

        studentButton = new JButton("Student");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentGUI studentGUI = new StudentGUI();
                studentGUI.showWindow();
            }
        });

        panel.add(authorButton);
        panel.add(bookButton);
        panel.add(directorButton);
        panel.add(itemButton);
        panel.add(loanButton);
        panel.add(studentButton);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void showWindow()
	{
		frame.setVisible(true);
	}
    
    public static void main(String[] args) {
        MainGUI mainGUI = new MainGUI();
        mainGUI.showWindow();
    }
}