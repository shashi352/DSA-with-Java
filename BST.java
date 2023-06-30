import java.lang.module.FindException;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.lang.model.util.ElementScanner14;

public class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //Left subtree
            root.left = insert(root.left, val);
        }else{
            //Right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //voile
            //Case 1- leaf Node
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2 = Single Child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //Case 3 - both children // Is = Inorder Successor
            Node Is = findinOrderSuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);
        }
        return root;
    }

    public static Node findinOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            prinPath(path);
        }
        
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if( min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, max) && isValidBST(root.right, min, max);
    }

    public static void prinPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) +  " " );
        }
        System.out.println("NULL");
    }

    public static Node createMirror(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = createMirror(root.left); // Left Pointer
        Node rightMirror = createMirror(root.right); // Right Pointer

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void main(String[] args) {
        // int values[] = {5, 1, 3, 4, 2, 7};
        // Node root = null;
        // for(int i =0; i < values.length; i++){
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();

        //Search in BST
        // if(search(root, 1)){
        //     System.out.println("found");
        // }else{
        //     System.out.println("Not found");
        // }

        // root = delete(root, 1);
        // System.out.println();

        // inorder(root);

        // int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // int values[] = {1, 1, 1};
        // Node root = null;
        // for(int i =0; i < values.length; i++){
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();

        // printInRange(root, 5, 12);

        //printRoot2Leaf(root, new ArrayList<>());

        // if(isValidBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("Not Valid");
        // }

       
        //Mirror BST
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        preorder(root);
        System.out.println();
        root = createMirror(root);
        preorder(root);

    }
}