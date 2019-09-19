public class swapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while (i < n && j < n) {
            while (i + 1 < n && start.charAt(i) == 'X'){i++;}
            while (j + 1 < n && end.charAt(j) == 'X') {j++;}
            if (start.charAt(i) != end.charAt(j)) return false;
            if ((start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j))
                return false;
            i++; j++;

        }
        return true;
    }
    public static void main(String[] args) {
        String start = "X", end = "L";
        swapAdjacentInLRString instance = new swapAdjacentInLRString();
        System.out.print(instance.canTransform(start, end));
    }
}
