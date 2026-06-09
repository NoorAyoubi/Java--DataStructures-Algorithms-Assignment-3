package BinaryTreePairsSum_1;

public class IntBinaryTree {
    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Counts the number of distinct node pairs that sum to the target value
     * @param target the target sum to find
     * @return number of valid pairs
     */
    public int countPairsWithSum(int target) {
        return countPairs(root, target);
    }

    /**
     * Recursively counts pairs starting from each node
     */
    private int countPairs(Node start, int target) {
        if (start == null) return 0;
        
        // Count pairs including the current node
        int count = searchComplement(root, start, target);
        
        // Count pairs in left and right subtrees
        count += countPairs(start.left, target);
        count += countPairs(start.right, target);
        
        return count;
    }

    /**
     * Searches for complement nodes that sum to target with start node
     */
    private int searchComplement(Node current, Node start, int target) {
        if (current == null) return 0;
        
        int complement = target - start.value;
        
        if (current.value == complement && current != start) {
            // Ensure we only count each pair once (a,b) not (b,a)
            if (complement > start.value) {
                return 1;
            }
            return 0;
        }
        
        // Use BST property to search efficiently
        if (complement < current.value) {
            return searchComplement(current.left, start, target);
        } else {
            return searchComplement(current.right, start, target);
        }
    }

    // Helper methods for tree construction
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        
        return node;
    }
}