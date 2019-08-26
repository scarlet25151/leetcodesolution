public class connected_component_in_undirected_graph_323 {
    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0) return 0;
        int res = n;
        int[] root = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
        for (int i = 0; i < edges.length; ++i) {
            int x = getRoot(edges[i][0], root), y = getRoot(edges[i][1], root);
            if (x != y) {
                res--;
                root[y] = x;
            }
        }
        return res;
    }
    private int getRoot(int i, int[] root) {
        while (i != root[i]) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}
