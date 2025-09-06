package Zadanie6.Part2;


import javax.swing.*;

public class GUI {

    private String fileName;
    private FileManager fileManager;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        JFrame frame = new JFrame("FileManager :3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        JTextField textEditor = new JTextField();
        frame.add(textEditor);
        textEditor.setBounds(10,60,715,395);

        textEditor.addActionListener(e -> {

        });

        JButton newFileButton = new JButton("New File");
        frame.add(newFileButton);
        newFileButton.setBounds(405,10,100,40);

        newFileButton.addActionListener(e -> {
            if (fileName == null || fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a file name!");
                return;
            }

            fileManager = FileManager.openAndGetFile(fileName);
        });

        JButton openButton = new JButton("Open File");
        frame.add(openButton);
        openButton.setBounds(515,10,100,40);

        openButton.addActionListener(e -> {
            if (fileName == null || fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a file name!");
                return;
            }

            fileManager = FileManager.openAndGetFile(fileName);
            assert fileManager != null;
            textEditor.setText(fileManager.readAll()[0]);
        });

        JButton saveButton = new JButton("Save");
        frame.add(saveButton);
        saveButton.setBounds(625,10,100,40);

        saveButton.addActionListener(e -> {
            fileManager.write(textEditor.getText());
        });

        JLabel fileLabel = new JLabel("File Name: ");
        frame.add(fileLabel);
        fileLabel.setBounds(10,10,100,40);

        JTextField filePicker = new JTextField();
        frame.add(filePicker);
        filePicker.setBounds(75,10,320,40);

        filePicker.addActionListener(e -> fileName = filePicker.getText());
    }
}
