import java.util.*;

public class sortItemsbyGroupsRespectingDependencies1203 {
    Map<Integer, HashSet<Integer>> group2item = new HashMap<>();
    Map<Integer, Integer> groupInNum = new HashMap<>();
    Map<Integer, HashSet<Integer>> groupDir = new HashMap<>();
    Map<Integer, Integer> itemInNum = new HashMap<>();
    Map<Integer, HashSet<Integer>> itemDir = new HashMap<>();

    public int[] sortItems(int n, int m, int[] group,
                           List<List<Integer>> beforeItems) {
        int minGroup = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1)
                group[i] = minGroup++;
            if (!group2item.containsKey(group[i]))
                group2item.put(group[i], new HashSet<>());
            group2item.get(group[i]).add(i);
        }

        for (int to = 0; to < beforeItems.size(); to++) {
            int toGroup = group[to];
            for (int from : beforeItems.get(to)) {
                int fromGroup = group[from];

                if (fromGroup == toGroup) {
                    if (!itemDir.containsKey(from))
                        itemDir.put(from, new HashSet<>());
                    itemDir.get(from).add(to);
                    itemInNum.put(to, itemInNum.getOrDefault(to, 0) + 1);
                }
                else if (!groupDir.containsKey(fromGroup) || !groupDir.get(fromGroup).contains(toGroup)) {
                    if(!groupDir.containsKey(fromGroup))
                        groupDir.put(fromGroup, new HashSet<>());
                    groupDir.get(fromGroup).add(toGroup);
                    groupInNum.put(toGroup, groupInNum.getOrDefault(toGroup, 0) + 1);
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> groupAns = new ArrayList<>();
        for (int to = 0; to < minGroup; to++) {
            if (groupInNum.containsKey(to) && groupInNum.get(to) == 0) {
                queue.offer(to);
                groupAns.add(to);
            }
        }
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : groupDir.get(from)) {
                groupInNum.replace(to, groupInNum.get(to) - 1);
                if (groupInNum.get(to) == 0) {
                    queue.offer(to);
                    groupAns.add(to);
                }
            }
        }
        if (groupAns.size() != minGroup) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for (int id : groupAns) {
            Set<Integer> items = group2item.get(id);
            int num = 0;
            for (int to : items) {
                if (itemInNum.containsKey(to) && itemInNum.get(to) == 0) {
                    queue.offer(to);
                    res.add(to);
                    num++;
                }
            }

            while (!queue.isEmpty()) {
                int from = queue.poll();
                for (int to : itemDir.get(from)) {
                    itemInNum.replace(to, itemInNum.get(to) - 1);
                    if (itemInNum.get(to) == 0) {
                        queue.offer(to);
                        res.add(to);
                        num++;
                    }
                }
            }

            if (num != items.size())
                return null;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int n = 8, m = 2;
        int[] group = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<List<Integer>>() {{
            add(new ArrayList<>());
            add(Arrays.asList(6));
            add(Arrays.asList(5));
            add(Arrays.asList(3, 6));
            add(Arrays.asList());
            add(Arrays.asList());
            add(Arrays.asList());
        }};
        sortItemsbyGroupsRespectingDependencies1203 sol = new sortItemsbyGroupsRespectingDependencies1203();
        int[] res = sol.sortItems(n, m, group, beforeItems);

    }
}
