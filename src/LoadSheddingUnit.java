//	LSArrayApp
//	25	Feb 2020
//	Chris	Kim

public class LoadSheddingUnit implements Comparable<LoadSheddingUnit> {
   protected int key;
   protected String areas;
   
  /**
   * Empty constructor for the object LoadSheddingUnit.
   */
   public LoadSheddingUnit () {
   }
   
  /**
   * Takes in raw data of a load shedding entry, such as "8_14_00"
   * This method separates the stage, the day, and the hour by the '_'s separating them,
   * and turns them into a unique integer key to be used for the binary tree.
   *
   * @param raw   a string containing the raw data of the load shedding unit, from the given text file
   */
   public LoadSheddingUnit(String raw) {
      String[] parameters = raw.split("_");
      
      areas = parameters[2].substring(2);
      key = Integer.parseInt (parameters[0]) * 10000;
      key += Integer.parseInt (parameters[1]) * 100;
      key += Integer.parseInt (parameters[2].substring(0, 2));
      
   }
   
  /**
   * Method used to compare two LoadSheddingUnit instantiations by their key.
   * Iff the keys of the respective objects are equal, the method returns true.
   *
   * @param k  an integer key of a given LoadSheddingUnit object
   */
   public boolean matches (int k) {
      if (key == k)
         return true;
      
      return false;
   }
   
  /**
   * An overriding compareTo function. The LoadSheddingUnit class implements the Comparable interface.
   * This compareTo method is used in the BinarySearchTree and AVLTree classes to find and sort objects.
   *
   * @param unit  a LoadSheddingUnit instance 
   */
   @Override
   public int compareTo (LoadSheddingUnit unit) {
      if (key == unit.getKey())
         return 0;
      
      if (key > unit.getKey())
         return 1;
      
      return -1;
   }
   
  /**
   * Returns the key attribute of the LoadSheddingUnit object
   * 
   *
   */
   public int getKey () {
      return key;
   }
   
  /**
   * An important method for returning exclusively the areas designated by the LoadSheddingUnit
   * eg. "6, 13"
   */
   public String getAreas () {
      return areas;
   }
   
  /**
   * Standard toString method to return the data in an ordered fashion.
   * 
   */
   public String toString () {
      int[] parameters = new int[3];
      parameters[0] = key/10000;
      parameters[1] = (key / 100) % 100;
      parameters[2] = key % 100;
      return "Stage " + parameters[0] + ", Day " + parameters[1] + ", Hour " + parameters[2] + ", Areas " + areas;
   }
}