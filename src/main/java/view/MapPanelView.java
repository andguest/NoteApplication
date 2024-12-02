//package view;
//
//import app.MainApplication;
//import interface_adapter.CompareCities.CompareCitiesController;
//import interface_adapter.CompareCities.CompareCitiesState;
//import interface_adapter.CompareCities.CompareCitiesViewModel;
//import interface_adapter.SearchResult.SearchResultController;
//import interface_adapter.alert_pop.AlertPopController;
//import interface_adapter.converter.ConverterController;
//import interface_adapter.nearby_list.NearbyCitiesController;
//import interface_adapter.weather.WeatherController;
//import interface_adapter.weather.WeatherViewModel;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.beans.PropertyChangeEvent;
//
///*
//* This class responsible for creating the Map Subpanel of the main. The Map subpanel itself contains 4 parts:
//*   1. city input panel where user can type the city name. This is connected to an Action Lisenter, which pass infor
//* to our weatherContoller Class.
//*   2. date input panel
//*   4. compare to button
//*   3. mapimagepanel.getDisplayfield where we display the image of the map using Jlabel format.
// */
//@SuppressWarnings("checkstyle:WriteTag")
//public class MapPanelView extends JPanel implements ActionListener {
//    private final LabelTextPanel cityinputpanel;
//    private final LabelTextPanel dateinputpanel;
//    private final LabelTextPanel comparetopanel;
//    private final MapImagepanel mapimagepanel;
//
//    private final JTextField cityinputfield1 = new JTextField(20);
//    private final JTextField dateinputfield = new JTextField(20);
//    private final JTextField cityinputfield2 = new JTextField(20);
//    private final int mappanelwidth = 370;
//    private final int mappanelheight = 500;
//
//    private SearchResultController searchResultController;
//    private WeatherController weatherController;
//    private CompareCitiesController compareCitiesController;
//    private NearbyCitiesController nearbyCitiesController;
//    private AlertPopController alertPopController;
//    private final double torontoLatitude = 43.6532;
//    private final double torontoLongitude = -79.3832;
//
//    private CompareCitiesViewModel compareCitiesViewModel;
//
//    public MapPanelView(WeatherViewModel weatherViewModel) {
//        // by default set the map center be Toronto.
//        mapimagepanel = new MapImagepanel(weatherViewModel, torontoLatitude, torontoLongitude);
//        // when we get one city name -> weather contoller
//        cityinputfield1.addActionListener(
//                event -> {
//                    // if the event is coming from cityinput field, execute weather controller, check if empty
//                    if (event.getSource() == cityinputfield1 && cityinputfield1.getText().length() > 0) {
//                        weatherController.execute(cityinputfield1.getText());
//                    }
//                    else {
//                        cityinputfield1.setText("can not return empty");
//                    }
//                }
//        );
//        // if Compare to another city -> CompareCityController
//        cityinputpanel = new LabelTextPanel(new JLabel("search city"), cityinputfield1);
//        dateinputpanel = new LabelTextPanel(new JLabel("date"), dateinputfield);
//        comparetopanel = new LabelTextPanel(new JLabel("Compare To"), cityinputfield2);
//
//        dateinputfield.addActionListener(
//                // if this event is coming from dateinput field, execute searchresult contoller
//                event -> {
//                    if (event.getSource() == dateinputfield) {
//                        searchResultController.execute(cityinputfield1.getText(), dateinputfield.getText());
//                    }
//                });
////        this.setSize(mappanelwidth, mappanelheight);
//        this.setPreferredSize(new java.awt.Dimension(mappanelwidth, mappanelheight));
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(cityinputpanel);
//        this.add(dateinputpanel);
//        this.add(comparetopanel);
//        // adding a Jlabel
//        this.add(mapimagepanel.getDisplayfield());
//
//    }
//
//    @Override
//    /*
//    * prints a message to the console when an action event occurs. Will look something like "Enter city name"
//     */
//    public void actionPerformed(ActionEvent event) {
//        System.out.println("Enter" + event.getActionCommand());
//
//    }
//
//    public void setCompareCitiesViewModel(CompareCitiesViewModel compareCitiesViewModel) {
//        this.compareCitiesViewModel = compareCitiesViewModel;
//    }
////    public void propertyChange(PropertyChangeEvent evt) {
////        final WeatherState state = (WeatherState) evt.getNewValue();
////        setFields(state);
////        if (state.getError() != null) {
////            JOptionPane.showMessageDialog(this, state.getError(),
////                    "Error", JOptionPane.ERROR_MESSAGE);
////        }
////    }
////
////    private void setFields(WeatherState state) {
////        cityinputfield.setText(state.getWeather());
////    }
//
//    public void setWeatherController(WeatherController weathercontroller) {
//        this.weatherController = weathercontroller;
//    }
//
//    public void setSearchResultController(SearchResultController searchresultcontroller) {
//        this.searchResultController = searchresultcontroller;
//    }
//
//    public void setNearbyListController(NearbyCitiesController nearbyCitiesController) {
//        this.nearbyCitiesController = nearbyCitiesController;
//    }
//
//    public void setAlertPopController(AlertPopController alertPopController) {
//        this.alertPopController = alertPopController;
//    }
//
//    public void setCompareCitiesController(CompareCitiesController compareCitiesController) {
//        this.compareCitiesController = compareCitiesController;
//    }
//}

package view;

import interface_adapter.CompareCities.CompareCitiesController;
import interface_adapter.CompareCities.CompareCitiesViewModel;
import interface_adapter.SearchResult.SearchResultController;
import interface_adapter.alert_pop.AlertPopController;
import interface_adapter.nearby_cities.NearbyCitiesController;
import interface_adapter.weather.WeatherController;
import interface_adapter.weather.WeatherViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/*
 * This class responsible for creating the Map Subpanel of the main. The Map subpanel itself contains 4 parts:
 *   1. city input panel where user can type the city name. This is connected to an Action Lisenter, which pass infor
 * to our weatherContoller Class.
 *   2. date input panel
 *   4. compare to button
 *   3. mapimagepanel.getDisplayfield where we display the image of the map using Jlabel format.
 */
@SuppressWarnings("checkstyle:WriteTag")
public class MapPanelView extends JPanel implements ActionListener {
    private final LabelTextPanel cityinputpanel;
    private final LabelTextPanel dateinputpanel;
    private final LabelTextPanel comparetopanel;
    private final MapImagepanel mapimagepanel;
    private LabelTextPanel timepanel;

    private final JLabel time = new JLabel("");

    private final JTextField cityinputfield1 = new JTextField(20);
    private final JTextField dateinputfield = new JTextField(20);
    private final JTextField cityinputfield2 = new JTextField(20);
    private final int mappanelwidth = 370;
    private final int mappanelheight = 500;

    private SearchResultController searchResultController;
    private WeatherController weatherController;
    private CompareCitiesController compareCitiesController;
    private NearbyCitiesController nearbyCitiesController;
    private AlertPopController alertPopController;
    private final double torontoLatitude = 43.70011;
    private final double torontoLongitude = -79.4163;
    private CompareCitiesViewModel compareCitiesViewModel;

    private final JButton alertPop;

    public MapPanelView(WeatherViewModel weatherViewModel) {
        // by default set the map center be Toronto.

        timepanel = new LabelTextPanel(new JLabel("Time"), time);
        mapimagepanel = new MapImagepanel(weatherViewModel, torontoLatitude, torontoLongitude);
        // when we get one city name -> weather contoller
        cityinputfield1.addActionListener(
                event -> {
                    // if the event is coming from cityinput field, execute weather controller, check if empty
                    if (event.getSource() == cityinputfield1 && cityinputfield1.getText().length() > 0) {
                        weatherController.execute(capitalizeCity(cityinputfield1.getText()));
                        cityinputfield1.setText("");
                        final DateTimeFormatter formatter = DateTimeFormatter
                                .ofPattern("yyyy-MM-dd HH").withZone(ZoneOffset.UTC);
                        final String timestamp = formatter.format(Instant.now());
                        time.setText(timestamp);
                    }
                    else {
                        cityinputfield1.setText("can not return empty");
                    }
                }
        );
        // if Compare to another city -> CompareCityController
        cityinputfield2.addActionListener(
                event -> {
                    if (cityinputfield1.getText().length() > 0 && cityinputfield2.getText().length() > 0) {

                        // some how the view model doesn't get update
                        compareCitiesController.execute(capitalizeCity(cityinputfield1.getText()), capitalizeCity(cityinputfield2.getText()));

                        new CompareCitiesView(this.compareCitiesViewModel);
                    }
                    else {
                        cityinputfield2.setText("can not return empty");
                    }
                }
        );
        cityinputpanel = new LabelTextPanel(new JLabel("City Name"), cityinputfield1);
        dateinputpanel = new LabelTextPanel(new JLabel("Time (YYYY-MM-DD hh)"), dateinputfield);
        comparetopanel = new LabelTextPanel(new JLabel("Compare To"), cityinputfield2);
        timepanel = new LabelTextPanel(new JLabel("Current Time"), time);

        dateinputfield.addActionListener(
                // if this event is coming from dateinput field, execute searchresult contoller
                event -> {
                    if (event.getSource() == dateinputfield) {
                        searchResultController
                                .execute(capitalizeCity(cityinputfield1.getText()), dateinputfield.getText());
                        cityinputfield1.setText("");
                        dateinputfield.setText("");
                    }
                });

        final JPanel buttons = new JPanel();
        alertPop = new JButton("weather alert");
        buttons.add(alertPop);

        alertPop.addActionListener(
                // Opens a window showing weather alerts.
                new ActionListener() {
                    public void actionPerformed(ActionEvent id) {
                        alertPopController.execute(cityinputfield1.getText());
                    }
                }
        );

//        this.setSize(mappanelwidth, mappanelheight);
        this.setPreferredSize(new java.awt.Dimension(mappanelwidth, mappanelheight));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(cityinputpanel);
        this.add(dateinputpanel);
        this.add(comparetopanel);
        this.add(timepanel);
        this.add(buttons);
        // adding a Jlabel
        this.add(mapimagepanel.getDisplayfield());

    }

    private String capitalizeCity(String cityName) {
        final String[] split = cityName.split(" ");
        final StringBuilder output = new StringBuilder();
        for (String part : split) {
            output.append(part.substring(0, 1).toUpperCase())
                    .append(part.substring(1).toLowerCase()).append(" ");
        }
        return output.toString().trim();
    }

    @Override
    /*
     * prints a message to the console when an action event occurs. Will look something like "Enter city name"
     */
    public void actionPerformed(ActionEvent event) {
        System.out.println("Enter" + event.getActionCommand());
    }

    public void setWeatherController(WeatherController weathercontroller) {
        this.weatherController = weathercontroller;
    }

    public void setSearchResultController(SearchResultController searchresultcontroller) {
        this.searchResultController = searchresultcontroller;
    }

    public void setNearbyListController(NearbyCitiesController nearbyCitiesController) {
        this.nearbyCitiesController = nearbyCitiesController;
    }

    public void setAlertPopController(AlertPopController alertPopController) {
        this.alertPopController = alertPopController;
    }

    public void setCompareCitiesController(CompareCitiesController compareCitiesController) {
        this.compareCitiesController = compareCitiesController;
    }

    public void setCompareCitiesViewModel(CompareCitiesViewModel compareCitiesViewModel){
        this.compareCitiesViewModel = compareCitiesViewModel;
    }
}