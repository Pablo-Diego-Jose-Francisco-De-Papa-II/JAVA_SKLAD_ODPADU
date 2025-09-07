package Zadanie6.Part2;


import javax.swing.*;
import java.awt.*;

public class GUI {

    private String fileName;
    private FileManager fileManager;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        // Creates the main window for the file manager
        JFrame frame = new JFrame("FileManager :3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);


        // Main text area
        JTextArea textEditor = new JTextArea();
        textEditor.setLineWrap(true);
        textEditor.setWrapStyleWord(true);
        textEditor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        JScrollPane scrollPane = new JScrollPane(textEditor);
        scrollPane.setBounds(10,60,715,395);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);


        // New file button and action listener
        JButton newFileButton = new JButton("New File");
        frame.add(newFileButton);
        newFileButton.setBounds(405,10,100,40);
        newFileButton.setBackground(Color.lightGray);
        newFileButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        newFileButton.addActionListener(e -> {
            if (fileName == null || fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a file name!");
                return;
            }

            fileManager = FileManager.createAndGetFile(fileName);
            if (fileManager == null) {
                try {
                    System.err.println("File already exists or can't be created!");
                } catch (RuntimeException ex) {
                    throw new RuntimeException(ex);
                }
            }

            textEditor.setText("");
        });


        // Open file button and action listener
        JButton openButton = new JButton("Open File");
        frame.add(openButton);
        openButton.setBounds(515,10,100,40);
        openButton.setBackground(Color.lightGray);
        openButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        openButton.addActionListener(e -> {
            if (fileName == null || fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a file name!");
                return;
            }

            fileManager = FileManager.openAndGetFile(fileName);
            if (fileManager == null) {
                try {
                    System.err.println("File does not exists!");
                } catch (RuntimeException ex) {
                    throw new RuntimeException(ex);
                }
            }
            StringBuilder text = new StringBuilder();
            for (String line : fileManager.readAll()) {
                text.append(line).append("\n");
            }

            textEditor.setText(text.toString());
        });


        // Save button and action listener
        JButton saveButton = new JButton("Save");
        frame.add(saveButton);
        saveButton.setBounds(625,10,100,40);
        saveButton.setBackground(Color.lightGray);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        saveButton.addActionListener(e -> {
            try {
                fileManager.write(textEditor.getText());
            } catch (NullPointerException ex) {
                System.err.println("No file is open!");
            }
        });


        // Label
        JLabel fileLabel = new JLabel("File Name: ");
        frame.add(fileLabel);
        fileLabel.setBounds(10,10,100,40);


        // Text field to write file name and action listener
        JTextField filePicker = new JTextField();
        frame.add(filePicker);
        filePicker.setBounds(75,10,320,40);
        filePicker.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        filePicker.addActionListener(e -> fileName = filePicker.getText());


        // Set visible
        frame.setVisible(true);
    }
}
