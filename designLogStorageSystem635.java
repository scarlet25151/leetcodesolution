import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class designLogStorageSystem635 {
    static class LogSystem {
        private Map<String[], List<Integer>> map;
        public LogSystem() {
             map = new HashMap<>();
        }

        public void put(int id, String timestamp) {
            String[] times = timestamp.split(":");
            if (!map.containsKey(times)) {
                map.put(times, new ArrayList<>());
            }
            map.get(times).add(id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            List<String> gras = new ArrayList<>(Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second"));
            int idx = gras.indexOf(gra);
            List<Integer> res = new ArrayList<>();
            String[] queryStart = s.split(":");
            String[] queryEnd = s.split(":");
            for (Map.Entry<String[], List<Integer>> entry : map.entrySet()) {
                String[] query = entry.getKey();
                if (Integer.parseInt(query[idx]) >= Integer.parseInt(queryStart[idx])
                        && Integer.parseInt(query[idx]) >= Integer.parseInt(queryEnd[idx])) {
                    res.addAll(entry.getValue());
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1,"2017:01:01:23:59:59");
        logSystem.put(2,"2017:01:01:22:59:59");
        logSystem.put(3,"2016:01:01:00:00:00");
        logSystem.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        logSystem.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");

    }
}
