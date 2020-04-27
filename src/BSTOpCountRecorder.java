// BSTOpCountRecorder
//	1 March 2020
//	Chris	Kim

import java.io.*;

public class BSTOpCountRecorder {
   static int opCount = 0; //instrumentation
   
   public static void main (String[] args) {
      int n = 0;
      int minFindingOpCount = 3000;
      int maxFindingOpCount = 0;
      
      int totalFinding = 0;
   
      try {
      
		   File file =	new File	("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
		   FileReader fr = new FileReader (file);
         BufferedReader br = new BufferedReader (fr);
         StringBuffer sb = new StringBuffer();
         String line;
         String[] sampleUnits = new String[3000];
         
         BinarySearchTree<LoadSheddingUnit> LSTree = new BinarySearchTree<LoadSheddingUnit> ();
         
         try {
            double samplePercent = Double.parseDouble (args[0]);
            while ((line = br.readLine()) != null) {
               if (Math.random()<samplePercent){
                  sampleUnits[n] = line.substring(0, line.indexOf(' '));
                  n++;
                  LSTree.insert (new LoadSheddingUnit(line));
               }
            }
         }
         catch (ArrayIndexOutOfBoundsException f) {
            System.out.println ("Array out of bounds");
         }

         for (int i=0; i<n; i++){
            LoadSheddingUnit comparableUnit = new LoadSheddingUnit (sampleUnits[i]);
            try {
               LoadSheddingUnit foundUnit = LSTree.find (comparableUnit).getData();
               int finding = LSTree.getFindingOpCount();
               
               totalFinding += finding;
               
               if (finding < minFindingOpCount)
                  minFindingOpCount = finding;
               if (finding > maxFindingOpCount)
                  maxFindingOpCount = finding;
               
               LSTree.resetFindingOpCount();
            }
            catch (NullPointerException g) {
               System.exit(0);
            }
         }
         System.out.println (n);
         System.out.println (minFindingOpCount + " " + maxFindingOpCount + " " + (double)(totalFinding)/(double)(n));
         
         /*
         try {            
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
         */
                     
         //opCount += LSTree.getOpCount();
                  
         //System.out.println ("Number of samples: " + n);
         
         //System.out.println ("Comparisons to find: " + LSTree.getFindingOpCount());
         
      }
      catch (IOException e) {
         e.printStackTrace();
      }

   }
}