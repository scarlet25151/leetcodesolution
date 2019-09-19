public class rangeSumQuery307 {
    class NumArray {
        private int[] tree;
        private int n;
        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[2 * n];
            buildTree(nums);
        }

        public void update(int i, int val) {
            tree[i += n] = val;
            while (i > 0) {
                tree[i / 2] = tree[i] + tree[i ^ 1];
                i /= 2;
            }
        }

        public int sumRange(int i, int j) {
            int sum = 0;

            for (i += n, j += n; i <= j; i /= 2, j /= 2) {
                if ((i & 1) == 1) sum += tree[i++];
                if ((j & 1) == 0) sum += tree[j--];
            }
            return sum;
        }

        private void buildTree(int[] nums) {
            for (int i = n; i < n * 2; i++) {
                tree[i] = nums[i - n];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }
    }
}
