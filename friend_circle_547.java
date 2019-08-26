public class friend_circle_547 {
    int findCircleNum(int[][] M) {
        int n = M.length, res = n;
        int[] root = new int[n];
        for (int i = 0; i < n; ++i) root[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (M[i][j] == 1) {
                    int fri_i = getRoot(i, root);
                    int fri_j = getRoot(j, root);
                    if (fri_i != fri_j) {
                        res--;
                        root[fri_j] = fri_i;
                    }
                }
            }
        }
        return res;
    }
    private int getRoot(int i, int root[]) {
        while (i != root[i]) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}
