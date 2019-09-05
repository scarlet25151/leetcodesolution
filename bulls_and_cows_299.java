import java.util.Arrays;

public class bulls_and_cows_299 {
    public String getHint(String secret, String guess) {
        int[] record = new int[256];
        Arrays.fill(record, 0);
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) ++bulls;
            else {
                if (record[secret.charAt(i)]++ < 0) ++cows;
                if (record[guess.charAt(i)]-- > 0) ++cows;
            }
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }
}
