// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
  /**
   * Constructs a BinaryTreeNode
   * 
   * @param d  the given dataType (eg. LoadSheddingUnit) which must be arranged into the binary ttree
   * @param l  the node below this node that is to the left
   * @param r  the node below this node that is to the right
   */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
  /**
   * Returns the node below this node that is to the left 
   */
   BinaryTreeNode<dataType> getLeft () { return left; }
   
  /**
   * Returns the node below this node that is to the left 
   */
   BinaryTreeNode<dataType> getRight () { return right; }
   
  /**
   * Returns dataType object of the node 
   */
   public dataType getData () { return data; }
}
