// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   private int findingOpCount = 0;
   
  /**
   * Returns the attribute of this class findingOpCount, which counts the number of operations used to find a given object in the tree
   * 
   * 
   */
   public int getFindingOpCount () { return findingOpCount; }
   
  /**
   * Resets the findingOpCount
   * 
   * 
   */
   public void resetFindingOpCount () { findingOpCount = 0; }

  /**
   * Returns the total height of the BinaryTree
   * 
   * @param node  the node from which the height will be measured
   */
   public int height ( BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (node != null)
         return node.height;
      return -1;
   }
   
  /**
   * Contrasts the height of the left tree to that of the right.
   * As an AVL tree, this difference must not be greater than 1.
   *
   * @param node  the node from which the height will be measured
   */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
  /**
   * As an AVL tree, this difference must not be greater than 1.
   * Recalculates the height of the tree starting from the given node.
   *
   * @param node  the node from which the height will be measured
   */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
      opCount++; //instrumentation
   }
   
  /**
   * As an AVL tree, this difference must not be greater than 1.
   * Rotates the tree from the given node to the right
   *
   * @param p  the node from which the height will be measured
   */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

  /**
   * As an AVL tree, this difference must not be greater than 1.
   * Rotates the tree from the given node to the left
   *
   * @param q  the node from which the height will be measured
   */
   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
  /**
   * As an AVL tree, this difference must not be greater than 1.
   * Balances the tree with a series of rotations so that the height of the left tree and that of the right are balanced,
   * Balance is to mean that the difference between those two heights is no more than 1.
   *
   * @param p  the node from which the height will be measured
   */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      
      opCount++; //instrumentation
      if (balanceFactor (p) == 2)
      {
         opCount++; //instrumentation
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      
      opCount++; //instrumentation
      if (balanceFactor (p) == -2)
      {
         opCount++; //instrumentation
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

  /**
   * Inserts an instance of an object into the tree
   * 
   * @param d  the instance of the dataType object which we are concerned with (eg. LoadSheddingUnit)
   */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   
  /**
   * Inserts an instance of an object into the tree.
   * The process of this automatically sorts the objects so that an object with an equal or lesser key goes to the left, and a greater key goes to the right.
   * 
   * @param d the instance of the dataType object which we are concerned with (eg. LoadSheddingUnit)
   * @param node  the node to which the object d is attached
   */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      
      opCount++; //instrumentation
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
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

