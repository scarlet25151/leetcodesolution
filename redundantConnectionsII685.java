import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class redundantConnectionsII685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] root = new int[n + 1], first = new int[2], second = new int[2];


        for (int[] edge : edges) {
            if (root[edge[1]] == 0)
                root[edge[1]] = edge[0];
            else {
                first[0] = root[edge[1]]; first[1] = edge[1];
                second = edge;
                edge[1] = 0;
            }
        }
        for (int i = 0; i <= n; i++) root[i] = i;

        for (int[] edge : edges) {
            if (root[edge[1]] == 0) continue;
            int x = getRoot(root, edge[0]), y = getRoot(root, edge[1]);
            if (x == y) return (first[0] == 0 && first[1] == 0) ? edge : first;
            root[x] = y;
        }
        return second;
    }
    private int getRoot(int root[], int i) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
    private int getRoot_recursive(int[] root, int i) {
        return i == root[i] ? i : getRoot_recursive(root, root[i]);
    }
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        redundantConnectionsII685 solution = new redundantConnectionsII685();
        int[] res = solution.findRedundantDirectedConnection(edges);
    }
}
