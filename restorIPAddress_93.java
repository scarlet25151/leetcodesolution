import java.util.ArrayList;
import java.util.List;

public class restorIPAddress_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtracking(s, 0, "", res);
        return res;
    }
    private void backtracking(String s, int sectors,
                             String out, List<String> res) {
        if (sectors == 4) {
            res.add(out);
            return;
        }
        for (int ipLen = 1; ipLen < 4; ++ipLen) {
            if (s.length() < ipLen) break;
            int ipVal = Integer.parseInt(s.substring(0, ipLen));
            if (ipVal > 255 || ipLen != String.valueOf(ipVal).length())
                continue;
            backtracking(s.substring(ipLen), sectors + 1,
                    out + s.substring(0, ipLen) + (sectors == 3 ? "" : "."), res);

        }
    }
}
