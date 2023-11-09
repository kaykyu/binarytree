import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public Node node;

    public static Node getNodes(List<Integer> list) {
        Node root = new Node(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Node temp = root;
            Node next = new Node(list.get(i));

            boolean stop = false;
            while (!stop) {
                if (next.value < temp.value) {
                    if (temp.left != null) {
                        temp = temp.left;
                    } else {
                    temp.setLeft(next);
                    stop = true;
                    }
                } else {
                    if (temp.right != null) {
                        temp = temp.right;
                    } else {
                    temp.setRight(next);
                    stop = true;
                    }
                }
            }
        }

        return root;   
    }

    public static void printAscending(List<Integer> list) {
        Node root = getNodes(list);
        Stack<Node> stack = new Stack<>();
        Node temp = root;

        while (!stack.isEmpty() || temp != null) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.printf("%s ", temp.value);
                temp = temp.right;
            }
        }          
    }

    public static void printDescending(List<Integer> list) {
        Node root = getNodes(list);
        Stack<Node> stack = new Stack<>();
        Node temp = root;

        while (!stack.isEmpty() || temp != null) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.right;
            } else {
                temp = stack.pop();
                System.out.printf("%s ", temp.value);
                temp = temp.left;
            }
        } 
    }

    public static void main(String[] args) {
        
        Console cons = System.console();
        String input = "";
        System.out.println("Please enter your numbers for sorting\nIndicate ascending or descending order at the start");
        input = cons.readLine("> ");

        while (!input.trim().equals("stop")){

            if (input.trim().startsWith("ascending")) {
                String[] list = input.trim().split(" ");
                List<Integer> l = new ArrayList<>();
                for (int i = 1; i < list.length; i++) {
                    l.add(Integer.parseInt(list[i]));
                }
                printAscending(l);
                input = cons.readLine("\n> ");

            } else if (input.trim().startsWith("descending")) {
                String[] list = input.trim().split(" ");
                List<Integer> l = new ArrayList<>();
                for (int i = 1; i < list.length; i++) {
                    l.add(Integer.parseInt(list[i]));
                }
                printDescending(l);
                input = cons.readLine("\n> ");

            } else {
                System.out.println("Invalid input");
                input = cons.readLine("> ");
            }
        }  
        System.out.println("Thank you for sorting using Binary Tree");    
    }
}