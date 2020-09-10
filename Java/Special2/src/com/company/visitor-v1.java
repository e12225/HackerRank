class SumInLeavesVisitor extends TreeVis {
    int result = 0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long val = 1;
    final long mod = 1000000007l;
    public int getResult() {
        return (int)(val % mod);
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            val = (val * (node.getValue() % mod)) % mod;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            val = (val * (leaf.getValue() % mod)) % mod;
        }
    }
}

class FancyVisitor extends TreeVis {
    int sum = 0;
    int othersum = 0;
    public int getResult() {
        return Math.abs(sum - othersum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth()%2 == 0) sum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) othersum += leaf.getValue();
    }
}

class Solution {

    static HashMap<Integer, List<Integer>> links;
    static Tree[] nodes;
    static int[] nodeVals;
    static Color[] nodeColours;
    public static Tree solve() {
        links = new HashMap<>();
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scanner = new Scanner(System.in);
        int numNodes = Integer.parseInt(scanner.nextLine());
        nodes = new Tree[numNodes];

        nodeVals = new int[numNodes];
        int index = 0;
        for(String s : scanner.nextLine().split(" ")) {
            links.put(index, new ArrayList<Integer>());
            nodeVals[index++] = Integer.parseInt(s);
        }

        nodeColours = new Color[numNodes];
        index = 0;
        for(String s : scanner.nextLine().split(" ")) {
            nodeColours[index++] = "0".equals(s) ? Color.RED : Color.GREEN;
        }


        try {
            for (String line = scanner.nextLine(); true; line = scanner.nextLine()) {
                String[] bits = line.split(" ");
                Integer parent = Integer.parseInt(bits[0]) - 1;
                Integer child = Integer.parseInt(bits[1]) - 1;
                links.get(parent).add(child);
                links.get(child).add(parent);
            }
        } catch (NoSuchElementException ex) {
            // do nothing
        }

        if (links.get(0).size() < 1) {
            nodes[0] = new TreeLeaf(nodeVals[0], nodeColours[0], 0);
        } else {
            nodes[0] = new TreeNode(nodeVals[0], nodeColours[0], 0);
            follow(0, 0, -1);
        }

        return nodes[0];
    }

    public static void follow(int node, int depth, int ignore) {
        for (Integer next : links.get(node)) {
            if (next == ignore) continue;
            int d = depth+1;
            if (links.get(next).size() < 2) {
                nodes[next] = new TreeLeaf(nodeVals[next], nodeColours[next], d);
                ((TreeNode)nodes[node]).addChild(nodes[next]);
            } else {
                nodes[next] = new TreeNode(nodeVals[next], nodeColours[next], d);
                ((TreeNode)nodes[node]).addChild(nodes[next]);
                follow(next, d, node);
            }
        }
    }

