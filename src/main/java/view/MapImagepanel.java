package view;

import javax.swing.*;
import java.awt.*;

/*
* the MapImagePanel is responsible for displaying the map file.
 */
public class MapImagepanel extends JPanel {
    private ImageIcon imagemap;
    private String filename;
    private JLabel displayfield;

    // if no arg given, use the example MapImage.png
    public MapImagepanel() {
        // this is a local image
        this.filename = "/Users/sophie/IdeaProjects/WeatherWizard/src/main/java/view/MapImage.png";
        try {
            imagemap = new ImageIcon(this.filename);
            displayfield = new JLabel(imagemap);
            this.add(displayfield);
            this.setPreferredSize(new Dimension(imagemap.getIconWidth(), imagemap.getIconHeight()));

        } catch (Exception e) {
            System.out.println("image cannot be found");
        }
    }

    // or pass a filename as an argument
    public MapImagepanel(String filename) {
        this.filename = filename;
        try {
            imagemap = new ImageIcon(this.filename);
            displayfield = new JLabel(imagemap);
            this.add(displayfield);
            this.setPreferredSize(new Dimension(imagemap.getIconWidth(), imagemap.getIconHeight()));

        } catch (Exception e) {
            System.out.println("image cannot be found");
        }
    }

    public JLabel getDisplayfield() {
        return displayfield;
    }
}
