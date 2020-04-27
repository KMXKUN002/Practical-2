//	LSAVLApp
//	16 March 2020
//	Chris	Kim

import java.io.*;

public class LSAVLApp {
   static int opCount = 0; //instrumentation
   
   public static void main (String[] args) {
      int n = 0;
   
      try {
      
		   File file =	new File	("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
		   FileReader fr = new FileReader (file);
         BufferedReader br = new BufferedReader (fr);
         StringBuffer sb = new StringBuffer();
         String line;
         
         AVLTree<LoadSheddingUnit> LSTree = new AVLTree<LoadSheddingUnit> ();

         while ((line = br.readLine()) != null) {
            opCount++; //instrumentation
            
            n++;
            LSTree.insert (new LoadSheddingUnit(line));
         }
         
         opCount++; //instrumentation         
         if (args.length == 0) {
            LSTree.inOrder();
         }
         else {
            try {
               String raw = args[0] + "_" + args[1] + "_" + args[2] + " ";
            
               LoadSheddingUnit comparableUnit = new LoadSheddingUnit (raw);               
               try {
                  LoadSheddingUnit foundUnit = LSTree.find (comparableUnit).getData();
                  System.out.println ("Areas " + foundUnit.getAreas());
               }
               catch (NullPointerException g) {
                  System.out.println ("Areas not found");
               }
            }
            catch (ArrayIndexOutOfBoundsException f) {
               System.out.println ("Parameters wrongly given.");
            }
         }   
                     
         opCount += LSTree.getOpCount();
                  
         System.out.println ("Number of samples: " + n);
         
         System.out.println ("Comparisons to find: " + LSTree.getFindingOpCount());
         
         System.out.println ("Total comparisons: " + opCount + "\n");
      }
      catch (IOException e) {
         e.printStackTrace();
      }

   }
}