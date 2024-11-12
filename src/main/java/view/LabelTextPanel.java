package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
public class LabelTextPanel extends JPanel {
    private JLabel output;

    public LabelTextPanel(JLabel label, JTextField textField) {
        this.output = null;
        this.add(label);
        this.add(textField);
    }

    public LabelTextPanel(JLabel label, JLabel info) {
        this.output = null;
        this.add(label);
        this.add(info);
    }

    public JLabel getoutput() {
        return this.output;
    }

    public void setoutput(String outputstring) {
        this.output = new JLabel(outputstring);
    }
}
