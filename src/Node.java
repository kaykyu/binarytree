public class Node {
    
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node left) {this.left = left;}
    public void setRight(Node right) {this.right = right;}

    
}
