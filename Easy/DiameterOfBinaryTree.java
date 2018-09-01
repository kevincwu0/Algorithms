public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x }; 
}

class Solution {
    int answer = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        answer = 1;
        depth(root);
        return answer - 1;
    }
    
    public int depth(TreeNode node) { 
        if(node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        answer = Math.max(answer, left + right + 1);
        return Math.max(left, right) + 1;
    }
}