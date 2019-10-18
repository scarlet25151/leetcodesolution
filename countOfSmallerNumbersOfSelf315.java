import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class countOfSmallerNumbersOfSelf315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = temp.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (temp.get(mid) >= nums[i]) right = mid;
                else left = mid + 1;
            }
            res[i] = right;
            temp.add(right, nums[i]);
        }
        List<Integer> resList = new ArrayList<>();
        for (int num : res) {
            resList.add(num);
        }
        return resList;
    }
    private class Node {
        int val, smaller;
        Node left, right;
        Node(int v, int s) {
            val = v;
            smaller = s;
        }
    }
    private int insert (Node root, int val) {
        if (root == null) {
            root = new Node(val, 0);
            return 0;
        }
        if (root.val > val) {
            root.smaller++;
            return insert(root.left, val);
        }
        return insert(root.right, val) + root.smaller + root.val < val ? 1 : 0;
    }
    public List<Integer> countSmaller_BST(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(i, insert(root, nums[i]));
        }
        return res;
    }
}
