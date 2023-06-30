import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;

public class BT{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // static class BinaryTree{
    //     static int idx = -1;

    //     public static Node  buildTree(int nodes[]){
    //         idx++;
    //         if(nodes[idx] == -1){
    //             return null;
    //         }

    //         Node newNode = new Node(nodes[idx]);
    //         newNode.left = buildTree(nodes);
    //         newNode.right = buildTree(nodes);

    //         return newNode;
    //     }

    //     public static void preOrder(Node root){
    //         if(root == null){
    //             return;
    //         }
    //         System.out.println(root.data + " ");
    //         preOrder(root.left);
    //         preOrder(root.right);
    //     }

    //     public static void inOrder(Node root){
    //         if(root == null){
    //             return;
    //         }
            
    //         inOrder(root.left);
    //         System.out.println(root.data + " ");
    //         inOrder(root.right);
    //     }

    //     public static void postOrder(Node root){
    //         if(root == null){
    //             return;
    //         }
            
    //         postOrder(root.left);
    //         postOrder(root.right);
    //         System.out.println(root.data + " ");
    //     }

    //     public static void levelOrder(Node root){
    //         if(root == null){
    //             return;
    //         }

    //         Queue<Node> q = new LinkedList<>();
    //         q.add(root);
    //         q.add(null);

    //         while(!q.isEmpty()){
    //             Node currNode = q.remove();
    //             if(currNode == null){
    //                 System.out.println();
    //                 if(q.isEmpty()){
    //                     break;
    //                 }else{
    //                     q.add(null);
    //                 }
    //             }else{
    //                 System.out.println();
    //                 if(currNode.left != null){
    //                     q.add(currNode.left);
    //                 }
    //                 if(currNode.left != null){
    //                     q.add(currNode.right);
    //                 }
    //             }
    //         }
    //     }
    // }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1 ;
    }

    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameter2(Node root){ //TC :- O(N^2)
        if(root == null){
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt  + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // static class Info{
    //     int diam;
    //     int ht;

    //     public Info(int diam, int ht){
    //         this.diam = diam;
    //         this.ht = ht;
    //     }
    // }

    // public static Info diameter(Node root){
    //     if(root == null){
    //         return new Info(0, 0);
    //     }

    //     Info lefInfo = diameter(root.left);
    //     Info righInfo = diameter(root.right);

    //     int diam = Math.max(Math.max(lefInfo.diam, righInfo.diam), lefInfo.ht + righInfo.ht + 1 );
    //     int ht = Math.max(lefInfo.ht, righInfo.ht) + 1;

    //     return new Info(diam, ht);
    // }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isIdentical(root.left, subRoot) || isIdentical(root.right, subRoot);
    }

    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){ //edge case
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    static class Info{
        Node node;
        int hd; // horizontal diameter

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        //Level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){ //first time my hd is occuring
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void kLevel(Node root, int Level, int k){
        if(root == null){
            return;
        }

        if(Level == k){
            System.out.println(root.data + " ");
            return;
        }

        kLevel(root.left, Level + 1, k);
        kLevel(root.right, Level + 1, k);
    }

    //Approch 1 to found common last Ancestor
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //Last Common ancestor
        int i = 0;
        for( ; i <  path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        //last equal node => i -1 th
        Node lca = path1.get(i - 1);
        return lca;
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    //Approch 2 to found common last Ancestor
    public static Node lca2(Node root, int n1, int n2){
        //Base Case
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //leftLca = val, rightLca = null
        if(leftLca == null){
            return rightLca;
        }

        if(rightLca == null){
            return leftLca;
        }

        return root;
    }

    //Minmum Distance between Node
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(root, n1);
        int dist2 = lcaDist(root, n2);

        return dist1 + dist2;
    }

    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist + 1;
        }else{
            return leftDist + 1;
        }
    }

    //Kth ancestor of node

    public static int kAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int maxi = Math.max(leftDist, rightDist);
        if(maxi + 1 == k){
            System.out.println(root.data);
        }
        return maxi + 1;
    }

    public static int transform(Node root){
        if(root == null){
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right); 

        int data = root.data;

        int newLeft = root.left == null ?  0 : root.left.data;

        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 5, -1, 2};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);

        // tree.inOrder(root);

        // tree.postOrder(root);

        // tree.levelOrder(root);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // height of tree
        // System.out.println(height(root));

        // number of Node in tree
        // System.out.println(count(root));

        //sum of Node
        // System.out.println(sum(root));

        //Diameter of Tree :- max path of tree
        //System.out.println(diameter(root).diam);

        //Height of tree
        //System.out.println(diameter(root).ht);

        //Subtree of another tree
        //intialising subtree
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        //Hashmap Basic
        //Create
        HashMap<String, Integer> map = new HashMap<>();

        //Add (put) :-
        map.put("china", 125);
        map.put("India", 100);
        map.put("US", 50);

        // Get :- get the value :- print the india value or population
        // System.out.println(map.get("India"));
        
        //topView(root);

        //Kith Level of a Tree
        //kLevel(root, 1, 3); 

        //Lowest common ancestor 
        //Approch 1
        //int n1 = 4, n2 = 5;
        //System.out.println(lca(root, n1, n2)); // print the addresh
        //System.out.println(lca(root, n1, n2).data);// print the data

        //Approch 2
        //System.out.println(lca(root, n1, n2).data);

        //Minmum Distance between nodes
        // int n1 = 4 , n2 = 6;
        // System.out.println(minDist(root, n1, n2));

        //Kith ancestor of Node
        int n = 5, k = 2;
        System.out.println(kAncestor(root, n, k));

        //Transform to sum Tree
        // transform(root);
        // preorder(root);
    }
}