import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A model object to process data for the RealEstateSearcher application
 * Based on the Loan class from lecture notes
 * 
 * @author Ajay Bhattacharyya
 * @version April 2, 2021
 */
public class RealEstateModel {
    //----------------------------------------------
    // an array of house addresses that match the user's criteria
    private String[] matchingHouses;
    //----------------------------------------------
    // a collection of the house addresses that the user has already viewed
    private ArrayList<String> housesShown;
    //----------------------------------------------
    // a list of all houses available to the user
    private HouseList houses;
    //----------------------------------------------
    // a Stage object to place scenes on
    private Stage myStage;
    //----------------------------------------------
    // a Scene object to initialize user views
    private Scene myScene;
    //----------------------------------------------
    // the layout object for the main screen of the application
    private View realEstateView;
    //----------------------------------------------
    /**
     * The constructor
     */
    public RealEstateModel() {
        houses = new HouseList("houses.txt");
        housesShown = new ArrayList<String>();
        myStage = MainStageContainer.getInstance();
        createAndShowRealEstateView();
    }
    //----------------------------------------------
    /**
     * creates and swaps to a Scene initialized with realEstateView 
     */
    public void createAndShowRealEstateView() {
        realEstateView = new RealEstateView(this);
        myScene = new Scene(realEstateView);
        swapToView(myScene);
    }
    //----------------------------------------------
    /**
     * switches the user's view to a specified Scene object
     * 
     * @param newScene: the next Scene the user will see
     */
    public void swapToView(Scene newScene) {
        if(newScene == null) {
            System.out.println("missing view for display");
            return;
        }
        myStage.setScene(newScene);
        myStage.sizeToScene();
        WindowPosition.placeCenter(myStage);
    }
    //----------------------------------------------
    /**
     * populates matchingHouses with House objects that meet the specified parameters
     * 
     * @param r: a Requirement object containing the specified parameters
     */
    public void setMatchingHouses(Requirement r) {
        matchingHouses = houses.getHouses(r).split("\n");
        housesShown = new ArrayList<String>();
    }
    //----------------------------------------------
    /**
     * finds a matching house not already shown to the user and adds it to the housesShown array
     * 
     * @return the address of the new matching house
     */
    public String getUnshownHouse() {
        String output;
        int index = (int) (Math.random() * matchingHouses.length);
        output = matchingHouses[index].split(" ")[0];
        if(housesShown.size() == 0) {
            housesShown.add(output);
            return output;
        }
        if(housesShown.size() == matchingHouses.length) {
            return "No more available houses";
        }
        boolean alreadyShown = false;
        for(int i = 0; i < housesShown.size(); i++) {
            if(housesShown.get(i).equals(output)) {
                alreadyShown = true;
            }
        }
        if(alreadyShown) {
            return getUnshownHouse();
        } else {
            housesShown.add(output);
            return output;
        }
    }
    //----------------------------------------------
    /**
     * clears the matching houses and houses shown lists
     */
    public void reset() {
        matchingHouses = new String[]{};
        housesShown = new ArrayList<String>();
    }
}