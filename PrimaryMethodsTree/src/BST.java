public class BST {
   //each tree will have a root node

   Node root;
   //Insertion happens of a node from the comparison with the root node
   public void insert (Node node) {
      //Helper methods to compare weight of each node before inserting to the correct position
      root = insertHelper(root, node);
   }
   //Easier to use recursion
      private Node insertHelper(Node root, Node node){
      int data= node.data;
      //if the there is no element, the node will be root node.
      if(root==null ) {
         root = node;
         return root;
      }
      //if smaller, that goes left, we call recursion for assuming and treating each left node as root.
      else if(data< root.data){
         root.left = insertHelper(root.left, node) ;
      }
      //if greater goes right
        else{
           root.right= insertHelper(root.right, node);
      }
        return root;
      }

   public void display() {
    displayHelper( root);
   }
   private void displayHelper (Node root){
      //inorder traversal
      if(root!=null){
         displayHelper(root.left);
         System.out.println(root.data);
         displayHelper(root.right);

      }
   }
   public boolean search (int data){
        return searchHelper(root, data);
      }
   private boolean searchHelper(Node root, int data){
      //if root is the data that is to be searched
      if(root.data == data)
         return true;
      //if the tree is empty and if the data doesn't exist this will run in recursion method
      else if(root == null) return false;
      else if(root.data > data){
         return searchHelper(root.left, data);
      }
      else{
         return searchHelper(root.right, data);
      }
   }
   public void remove(int data) {
    removeHelper(root,data);
   }
      public Node removeHelper (Node root, int data){
         if(root == null) return root;
         else if(root.data> data){
            root = root.left;
         }
         else if(root.data< data){
            root = root.right;
         }
         else{
            if(root.left == null && root.left==null) root =null;

            else if(root.right!= null){// find a successor to replace this node
               root.data= successor(root);
               root.right= removeHelper(root.right, root.data);
            }
            else{//find a predecessor to replace this node
               root.data = predecessor(root);
               root.left= removeHelper(root.left, root.data);

            }
         }
         return root;
      }
      private int successor(Node root){ //find the least value below the right child of this root node
         root = root.right;
         while(root.left != null){
            root = root.left;
         }
         return root.data;
      }
      private int predecessor(Node root){// find the greatest value below the left child of this root node
         root = root.left;
         while(root.right != null){
            root = root.right;
         }
         return root.data;
      }




}
