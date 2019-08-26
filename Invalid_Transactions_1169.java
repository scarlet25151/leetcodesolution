import javax.sound.midi.SysexMessage;
import java.util.*;

public class Invalid_Transactions_1169 {
    public class account {
        String name, amount, city;
        int time, index;
        account(String name, String time, String amount, String city, int index) {
            this.name = name;
            this.time = Integer.parseInt(time);
            this.amount = amount;
            this.index = index;
            this.city = city;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        account[] ac = new account[transactions.length];
        HashMap<String, account> map = new HashMap<>();
        boolean[] hasIndex = new boolean[transactions.length];
        for (int i = 0; i < transactions.length; ++i) {
            String[] s_t = transactions[i].split(",");
            if (Integer.parseInt(s_t[2]) > 1000) {
                res.add(transactions[i]);
                hasIndex[i] = true;
            }
            if (!map.containsKey(s_t[0])) {
                map.put(s_t[0], new account(s_t[0], s_t[1], s_t[2], s_t[3], i));
            } else {
                account ac_t = map.get(s_t[0]);
                if (Math.abs(ac_t.time - Integer.parseInt(s_t[1])) <= 60
                        && !ac_t.city.equals(s_t[3])) {
                    if (!hasIndex[i]) {
                        res.add(transactions[ac_t.index]);
                        res.add(transactions[i]);
                        hasIndex[ac_t.index] = true;
                        hasIndex[i] = true;
                    }
                }
                map.replace(s_t[0], new account(s_t[0], s_t[1], s_t[2], s_t[3], i));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
