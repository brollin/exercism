import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;

public class BST<T extends Comparable<T>> {

    private Node<T> root = null;
    private int size = 0;
    
    public BST() {
        return;
    }

    public void insert(T value) {
        Node<T> node = new Node<T>(value);
        
        if (this.root == null) this.root = node;
        else {
            this.root.linkNode(node);
        }

        size++;
    }

    public Node<T> getRoot() {
        return root;
    }
    
    public List<T> getAsLevelOrderList() {
        // AKA, return results of Breadth-First Search
        ArrayList <T> levelOrderList = new ArrayList <T>();
        ArrayList <Node <T>> openList = new ArrayList <Node <T>>();
        openList.add(this.getRoot());

        while (openList.size() > 0) {
            // Store the first item on the open list as the 
            //  current node and remove it from the open list
            Node<T> currNode = openList.get(0);
            openList.remove(0);

            // Add the current node to the appropriate row.
            levelOrderList.add(currNode.getData());
            
            // Add any children to the open list
            if (currNode.getLeft() != null) openList.add(currNode.getLeft());
            if (currNode.getRight() != null) openList.add(currNode.getRight());
        }

        return levelOrderList;
    }

    public List<T> getAsSortedList() {
        // AKA, do an in-order traversal of the BST which
        //  will result in a sorted list of elements
        List<T> sortedList = this.inOrderTraversal(new ArrayList<T>(), this.getRoot());


        return sortedList;
    }

    private List<T> inOrderTraversal(List<T> sortedList, List<Node<T>> openList, Node<T> node) {
        // if this node is on open list, recursively call on parent
        // if there's no left child, add this to the sortedList and openList
        //      if there's a right child, recursively call on right child
        //      otherwise recursively call on parent
        // if there's a left child but it's on open list, add current to sortedList and openList
        //      recursively call 
        
        if (node.getLeft() != null && !openList.contains(node.getLeft())) sortedList = inOrderTraversal(sortedList, node.getLeft());
    }

    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left = null;
        private Node<T> right = null;

        public Node(T value) {
            this.value = value;
        }

        public T getData() {
            return this.value;
        }

        public Node<T> getLeft() {
            return this.left;
        }
        
        public Node<T> getRight() {
            return this.right;
        }

        public void linkNode(Node<T> node) {
            boolean linkLeft;

            if (node.getData().compareTo(this.getData()) <= 0) {
                if (this.left == null) this.left = node;
                else this.left.linkNode(node);
            }
            else {
                if (this.right == null) this.right = node;
                else this.right.linkNode(node);
            }
        }
    }

}
