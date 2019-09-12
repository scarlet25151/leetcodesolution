public class Integer2EnglishWord273 {

    public static String numberToWords(int nums) {
        String[] vocabAboveHundred = {"Thousand", "Million", "Billion"};
        String res = convertHundred(nums % 1000);
        for (int i = 0; i < 3; ++i) {
            nums /= 1000;
            res = nums % 1000 > 0 ? convertHundred(nums % 1000) + " "
                    + vocabAboveHundred[i] + " " + res : res;
        }
        if (res.isEmpty()) return "Zero";
        StringBuilder resNum = new StringBuilder(res);
        while (resNum.charAt(resNum.length() - 1) == ' ')
            resNum.deleteCharAt(resNum.length() - 1);
        res = resNum.toString();
        return res;
    }

    private static String convertHundred(int num) {
        String[] vocabUnderTwenty = {"", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"};
        String[] vocabUnderHundred = {"","", "Twenty", "Thirty", "Forty", "Fifty"
                , "Sixty", "Seventy", "Eighty", "Ninety"};
        String res;
        int hundredDigit = num / 100, tenDigit = num % 100, digit = num % 10;
        res = tenDigit < 20 ? vocabUnderTwenty[tenDigit] : vocabUnderHundred[tenDigit / 10] +
                (digit > 0 ? " " + vocabUnderTwenty[digit] : "");
        if (hundredDigit > 0) res = vocabUnderTwenty[hundredDigit] + " Hundred"
                + (tenDigit > 0 ? " " + res : "");
        return res;
    }
    public static void main(String[] args) {
        int testInput = 123;
        System.out.println(numberToWords(testInput));
    }
}
