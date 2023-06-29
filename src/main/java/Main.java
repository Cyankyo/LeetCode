import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int[] arrays = new int[n];
            for (int i = 0; i < n; i++) {
                arrays[i] = s.nextInt();
            }
            TreeNode t = buildTree(arrays);

            if (t == null) {
                System.out.println();
                continue;
            }
            ArrayList<Integer> list = postPrint(t);
//        System.out.println(list);
            StringBuilder ans = new StringBuilder();
            for (Integer integer : list) {
                ans.append(integer).append(" ");
            }
            System.out.println(ans.substring(0, ans.length() - 1));
            System.out.println(cengxuPrint(t));
            System.out.println(prePrint(t));
            System.out.println(midPrint(t));
            System.out.println(rightView(t));

        }
    }

    //深度遍历 方法
    public static ArrayList<Integer> rightView(TreeNode root) {
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        Map<Integer, Integer> depthMap = new HashMap<>();
        nodeStack.push(root);
        depthStack.push(0);
        int maxDepth = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            maxDepth = Math.max(depth, maxDepth);
            if (!depthMap.containsKey(depth)) {
                depthMap.put(depth, node.value);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
        }
        ArrayList<Integer> view = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            view.add(depthMap.get(i));
        }
        return view;
    }

    public static ArrayList<Integer> postPrint(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(postPrint(root.left));
        ans.addAll(postPrint(root.right));
        ans.add(root.value);
        return ans;
    }

    public static ArrayList<Integer> prePrint(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.value);
        ans.addAll(prePrint(root.left));
        ans.addAll(prePrint(root.right));
        return ans;
    }


    public static ArrayList<Integer> midPrint(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();

        ans.addAll(midPrint(root.left));
        ans.add(root.value);
        ans.addAll(midPrint(root.right));
        return ans;
    }

    //层序遍历
    public static ArrayList<Integer> cengxuPrint(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> tQueue = new LinkedList<>();
        tQueue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!tQueue.isEmpty()) {
            TreeNode node = tQueue.poll();
            ans.add(node.value);
            if (node.left != null) {
                tQueue.add(node.left);
            }
            if (node.right != null) {
                tQueue.add(node.right);
            }
        }
        return ans;
    }

    public static TreeNode buildTree(int[] arrays) {

        if (arrays == null || arrays.length == 0 || arrays[0] == -1) {
            return null;
        }
        int length = arrays.length;
        TreeNode root = new TreeNode(arrays[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (i < length) {
            i++;
            if (i >= length) {
                return root;
            }
            TreeNode current = queue.poll();
            if (arrays[i] != -1) {
                current.left = new TreeNode(arrays[i]);
                queue.offer(current.left);
            }
            i++;
            if (i >= length) {
                return root;
            }
            if (arrays[i] != -1) {
                current.right = new TreeNode(arrays[i]);
                queue.offer(current.right);
            }
        }
        return root;
    }

    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + (left == null ? "" : left.toString()) + value + (right == null ? "" : right.toString()) + ")";
        }
    }
}
