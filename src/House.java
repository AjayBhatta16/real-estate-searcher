/**
 * Contains basic data on a house for sale
 * 
 * @author Ajay Bhattacharyya
 * @version March 6, 2021
 */
public class House {
    //------------------------------------------
    // street address of the house
    private String address;
    //------------------------------------------
    // price of the house
    private int price;
    //------------------------------------------
    // size of the house
    private int area;
    //------------------------------------------
    // number of bedrooms in the house
    private int numBedrooms;
    //------------------------------------------
    /**
     * The constructor
     * @param address: a string value for the new object's address attribute
     * @param price: an integer value for the new object's price attribute
     * @param area: an integer value for the new object's area attribute
     * @param numBedrooms: an integer value for the object's numBedrooms attribute
     */
    public House(String address, int price, int area, int numBedrooms) {
        this.address = address;
        this.price = price;
        this.area = area;
        this.numBedrooms = numBedrooms;
    }
    //------------------------------------------
    /**
     * Accessor method for the address attribute
     * @return the value of the address attribute
     */
    public String getAddress() {
        return this.address;
    }
    //------------------------------------------
    /**
     * Accessor method for the price attribute
     * @return the value of the price attribute
     */
    public int getPrice() {
        return this.price;
    }
    //------------------------------------------
    /**
     * Accessor method for the area attribute
     * @return the value of the area attribute
     */
    public int getArea() {
        return this.area;
    }
    //------------------------------------------
    /**
     * Accessor method for the numBedrooms attribute
     * @return the value of the numBedrooms attribute
     */
    public int getNumBedrooms() {
        return this.numBedrooms;
    }
    //------------------------------------------
    /**
     * Determines whether or not the house satisfies the user's requirements
     * @param r: a Requirement object containing data on the user's requirements
     * @return a boolean variable based on a comparison of this House and the user's Requirement
     */
    public boolean satisfies(Requirement r) {
        boolean priceInRange = (this.price >= r.getMinimumPrice()) && (this.price <= r.getMaximumPrice());
        boolean areaInRange = (this.area >= r.getMinimumArea()) && (this.area <= r.getMaximumArea());
        boolean bedroomsInRange = (this.numBedrooms >= r.getMinimumNumberOfBedrooms()) && (this.numBedrooms <= r.getMaximumNumberOfBedrooms());
        return priceInRange && areaInRange && bedroomsInRange;
    }
    //------------------------------------------
    /**
     * Converts a House object to a string
     * @return a string containing all of the attribute data points of a House object
     */
    public String toString() {
        return this.address+" "+this.price+" "+this.area+" "+this.numBedrooms;
    }
}