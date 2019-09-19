import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class courseSchedule207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        int[] noPrerequisite = new int[numCourses];
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
            for (int prerequisiteCourse : adj[course]) {
                noPrerequisite[prerequisiteCourse]--;
                if (noPrerequisite[prerequisiteCourse] == 0) queue.offer(prerequisiteCourse);
            }
        }
        for (int i = 0; i < numCourses; ++i) {
            if (noPrerequisite[i] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int numcourse = 2;
        int[][] pre = {{1, 0}};
        System.out.print(canFinish(numcourse, pre));
    }
}
