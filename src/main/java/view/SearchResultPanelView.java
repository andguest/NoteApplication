package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import interface_adapter.search_result.SearchResultController;
import interface_adapter.search_result.SearchResultState;
import interface_adapter.search_result.SearchResultViewModel;

/**
 * The View for when the user is viewing a note in the program.
 */
public class SearchResultPanelView extends JPanel implements ActionListener, PropertyChangeListener {

    private final SearchResultViewModel searchResultViewModel;

    private final JLabel noteName = new JLabel("search result");
    private final JTextArea cityInputField = new JTextArea();
    private final JTextArea dateInputField = new JTextArea();

    private final JButton cityButton = new JButton("Searched City");
    private final JButton dateButton = new JButton("Date");
    private final JLabel cityLabel = new JLabel("City:");
    private final JLabel dateLabel = new JLabel("Date:");
    private final JButton searchButton = new JButton("Search");
    private SearchResultController searchResultController;

    public SearchResultView(SearchResultViewModel searchResultViewModel) {

        noteName.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.searchResultViewModel = searchResultViewModel;
        this.searchResultViewModel.addPropertyChangeListener(this);

        final JPanel buttons = new JPanel();
        buttons.add(searchButton);

        // Creating panels to contain each label and input field
        final JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new BoxLayout(cityPanel, BoxLayout.X_AXIS));
        cityPanel.add(cityLabel);
        cityPanel.add(cityInputField);

        final JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.X_AXIS));
        datePanel.add(dateLabel);
        datePanel.add(dateInputField);

        searchButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(searchButton)) {
                        searchResultAction();
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(noteName);
        this.add(cityPanel);
        this.add(datePanel);
        this.add(buttons);
    }

    private void searchResultAction() {
        final String city = cityInputField.getText();
        final String date = dateInputField.getText();

        if (city.isEmpty() || date.isEmpty()) {
            // Display an error message or simply return
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in both the City and Date fields before searching.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            searchResultController.execute(city, date);
        }
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SearchResultState state = (SearchResultState) evt.getNewValue();
        setFields(state);
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFields(SearchResultState state) {
        cityInputField.setText(state.getWeather().getCity());
        dateInputField.setText(state.getDate());
    }

    public void setSearchResultController(SearchResultController controller) {
        this.searchResultController = controller;
    }
}