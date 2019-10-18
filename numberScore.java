public class numberScore {
    public static void main(String[] args) {
        int res = 0;

    }
    static int compute_number_score(int number) {
        char[] strNum = String.valueOf(number).toCharArray();
        int res = 0;
        int curLen = 1;
        for (int i = 0; i < strNum.length; i++) {
            //role 1
            if (strNum[i] == '5') {
                res += 2;
            }
            //role 2
            if (i > 0 && strNum[i] == '3' && strNum[i - 1] == '3') {
                res += 4;
            }
            //role 3
            if (i > 0 && strNum[i] - strNum[i - 1] == 1) {
                curLen ++;
            } else {
                res += curLen * curLen;
                curLen = 1;
            }
            //role 5
            if ((strNum[i] - '0') % 2 == 1) {
                res += 1;
            }
        }
        //role 3
        res += curLen * curLen;
        //role 4
        if (res % 5 == 0) {
            res += 6;
        }
        return res;
    }

    public int rules0(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == '5') {
                sum += 2;
            }
        }
        return sum;
    }
    public int rules1(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == '3' && nums[i - 1] == '3') {
                sum += 4;
            }
        }
        return sum;
    }
    public int rules2(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int sum = 0;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                curLen ++;
            } else {
                sum += curLen * curLen;
                curLen = 1;
            }
        }
        sum += curLen * curLen;
        return sum;
    }
    public int rules3(int num) {
        if (num % 5 == 0) {
            return 6;
        }
        return 0;
    }
    public int rules4(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int sum = 0;
        for (int i =0; i < nums.length; i++) {
            int tmp = nums[i] - '0';
            if (tmp % 2 != 0) {
                sum += 1;
            }
        }
        return sum;
    }
}
