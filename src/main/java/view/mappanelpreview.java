package view;

import interface_adapter.note.WeatherViewModel;

import javax.swing.*;

/*
* this class give a preview on MapPanelview.
 */
public class mappanelpreview {
    public static void main(String[] args) {
        // Create the JPanel and add components to it
        final MapPanelView panel = new MapPanelView(new WeatherViewModel());

        // Display the JPanel in a JOptionPane dialog
        JOptionPane.showMessageDialog(null, panel, "JPanel Preview", JOptionPane.PLAIN_MESSAGE);
    }
}