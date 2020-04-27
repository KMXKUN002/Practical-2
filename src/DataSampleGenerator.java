//	LSArrayApp
//	1 March 2020
//	Chris	Kim

import java.io.*;

public class DataSampleGenerator {
   public static void main (String[] args) {
      try {
         File file =	new File	("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
         FileReader fr = new FileReader (file);
         BufferedReader br = new BufferedReader (fr);
         StringBuffer sb = new StringBuffer();
         String line;
      
         while ((line = br.readLine()) != null) {
            if (Math.random() < 1) {
               System.out.println (line);
            }  
         }
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}