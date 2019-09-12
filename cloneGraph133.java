import java.util.*;

public class cloneGraph133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {}
        public  Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    public Node cloneGraph_dfs(Node node) {
        Map<Node, Node> nodeMap = new HashMap<>();
        return dfs(node, nodeMap);
    }
    private Node dfs(Node node, Map<Node, Node> nodeMap) {
        if (node == null) return null;
        if (nodeMap.containsKey(node))
            return nodeMap.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, nodeMap));
        }
        return clone;
    }
    public Node cloneGraph_bfs(Node node) {
        if (node == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Node clone = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, clone);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node neighbor : currentNode.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor,
                            new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                nodeMap.get(currentNode).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return clone;
    }
}
