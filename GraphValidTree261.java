public class GraphValidTree261 {
    public boolean validTree(int n, int[][] edge) {
        if (n < 0) {
            return false;
        } else if (n <= 1) {
            return true;
        }
        if (edge.length == 0) {
            return false;
        }
        int numEdge = n - 1;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] e : edge) {
            int u = getRoot(root, e[0]);
            int v = getRoot(root, e[1]);
            if (u == v) {
                return false;
            }
            numEdge--;
            root[v] = u;
        }
        return numEdge == 0;
    }
    private int getRoot(int[] root, int i) {
        while (i != root[i]) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}
