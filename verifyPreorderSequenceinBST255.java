public class verifyPreorderSequenceinBST255 {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int num : preorder) {
            if (num < low) return false;
            while(i >= 0 && num > preorder[i])
                low = preorder[i--];
            preorder[++i] = num;
        }
        return true;
    }
}
