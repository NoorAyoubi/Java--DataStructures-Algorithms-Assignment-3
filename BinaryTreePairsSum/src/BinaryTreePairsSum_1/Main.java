package BinaryTreePairsSum_1;

public class Main {
    public static void main(String[] args) {
        IntBinaryTree tree = new IntBinaryTree();
        
        // Insert values into the tree
        tree.insert(10);
        tree.insert(12);
        tree.insert(8);
        tree.insert(6);
        tree.insert(14);
        tree.insert(20);
        tree.insert(4);
        
        // Test pairs with sum 22
        int target1 = 22;
        System.out.println("Number of pairs with sum " + target1 + ": " + tree.countPairsWithSum(target1));
        
        // Test pairs with sum 16
        int target2 = 16;
        System.out.println("Number of pairs with sum " + target2 + ": " + tree.countPairsWithSum(target2));
        
        // Test pairs with sum 30
        int target3 = 30;
        System.out.println("Number of pairs with sum " + target3 + ": " + tree.countPairsWithSum(target3));
    }
}
