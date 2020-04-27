// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   protected int opCount = 0;
   
  /**
   * Returns the opCount attribute of an instantiation of BinaryTree.
   */
   public int getOpCount() { return opCount; }
   
  /**
   * Resets the opCount attribute back to 1.
   */
   public void resetOpCount() { opCount = 0; }
   
  /**
   * Empty constructor which establishes a root node.
   */
   public BinaryTree ()
   {
      root = null;
   }
   
  /**
   * Returns the total height of the BinaryTree
   * 
   */
   public int getHeight ()
   {
      return getHeight (root);
   }   
  
  /**
   * Returns the total height of the BinaryTree
   * 
   */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
  /**
   * Returns the total number of nodes in the BinaryTree
   * 
   */
   public int getSize ()
   {
      return getSize (root);
   }   
  
  /**
   * Returns the total number of nodes in the BinaryTree starting from a given node
   * 
   * @param node a node of the given data type (eg. LoadSheddingUnit)
   */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
  /**
   * Prints out the toString of the given node's data
   * 
   * @param node a node of the given data type (eg. LoadSheddingUnit)
   */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }

  /**
   * Visits each node in the Binary Tree one by one, starting from the lowest, leftmost node and
   * going to whichever is the next farthest to the left
   */
   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
}
