//	LSArrayApp
//	25	Feb 2020
//	Chris	Kim

public class LoadSheddingUnit implements Comparable<LoadSheddingUnit> {
   protected int day;
   protected String parameters;
   protected String areas;
   
   public LoadSheddingUnit () {
   }
   
   public LoadSheddingUnit(String raw) {
      parameters = raw.substring (0, raw.indexOf(' '));
      
      day = Integer.parseInt (raw.substring (2, raw.indexOf('_', 2)));
      areas = raw.substring (raw.indexOf(' ') + 1);
   }
   
   public boolean matches (String p) {
      if (p.equals (parameters)) {
         return true;
      }
      
      return false;
   }
   
   @Override
   public int compareTo (LoadSheddingUnit unit) {
      if (parameters.equals(unit.getParameters())) {
         return 0;
      }
      
      if (day >= unit.getDay()) {
         return 1;
      }
      
      return -1;
   }
   
   public int getDay () {
      return day;
   }
      
   public String getParameters () {
      return parameters;
   }
   
   public String getAreas () {
      return areas;
   }
   
   public String toString () {
      String[] reader = parameters.split ("_");
      return "Stage " + reader[0] + " - Day " + String.format ("%2d", day) + " - Start Hour " + reader[2] + " - Areas " + areas;
   }
}