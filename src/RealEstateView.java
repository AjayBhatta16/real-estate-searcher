import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * The layout and event handlers for the main view of the RealEstateSearcher application
 * Based on the LoginView class from the lecture notes
 * 
 * @author Ajay Bhattacharyya
 * @version April 2, 2021
 */
public class RealEstateView extends View {
    //----------------------------------------------
    // model object for processing data
    private RealEstateModel myModel;
    //----------------------------------------------
    // a text box where the user can specify their minimum price
    private TextField minPrice;
    //----------------------------------------------
    // a text box where the user can specify their maximum price
    private TextField maxPrice;
    //----------------------------------------------
    // a text box where the user can specify their minimum area
    private TextField minArea;
    //----------------------------------------------
    // a text box where the user can specify their maximum area
    private TextField maxArea;
    //----------------------------------------------
    // a text box where the user can specify their minimum number of beds
    private TextField minBeds;
    //----------------------------------------------
    // a text box where the user can specify their maximum number of beds
    private TextField maxBeds;
    //----------------------------------------------
    // a text box where house addresses are displayed to the users
    private TextField resultsBox;
    //----------------------------------------------
    // a button the user clicks after they have filled out their parameters
    private Button searchButton;
    //----------------------------------------------
    // a button the user clicks to view another matching house
    private Button nextButton;
    //----------------------------------------------
    // a button the user can click to reset all data and text fields
    private Button resetButton;
    //----------------------------------------------
    /**
     * the constructor
     * 
     * @param m: an initialized RealEstateModel object
     */
    public RealEstateView(RealEstateModel m) {
        super("Real Estate Searcher");
        myModel = m;
        VBox container = new VBox(10);
        container.setPadding(new Insets(15, 5, 5, 5));
        container.getChildren().add(createTitle());
        container.getChildren().add(createFormContents());
        getChildren().add(container);
    }
    //----------------------------------------------
    /**
     * creates the title text for the main application layout
     * 
     * @return a Grid container for the centered title text
     */
    private GridPane createTitle() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        VBox container = new VBox(10);
        Text titleText = new Text("Real Estate Listings");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.DARKGREEN);
        container.getChildren().add(titleText);
        grid.getChildren().add(container);
        return grid;
    }
    //----------------------------------------------
    /**
     * creates the form controls for the main application layout
     * 
     * @return a VBox container with the centered form controls
     */
    private VBox createFormContents() {
        // main container
        VBox mainContainer = new VBox(10);
        // grid layout for the labels and text boxes
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        // label and text box for minimum price
        Label minPrLabel = new Label("Minimum price: ");
        grid.add(minPrLabel, 0, 0);
        minPrice = new TextField();
        grid.add(minPrice, 1, 0);
        // label and text box for maximum price
        Label maxPrLabel = new Label("Maximum price: ");
        grid.add(maxPrLabel, 0, 1);
        maxPrice = new TextField();
        grid.add(maxPrice, 1, 1);
        // label and text box for minimum area
        Label minArLabel = new Label("Minimum area: ");
        grid.add(minArLabel, 0, 2);
        minArea = new TextField();
        grid.add(minArea, 1, 2);
        // label and text box for maximum area
        Label maxArLabel = new Label("Maximum area: ");
        grid.add(maxArLabel, 0, 3);
        maxArea = new TextField();
        grid.add(maxArea, 1, 3);
        // label and text box for minimum number of beds
        Label minBdLabel = new Label("Minimum beds: ");
        grid.add(minBdLabel, 0, 4);
        minBeds = new TextField();
        grid.add(minBeds, 1, 4);
        // label and text box for maximum number of beds
        Label maxBdLabel = new Label("Maximum beds: ");
        grid.add(maxBdLabel, 0, 5);
        maxBeds = new TextField();
        grid.add(maxBeds, 1, 5);
        // label and text box for the selected house
        Label resultsLabel = new Label("Chosen Home: ");
        grid.add(resultsLabel, 0, 7);
        resultsBox = new TextField();
        grid.add(resultsBox, 1, 7);
        // search button
        searchButton = new Button("Find my dream house!");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // retrieve form data
                int minPrEntered = (minPrice.getText() == null || minPrice.getText().equals("")) ? 0 : Integer.parseInt(minPrice.getText());
                int maxPrEntered = (maxPrice.getText() == null || maxPrice.getText().equals("")) ? Integer.MAX_VALUE : Integer.parseInt(maxPrice.getText());
                int minArEntered = (minArea.getText() == null || minArea.getText().equals("")) ? 0 : Integer.parseInt(minArea.getText());
                int maxArEntered = (maxArea.getText() == null || maxArea.getText().equals("")) ? Integer.MAX_VALUE : Integer.parseInt(maxArea.getText());
                int minBdEntered = (minBeds.getText() == null || minBeds.getText().equals("")) ? 0 : Integer.parseInt(minBeds.getText());
                int maxBdEntered = (maxBeds.getText() == null || maxBeds.getText().equals("")) ? Integer.MAX_VALUE : Integer.parseInt(maxBeds.getText());
                // send form data to model
                Requirement req = new Requirement(minPrEntered, maxPrEntered, minArEntered, maxArEntered, minBdEntered, maxBdEntered);
                myModel.setMatchingHouses(req);
                // get address from model
                resultsBox.setText(myModel.getUnshownHouse());
                // disable/enable buttons
                searchButton.setDisable(true);
                nextButton.setDisable(false);
            }
        });
        grid.add(searchButton, 0, 8);
        // next button
        nextButton = new Button("Not my dream -- find me another!");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // get another address from the model object
                resultsBox.setText(myModel.getUnshownHouse());
            }
        });
        nextButton.setDisable(true);
        grid.add(nextButton, 1, 8);
        mainContainer.getChildren().add(grid);
        // container to center-align the reset button
        GridPane resetButtonContainer = new GridPane();
        resetButtonContainer.setAlignment(Pos.CENTER);
        resetButtonContainer.setHgap(10);
        resetButtonContainer.setVgap(10);
        resetButtonContainer.setPadding(new Insets(25, 25, 25, 25));
        // create and display reset button
        resetButton = new Button("Reset");
        resetButton.setAlignment(Pos.CENTER);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // enable/disable other buttons
                nextButton.setDisable(true);
                searchButton.setDisable(false);
                // reset text boxes and the model
                resultsBox.setText("");
                minPrice.setText("");
                maxPrice.setText("");
                minArea.setText("");
                maxArea.setText("");
                minBeds.setText("");
                maxBeds.setText("");
                myModel.reset();
            }
        });
        resetButtonContainer.getChildren().add(resetButton);
        mainContainer.getChildren().add(resetButtonContainer);
        return mainContainer;
    }
    //----------------------------------------------
    /** inherited method from View class (obtained from lecture notes) */
    public void updateState(String key, Object value) {}
}