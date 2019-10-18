import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encodeAndDecodeStrings271 {
    public static class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder res = new StringBuilder("");
            for (String str : strs) {
                res.append(String.valueOf(str.length()));
                res.append("/");
                res.append(str);
            }
            return res.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            StringBuilder string = new StringBuilder(s);
            while (string.length() > 0) {
                int found = s.indexOf('/');
                int len = Integer.valueOf(s.substring(0, found + 1));
                s = s.substring(found + 1);
                res.add(s.substring(0, len + 1));
                s = s.substring(len + 1);
            }
            return res;
        }


    }
    public class Codec2{
        public String intToString(String s) {
            int x = s.length();
            char[] bytes = new char[4];
            for (int i = 3; i > - 1; i--) {
                bytes[3 - i] = (char) (x>> (i * 8) & 0xff);
            }
            return new String(bytes);
        }
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(intToString(str));
                sb.append(str);
            }
            return sb.toString();
        }
        public int stringToInt(String bytesStr) {
            int res = 0;
            for (char b : bytesStr.toCharArray()) {
                res = (res << 8) + (int)b;
            }
            return res;
        }
        public List<String> decode(String s) {
            int i = 0, n = s.length();
            List<String> output = new ArrayList<>();
            while (i < n) {
                int length = stringToInt(s.substring(i, i + 4));
                i += 4;
                output.add(s.substring(i, i + length));
                i += length;
            }
            return output;
        }
    }
    public static void main(String[] args) {
        Codec coder = new Codec();
        List<String> strs = Arrays.asList("Hello", "World");
        System.out.println(coder.encode(strs));
    }
}
