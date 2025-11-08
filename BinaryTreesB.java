import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        
        public static void preorder(Node root){ // preorder Traversal
            if(root == null){
                return;
            }
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){ // inorder traversal
            if(root == null){
                return;
            }
            preorder(root.left);
            System.out.println(root.data);
            preorder(root.right);
        }
        public static void inorder(Node root){ // postorder traversal
            if(root == null){
                return;
            }
            preorder(root.left);
            preorder(root.right);
            System.out.println(root.data);
            
        }

        public static void levelOrder(Node root){ // levelorder traversal
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(isEmpty){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.println(currNode.data);
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);
        System.out.println(root.data);


    }
}


public class BinaryTreesB {  
    static class Node {
        int data;
        Node left,right;
        
        public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
        }
    }
    
    public static int height(Node root){ // height of a tree
        if(root == null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh, rh)+1;
    }

    public static int count(Node root){ //count of nodes of a tree
        if(root == null){
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc+rc+1;
    }

    public static int sumOfNodes(Node root){ // sum of nodes of a tree
        if(root == null){
            return 0;
        }
        int lc = sumOfNodes(root.left);
        int rc = sumOfNodes(root.right);
        return lc+rc+root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(sumOfNodes(root));
    }
}