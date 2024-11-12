package view;

import javax.swing.*;

public class mapimagepreview {
    public static void main(String[] args) {
        // Create the JPanel and add components to it
        JPanel panel = new MapImagepanel();
        // Display the JPanel in a JOptionPane dialog
        JOptionPane.showMessageDialog(null, panel, "map image preview", JOptionPane.PLAIN_MESSAGE);
    }
}
