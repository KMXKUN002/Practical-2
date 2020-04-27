//	LSArrayApp
//	25	Feb 2020
//	Chris	Kim

public class LoadSheddingUnit implements Comparable<LoadSheddingUnit> {
   protected int key;
   protected String areas;
   
   public LoadSheddingUnit () {
   }
   
   public LoadSheddingUnit(String raw) {
      String[] parameters = raw.split("_");
      
      areas = parameters[2].substring(2);
      key = Integer.parseInt (parameters[0]) * 10000;
      key += Integer.parseInt (parameters[1]) * 100;
      key += Integer.parseInt (parameters[2].substring(0, 2));
      
   }
   
   public boolean matches (int k) {
      if (key == k)
         return true;
      
      return false;
   }
   
   @Override
   public int compareTo (LoadSheddingUnit unit) {
      if (key == unit.getKey())
         return 0;
      
      if (key > unit.getKey())
         return 1;
      
      return -1;
   }
   
   public int getKey () {
      return key;
   }
   
   public String getAreas () {
      return areas;
   }
   
   public String toString () {
      int[] parameters = new int[3];
      parameters[0] = key/10000;
      parameters[1] = (key / 100) % 100;
      parameters[2] = key % 100;
      return "Stage " + parameters[0] + ", Day " + parameters[1] + ", Hour " + parameters[2] + ", Areas " + areas;
   }
}