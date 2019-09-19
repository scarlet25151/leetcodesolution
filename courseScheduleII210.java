import java.util.*;

public class courseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        int[] noPrerequisite = new int[numCourses];
        Arrays.fill(noPrerequisite, 0);
        for (int[] preRelation : prerequisites) {
            adj[preRelation[1]].add(preRelation[0]);
            noPrerequisite[preRelation[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (noPrerequisite[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res.add(course);
            for (int prerequisiteCourse : adj[course]) {
                noPrerequisite[prerequisiteCourse]--;
                if (noPrerequisite[prerequisiteCourse] == 0) queue.offer(prerequisiteCourse);
            }
        }
        if (res.size() != numCourses) res.clear();
        return res.stream().mapToInt(i->i).toArray();
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        int[] noPrerequisite = new int[numCourses];
        Arrays.fill(noPrerequisite, 0);


        return true;
    }
}
