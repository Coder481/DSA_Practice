package z_labWork.sem6.competitiveCoding;

public class Lab_4_Tree {
    public static void main(String[] args) {
        TreeImplementation tree = new TreeImplementation();

        /**
         *              50
         *         30        60
         *      25   35   55    65
         */
        tree.insert(50);
        tree.insert(30);
        tree.insert(60);
        tree.insert(25);
        tree.insert(35);
        tree.insert(55);
        tree.insert(65);

        System.out.print("Inorder: ");
        tree.traverseInorder(tree.root);

        System.out.println();
        System.out.print("Preorder: ");
        tree.traversePreorder(tree.root);

        System.out.println();
        System.out.print("Postorder: ");
        tree.traversePostorder(tree.root);

        System.out.println();
        System.out.print("Top View: ");
        tree.traverseTopView(tree.root);

    }
}

class TreeImplementation{

    TreeNode root;

    public void insert(int value){
        TreeNode newNode = new TreeNode(value);
        if (root == null){
            root = newNode;
        }
        else{
            insertRecursively(root, value);
        }
    }

    private TreeNode insertRecursively(TreeNode n, int value){
        if (n == null){
            return new TreeNode(value);
        }
        else if (value < n.value){
            n.left = insertRecursively(n.left, value);
        }
        else {
            n.right = insertRecursively(n.right, value);
        }
        return n;
    }

    /**
     * Three type of traversing:
     *      1. Inorder    :  Left-Node-Right (LNR)
     *      2. Preorder   :  Node-Left-Right (NLR)
     *      3. Postorder  :  Left-Right-Node (LRN)
     */
    void traverseInorder(TreeNode n){
        if (n != null){
            traverseInorder(n.left);
            System.out.print(n.value+", ");
            traverseInorder(n.right);
        }
    }
    void traversePreorder(TreeNode n){
        if (n != null){
            System.out.print(n.value+", ");
            traversePreorder(n.left);
            traversePreorder(n.right);
        }
    }
    void traversePostorder(TreeNode n){
        if (n != null){
            traversePostorder(n.left);
            traversePostorder(n.right);
            System.out.print(n.value+", ");
        }
    }

    void traverseTopView(TreeNode n){
        System.out.print(n.value+", ");
        traverseLeft(n.left);
        traverseRight(n.right);
    }

    private void traverseLeft(TreeNode n) {
        if(n != null){
            System.out.print(n.value+", ");
            traverseLeft(n.left);
        }
    }

    private void traverseRight(TreeNode n) {
        if(n != null){
            System.out.print(n.value+", ");
            traverseRight(n.right);
        }
    }

}


class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
