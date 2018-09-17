package GeekUniversity.Java.Lesson6HW;

import java.util.Random;

public class Tree {
    private class TreeNode {

        private Integer c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int c) {
            this.c = c;
        }
    }

    TreeNode root;

    public Integer find(int number) {
        TreeNode current = root;
        while (current.c != number) {
            if (number < current.c)
                current = current.left;
            else
                current = current.right;

            if (current == null)
                return null;
        }
        return current.c;
    }

    public void insert(int c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode previous;
            while (true) {
                previous = current;
                if (c < current.c) {
                    current = current.left;
                    if (current == null) {
                        previous.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        previous.right = node;
                        return;
                    }
                }
            }
        }
    }

    public void displayTree() {
        inOrderTravers(root);
    }

    private void inOrderTravers(TreeNode current) {
        if (current != null) {
            inOrderTravers(current.left);
            System.out.println(current);
            inOrderTravers(current.right);
        }
    }

    public boolean delete(int number) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c != number) {
            parent = current;
            if (number < current.c) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        //if node is a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // if one successor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        }
        else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if both successors exist
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;

            successor.left = current.left;
            successor.right = current.right;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node.right;
        TreeNode s = node;
        TreeNode parent = node;
        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
        }
        return s;
    }

    public int randomNumber (Random random) {
        int randomnumber = random.nextInt(200) - 100;
        return randomnumber;
    }

    public float balance () {
        int sumleftbranch = calcTreeDepth(root.right);
        int sumrightbranch = calcTreeDepth(root.left);
        float sum = (sumleftbranch + sumrightbranch);
        float abs = Math.abs(sumleftbranch - sumrightbranch);
        float Balanced = abs / sum * 100 + 1;
        return Balanced;
    }

    public int calcTreeDepth (TreeNode node){
        int leftbranch = 0;
        int rightbranch = 0;

        if (node == null) return 0;

        if (node.left != null) {
            leftbranch = calcTreeDepth(node.left);
        }
        if (node.right != null) {
            rightbranch = calcTreeDepth(node.right);
        }
        return  leftOrRight(leftbranch,rightbranch);
    }

    public int leftOrRight (int left, int right) {
        if (left > right) return left + 1;
        return right + 1;
    }
}