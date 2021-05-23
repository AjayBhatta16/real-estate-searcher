/**
 * Tester class for HouseList
 * 
 * @author Ajay Bhattacharyya
 * @version March 6, 2021
 */
public class HouseListTester {
    public static void main(String [] args) {
        HouseList availableHouses = new HouseList("houses.txt");
        Requirement[] requirements = new Requirement[] {
            new Requirement(1000, 500000, 100, 5000, 0, 10),
            new Requirement(1000, 100000, 500, 1200, 0, 3),
            new Requirement(100000, 200000, 1000, 2000, 2, 3),
            new Requirement(200000, 300000, 1500, 4000, 3, 6),
            new Requirement(100000, 500000, 2500, 5000, 3, 6),
            new Requirement(150000, 300000, 1500, 4000, 3, 6),
            new Requirement(100000, 200000, 2500, 5000, 4, 6)
        };
        for(int i = 0; i < requirements.length; i++) {
            System.out.println("Houses matching requirement "+i+":");
            if(availableHouses.getHouses(requirements[i]).equals("")) {
                System.out.println("No houses match this requirement set.");
            } else {
                availableHouses.printHouses(requirements[i]);
            }
            System.out.println();
        }
    }
}
