package view;

import interface_adapter.SearchResult.SearchResultController;
import interface_adapter.weather.WeatherController;
import interface_adapter.weather.WeatherState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

/*
* This class responsible for creating the Map Subpanel of the main. The Map subpanel itself contains 3 parts:
*   1. city input panel where user can type the city name. This is connected to an Action Lisenter, which pass infor
* to our weatherContoller Class.
*   2. date input panel
*   3. mapimagepanel.getDisplayfield where we display the image of the map using Jlabel format.
 */
@SuppressWarnings("checkstyle:WriteTag")
public class MapPanelView extends JPanel implements ActionListener {
    private final LabelTextPanel cityinputpanel;
    private final LabelTextPanel dateinputpanel;
    private final MapImagepanel mapimagepanel;

    private final JTextField cityinputfield = new JTextField(15);
    private final JButton alert;
    private final JTextField dateinputfield = new JTextField(15);
    private final JButton search;
    private final int mappanelwidth = 370;
    private final int mappanelheight = 400;

    private SearchResultController searchResultController;
    private WeatherController weatherController;

    public MapPanelView() {

        mapimagepanel = new MapImagepanel();

        cityinputfield.addActionListener(
                event -> {
                    // if the event is coming from cityinput field, execute weather controller
                    if (event.getSource() == cityinputfield) {
                        weatherController.execute(cityinputfield.getText());
                    }
                }
        );
        cityinputpanel = new LabelTextPanel(new JLabel("search bar"), cityinputfield);
        dateinputpanel = new LabelTextPanel(new JLabel("date"), dateinputfield);
        dateinputfield.addActionListener(
                // if this event is coming from dateinput field, execute searchresult contoller
                event -> {
                    if (event.getSource() == dateinputfield) {
                        searchResultController.execute(cityinputfield.getText(), dateinputfield.getText());
                    }
                });
//        this.setSize(mappanelwidth, mappanelheight);
        this.setPreferredSize(new java.awt.Dimension(mappanelwidth, mappanelheight));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(cityinputpanel);
        this.add(dateinputpanel);
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
//    public void propertyChange(PropertyChangeEvent evt) {
//        final WeatherState state = (WeatherState) evt.getNewValue();
//        setFields(state);
//        if (state.getError() != null) {
//            JOptionPane.showMessageDialog(this, state.getError(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void setFields(WeatherState state) {
//        cityinputfield.setText(state.getWeather());
//    }

    public void setWeatherController(WeatherController weathercontroller) {
        this.weatherController = weathercontroller;
    }

    public void setSearchResultController(SearchResultController searchresultcontroller) {
        this.searchResultController = searchresultcontroller; }
}

