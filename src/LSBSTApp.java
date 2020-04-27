//	LSArrayApp
//	1 March 2020
//	Chris	Kim

import java.io.*;
import java.util.concurrent.TimeUnit;

public class LSBSTApp {
   static int opCount = 0;
   
   public static void main (String[] args) {
      long systemStartTime = System.currentTimeMillis(); //Time measured from here
      int n = 0;
   
      try {
      
		   File file =	new File	("Sample10");
		   FileReader fr = new FileReader (file);
         BufferedReader br = new BufferedReader (fr);
         StringBuffer sb = new StringBuffer();
         String line;
         
         BinarySearchTree<LoadSheddingUnit> LSTree = new BinarySearchTree<LoadSheddingUnit> ();

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
               String parameters = args[0] + "_" + args[1] + "_" + args[2] + " ";
            
               LoadSheddingUnit comparableUnit = new LoadSheddingUnit (parameters);               
               try {
                  LoadSheddingUnit foundUnit = LSTree.find (comparableUnit).getData();
                  System.out.println ("Areas " + foundUnit.getAreas());
               }
               catch (NullPointerException g) {
                  System.out.println ("Areas not found");
               }
            }
            catch (ArrayIndexOutOfBoundsException f) {
               System.out.println ("Not enough parameters.");
            }
         }   
                     
         opCount += LSTree.getOpCount();
         
         long timeElapsed = System.currentTimeMillis() - systemStartTime; //Time stop
         System.out.println ("Time elapsed (ms): " + timeElapsed);
         
         System.out.println ("n = " + n);

         System.out.println ("Comparisons to find: " + LSTree.getFindingOpCount());
         System.out.println ("Comparisons to sort: " + LSTree.getSortingOpCount());
         System.out.println ("Other comparisons: " + opCount);
         
         opCount += LSTree.getFindingOpCount() + LSTree.getSortingOpCount();
         System.out.println ("Total comparisons: " + opCount + "\n");
      }
      catch (IOException e) {
         e.printStackTrace();
      }

   }
}