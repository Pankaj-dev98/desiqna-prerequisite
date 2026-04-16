package trees;

import java.util.List;

public record TreeNode(int id, int val, List<TreeNode> children) {

    @Override
    public String toString() {
        return "TreeNode{" +
            "id=" + id +
            ", val=" + val +
            '}';
    }
}