class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            // create parent node if not exists
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode p = map.get(parent);
            TreeNode c = map.get(child);

            if (isLeft == 1) {
                p.left = c;
            } else {
                p.right = c;
            }

            children.add(child);
        }

        // find root (node not in children set)
        for (int node : map.keySet()) {
            if (!children.contains(node)) {
                return map.get(node);
            }
        }

        return null;
    }
}