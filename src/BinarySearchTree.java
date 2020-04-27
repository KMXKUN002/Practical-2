// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{   
   protected int sortingOpCount = 0;
   protected int findingOpCount = 0;
   
   public int getSortingOpCount () {
      return sortingOpCount;
   }
   
   public int getFindingOpCount () {
      return findingOpCount;
   }
   
   public void insert ( dataType d )
   {
      sortingOpCount++; //instrumentation
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      sortingOpCount++; //instrumentation
      if (d.compareTo (node.data) <= 0)
      {
         sortingOpCount++; //instrumentation
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         sortingOpCount++; //instrumentation
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      findingOpCount++; //instrumentation
      if (root == null)
         return null;
      else
         return find (d, root);
   }
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
   
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      opCount++; //instrumentation
      if (node == null) return null;
      
      opCount++; //instrumentation
      if (d.compareTo (node.data) < 0) {
         node.left = delete (d, node.left);
      }
      else if (d.compareTo (node.data) > 0) {
         opCount++; //instrumentation
         node.right = delete (d, node.right);
      }
      else if (node.left != null && node.right != null )
      {
         opCount++; //instrumentation
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else {
         opCount++; //instrumentation
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      }
      return node;
   }
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
