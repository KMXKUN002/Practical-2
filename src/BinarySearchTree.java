// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{   
   protected int findingOpCount = 0;
      
  /**
   * Returns the attribute of this class findingOpCount, which counts the number of operations used to find a given object in the tree
   * 
   * 
   */
   public int getFindingOpCount () {
      return findingOpCount;
   }
   
  /**
   * Resets the findingOpCount
   * 
   * 
   */
   public void resetFindingOpCount () { findingOpCount = 0; }
   
  /**
   * Inserts an instance of an object into the tree
   * 
   * @param d  the instance of the dataType object which we are concerned with (eg. LoadSheddingUnit)
   */
   public void insert ( dataType d )
   {
      opCount++; //instrumentation
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   
  /**
   * Inserts an instance of an object into the tree.
   * The process of this automatically sorts the objects so that an object with an equal or lesser key goes to the left, and a greater key goes to the right.
   * 
   * @param d the instance of the dataType object which we are concerned with (eg. LoadSheddingUnit)
   * @param node  the node to which the object d is attached
   */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (d.compareTo (node.data) <= 0)
      {
         opCount++; //instrumentation
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         opCount++; //instrumentation
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
  /**
   * Searches for and returns a given object in the tree
   * 
   * @param d  the instance of the dataType object which we are concerned with (eg. LoadSheddingUnit)
   */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      findingOpCount++; //instrumentation
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
  /**
   * Searches for and returns a given object in the tree, going recursively down the tree.
   * If the given object's key is equal to the current node's, the method returns that node's object.
   * If the given object's key is less than the current node, the method searches in the tree beginning from the left node.
   * Else, the method searches in the tree beginning from the right node.
   * 
   * @param d  the instance of the dataType object which we are concerned with (eg. LoadSheddingUnit)
   * @param node  the node to which the object d is attached
   */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      findingOpCount++; //instrumentation
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0) {
         findingOpCount++; //instrumentation
         return (node.left == null) ? null : find (d, node.left);
      }
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
}
