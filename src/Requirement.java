/**
 * Contains data for a user's house requirements
 * 
 * @author Ajay Bhattacharyya
 * @version March 6, 2021
 */
public class Requirement {
    //----------------------------------
    // minimum price for the house
    private int minimumPrice;
    //----------------------------------
    // maximum price for the house
    private int maximumPrice;
    //----------------------------------
    // minimum area for the house
    private int minimumArea;
    //----------------------------------
    // maximum area for the house
    private int maximumArea;
    //----------------------------------
    // minimum number of bedrooms for the house
    private int minimumNumberOfBedrooms;
    //----------------------------------
    // maximum number of bedrooms for the house
    private int maximumNumberOfBedrooms;
    //----------------------------------
    /**
     * The constructor
     * @param minP: the minimum price
     * @param maxP: the maximum price
     * @param minA: the minimum area
     * @param maxA: the maximum area
     * @param minN: the minimum number of bedrooms
     * @param maxN: the maximum number of bedrooms
     */
    public Requirement(int minP, int maxP, int minA, int maxA, int minN, int maxN) {
        this.minimumPrice = minP;
        this.maximumPrice = maxP;
        this.minimumArea = minA;
        this.maximumArea = maxA;
        this.minimumNumberOfBedrooms = minN;
        this.maximumNumberOfBedrooms = maxN;
    }
    //----------------------------------
    /**
     * Accessor method for the minimumPrice attribute
     * @return the value of the minimumPrice attribute
     */
    public int getMinimumPrice() {
        return this.minimumPrice;
    }
    //----------------------------------
    /**
     * Accessor method for the maximumPrice attribute
     * @return the value of the maximumPrice attribute
     */
    public int getMaximumPrice() {
        return this.maximumPrice;
    }
    //----------------------------------
    /**
     * Accessor method for the minimumArea attribute
     * @return the value of the minimumArea attribute
     */
    public int getMinimumArea() {
        return this.minimumArea;
    }
    //----------------------------------
    /**
     * Accessor method for the maximumArea attribute
     * @return the value of the maximumArea attribute
     */
    public int getMaximumArea() {
        return this.maximumArea;
    }
    //----------------------------------
    /**
     * Accessor method for the minimumNumberOfBedrooms attribute
     * @return the value of the minimumNumberOfBedrooms attribute
     */
    public int getMinimumNumberOfBedrooms() {
        return this.minimumNumberOfBedrooms;
    }
    //----------------------------------
    /**
     * Accessor method for the maximumNumberOfBedrooms attribute
     * @return the value of the maximumNumberOfBedrooms attribute
     */
    public int getMaximumNumberOfBedrooms() {
        return this.maximumNumberOfBedrooms;
    }
}