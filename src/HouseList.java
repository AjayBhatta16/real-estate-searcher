import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains a list of House objects
 * 
 * @author Ajay Bhattacharyya
 * @version March 6, 2021
 */
public class HouseList {
    //--------------------------------------
    // the list of House objects
    private ArrayList<House> houseList;
    //--------------------------------------
    /**
     * The constructor
     * @param fileName: a file containing stringified data to create House objects with
     */
    public HouseList(String fileName) {
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(fileName));
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        boolean atEnd = false;
        houseList = new ArrayList<House>();
        while(!atEnd) {
            try {
                this.houseList.add(new House(fileIn.next(), fileIn.nextInt(), fileIn.nextInt(), fileIn.nextInt()));
            } catch(Exception e) {
                atEnd = true;
            }
        }
    }
    //---------------------------------------
    /**
     * Prints the houses from the list that meet the user's requirements
     * @param r: A Requirement object containing the data of the user's requirements
     */
    public void printHouses(Requirement r) {
        System.out.println(this.getHouses(r));
    }
    //---------------------------------------
    /**
     * Returns a concatenated string of the details of all houses that satisfy the user's requirements
     * @param r: A Requirement object containing the data of the user's requirements
     * @return A concatenated string of all of the relevant houses
     */
    public String getHouses(Requirement r) {
        String output = "";
        for(int i = 0; i < this.houseList.size(); i++) {
            if(this.houseList.get(i).satisfies(r)) {
                output = output + this.houseList.get(i).toString() + "\n";
            }
        }
        return output;
    }
}