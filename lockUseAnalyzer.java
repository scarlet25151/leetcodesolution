import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class lockUseAnalyzer {
    public static int checkLockSequence(List<String> events) {
        if (events.isEmpty()) return 0;
        HashSet<String> lockSet = new HashSet<>();
        Stack<String> lockLayer = new Stack<>();
        for (int i = 0; i < events.size(); i++) {
            String[] order = events.get(i).split(" ");
            String state = order[0];
            String id = order[1];
            if (state.equals("ACQUIRE")) {
                if (lockSet.contains(id)) {
                    return i + 1;
                }
                lockSet.add(id);
                lockLayer.push(id);
            } else if (state.equals("RELEASE")) {
                if (!lockLayer.isEmpty() && lockLayer.peek().equals(id)) {
                    lockSet.remove(lockLayer.pop());
                } else {
                    return i + 1;
                }
            }
        }
        return lockLayer.isEmpty() ? 0 : events.size() + 1;
    }
}
