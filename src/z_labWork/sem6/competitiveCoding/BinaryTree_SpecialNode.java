package z_labWork.sem6.competitiveCoding;

public class BinaryTree_SpecialNode {

    public static void main(String[] args) {

        BinaryNode head = null;

        head = insert(head, 'L');
        head = insert(head, 'D');
        head = insert(head, 'S');
        head = insert(head, 'A');
        head = insert(head, 'G');
        head = insert(head, 'P');
        head = insert(head, 'W');
        head = insert(head, 'C');
        head = insert(head, 'E');
        head = insert(head, 'M');
        head = insert(head, 'Z');

        makeSpecial(head, 'G');
        makeSpecial(head, 'D');

        inOrder(head);


    }

    public static BinaryNode insert(BinaryNode head, char data){
        if (head == null) {
            head = new BinaryNode(data);
            return head;
        }

        if (data < head.data)
            head.left = insert(head.left, data);
        else
            head.right = insert(head.right, data);
        return head;
    }

    public static BinaryNode makeSpecial(BinaryNode head, char data){

        BinaryNode node = searchTree(head, data);

        if(node == null) return head;

        BinaryNode left = node.left;
        BinaryNode right = node.right;

        if(left != null && left.isSpecial) return head;
        if(right != null && right.isSpecial) return head;

        node.isSpecial = true;
        return head;
    }

    public static BinaryNode searchTree(BinaryNode root, char data) {

        if(root == null)
            return null;

        if(root.data == data)
            return root;

        if(data < root.data)
            return searchTree(root.left, data);
        else
            return searchTree(root.right, data);
    }

    private static void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println("Data:"+ node.data + ", isSpecial:"+node.isSpecial);
        inOrder(node.right);
    }
}

class BinaryNode{

    BinaryNode left;
    BinaryNode right;
    char data;
    boolean isSpecial = false;

    public BinaryNode(char data) {
        this.data = data;
    }

}
