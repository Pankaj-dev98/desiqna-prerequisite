package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://docs.google.com/document/d/192QwM7j7jNWo5s6Nk1G_RRIIUXrbr3PhrMc0tdAf218/edit?tab=t.0
// VERSION 1
public class XorGlobalDepth {
    public static void main(String[] args) {
        // Sample test case
        TreeNode n7 = new TreeNode(7, 100, new ArrayList<>());
        TreeNode n8 = new TreeNode(8, 200, new ArrayList<>());
        TreeNode n9 = new TreeNode(9, 300, new ArrayList<>());
        TreeNode n10 = new TreeNode(10, 400, new ArrayList<>());
        TreeNode n11 = new TreeNode(11, 500, new ArrayList<>());

        TreeNode n2 = new TreeNode(2, 20, new ArrayList<>(List.of(n7, n8, n9)));

        TreeNode n3 = new TreeNode(3, 30, new ArrayList<>(List.of(n10)));

        TreeNode n4 = new TreeNode(4, 40, new ArrayList<>());

        TreeNode n5 = new TreeNode(5, 50, new ArrayList<>(List.of(n11)));

        TreeNode n6 = new TreeNode(6, 60, new ArrayList<>());

        TreeNode root = new TreeNode(1, 10, new ArrayList<>(List.of(n2, n3, n4, n5, n6)));

        // Verification Output
        System.out.println("Tree built successfully.");
        System.out.println("Root ID: " + root.id() + ", Value: " + root.val());
        System.out.println("Root has " + root.children().size() + " children.");

        /* * Structure Visualization:
         *      ID:1 (val:10)
         *    /    /    |    \    \
         * ID:2   ID:3  ID:4  ID:5  ID:6
         * /|\    |           |
         *7 8 9   10          11

         */

        System.out.println("----");
        XorGlobalDepth driver = new XorGlobalDepth();
        driver.xorWithGlobalDepth(root);
    }

    private HashMap<TreeNode, Long> dp;
    public void xorWithGlobalDepth(TreeNode root) {
        this.dp = new HashMap<>();
        recursive(root, 0);
        System.out.println(dp);
    }

    private long recursive(TreeNode current, int depth) {
        if (current == null) {
            return 0L;
        }

        if (current.children().isEmpty()) {
            dp.put(current, (long) (current.val() ^ depth));
            return dp.get(current);
        }

        // redundancy
        if (dp.containsKey(current)) {
            return dp.get(current);
        }
        //

        long result = 0L;
        for (TreeNode child : current.children()) {
            result += recursive(child, depth + 1);
        }

        dp.put(current, result + (current.val() ^ depth));
        return dp.get(current);
    }
}