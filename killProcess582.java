import java.util.*;

public class killProcess582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        queue.offer(kill);
        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }

        while(!queue.isEmpty()) {
            int t = queue.poll();
            res.add(t);
            if (map.containsKey(t)) {
                for (int p : map.get(t)) {
                    queue.offer(p);
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        killProcess582 solution = new killProcess582();
        List<Integer> pid = new ArrayList<>(Arrays.asList(1, 3, 10, 15));
        List<Integer> ppid = new ArrayList<>(Arrays.asList(3, 0, 5, 3));
        int kill = 5;
        List<Integer> res = solution.killProcess(pid, ppid, kill);
    }
}
