import java.util.HashMap;
import java.util.Map;

public class readNCharactersGivenRead4II158 {
    abstract class Reader4 {
        public Reader4() {}
        public int read4(char[] buff) {
            return 0x00;
        }
    }
    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        private int readPos = 0, writePos = 0;
        private char[] buff = new char[4];

        public int read(char[] buf, int n) {
            for (int i = 0; i < n; ++i) {
                if (readPos == writePos) {
                    writePos = read4(buff);
                    readPos = 0;
                    if (writePos == 0) return i;
                }
                buf[i] = buff[readPos++];
            }
            return n;
        }
    }
}
