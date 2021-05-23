import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Run this file to start the application
 * Based on LoanCalculator class from lecture notes
 * 
 * @author Ajay Bhattacharyya
 * @version April 2, 2021
 */
public class RealEstateSearcher extends Application {
    //----------------------------------------------
    // model object for processing data
    private RealEstateModel myModel;
    //----------------------------------------------
    // Stage to display the application on
    private Stage mainStage;
    //----------------------------------------------
    /**
     * main method to launch the GUI
     */
    public static void main(String[] args) {
        launch(args);
    }
    //----------------------------------------------
    /**
     * initializes the model object and puts a Stage in the center of the window
     * 
     * @param primaryStage: a stage object created by the user's computer
     */
    @Override
    public void start(Stage primaryStage) {
        MainStageContainer.setStage(primaryStage, "Real Estate Searcher");
        mainStage = MainStageContainer.getInstance();
        mainStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        try {
            myModel = new RealEstateModel();
        } catch(Exception e) {
            e.printStackTrace();
        }
        WindowPosition.placeCenter(mainStage);
        mainStage.show();
    }
}