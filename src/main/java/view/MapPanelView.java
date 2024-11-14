package view;

import interface_adapter.note.NoteController;
import interface_adapter.note.WeatherState;
import interface_adapter.note.WeatherViewModel;
import WeatherController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
* This class responsible for creating the Map Subpanel of the main. The Map subpanel itself contains 2 parts:
*   1. search panel where user can type the city name. This is connected to a Action Lisenter, which pass information
* to our Input Class.
*   2. mapimagepanel.getDisplayfield where we display the image of the map using Jlabel format.
 */
public class MapPanelView extends JPanel implements ActionListener {
    private final LabelTextPanel searchpanel;
    private final MapImagepanel mapimagepanel;
    private final JTextField cityinputfield = new JTextField(15);
    private final int mappanelwidth = 370;
    private final int mappanelheight = 400;

    private WeatherController weatherController;

    public MapPanelView() {


        mapimagepanel = new MapImagepanel();
        cityinputfield.addActionListener(
                event -> {
                    // if the event is coming from cityinput field, execute controller
                    if (event.getSource() == cityinputfield) {WeatherController.excute(cityinputfield.getText());
                    }
                }
        );
        searchpanel = new LabelTextPanel(new JLabel("search bar"), cityinputfield);
//        this.setSize(mappanelwidth, mappanelheight);
        this.setPreferredSize(new java.awt.Dimension(mappanelwidth, mappanelheight));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(searchpanel);
        // adding a Jlabel
        this.add(mapimagepanel.getDisplayfield());

    }

    @Override
    /*
    * prints a message to the console when an action event occurs. Will look something like "Enter city name"
     */
    public void actionPerformed(ActionEvent event) {
        System.out.println("Enter" + event.getActionCommand());

    }
    public void propertyChange(PropertyChangeEvent evt) {
        final WeatherState state = (WeatherState) evt.getNewValue();
        setFields(state);
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void setFields(WeatherState state) {
        cityinputfield.setText(state.getWeather());
    }

    public void setWeatherController(WeatherController controller) {
        this.weatherController = controller;
    }
}

