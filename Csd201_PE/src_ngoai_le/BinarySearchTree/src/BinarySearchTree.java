
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node search(int x) {
        return searchNode(root, x);
    }

    private Node searchNode(Node root, int x) {
        if (root == null || root.data == x) {
            return root;
        }

        if (x < root.data) {
            return searchNode(root.left, x);
        } else {
            return searchNode(root.right, x);
        }
    }

    public void insert(int x) {
        root = insertNode(root, x);
    }

    private Node insertNode(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }

        if (x < root.data) {
            root.left = insertNode(root.left, x);
        } else if (x > root.data) {
            root.right = insertNode(root.right, x);
        }

        return root;
    }

    public void breadth() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Breadth-first traversal: ");

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public void preorder(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.data + " ");
        preorder(p.left);
        preorder(p.right);
    }

    public void inorder(Node p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        System.out.print(p.data + " ");
        inorder(p.right);
    }

    public void postorder(Node p) {
        if (p == null) {
            return;
        }
        postorder(p.left);
        postorder(p.right);
        System.out.print(p.data + " ");
    }

    public int count() {
        return countNodes(root);
    }

    private int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;
    }

    public void dele(int x) {
        root = deleteNode(root, x);
    }

    private Node deleteNode(Node root, int x) {
        if (root == null) {
            return root;
        }

        if (x < root.data) {
            root.left = deleteNode(root.left, x);
        } else if (x > root.data) {
            root.right = deleteNode(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = findMin(root.right).data;
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    private Node findMin(Node root) {
        if (root.left == null) {
            return root;
        }

        return findMin(root.left);
    }

    public Node min() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public Node max() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public int sum() {
        return sumOfNodes(root);
    }

    private int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int sum = root.data;
        sum += sumOfNodes(root.left);
        sum += sumOfNodes(root.right);

        return sum;
    }

    public int avg() {
        int nodeCount = count();
        if (nodeCount == 0) {
            return 0;
        }

        int sum = sum();
        return sum / nodeCount;
    }

    public int height() {
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int costOfMostExpensivePath() {
        return costOfPath(root);
    }

    private int costOfPath(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCost = costOfPath(root.left);
        int rightCost = costOfPath(root.right);

        return root.data + Math.max(leftCost, rightCost);
    }

    public boolean isAVL() {
        return isAVLTree(root);
    }

    private boolean isAVLTree(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int balanceFactor = Math.abs(leftHeight - rightHeight);
        if (balanceFactor > 1) {
            return false;
        }
        
        return isAVLTree(root.left) && isAVLTree(root.right);
    }

}
