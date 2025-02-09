public class Main {

        public static void main( String [] args){
            BST tree = new BST();
            tree.insert(new Node(5));
            tree.insert(new Node(6));
            tree.insert(new Node(7));
            tree.insert(new Node(3));
            tree.insert(new Node(2));
            tree.insert(new Node(4));
            tree.display();
        }
    }

