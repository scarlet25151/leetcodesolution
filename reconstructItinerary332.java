import java.util.*;

public class reconstructItinerary332 {
    public List<String> findItinerary_dfs(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> ticketMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!ticketMap.containsKey(from))
                ticketMap.put(from, new ArrayList<>());
            ticketMap.get(from).add(to);
        }
        for (List<String> targets : ticketMap.values()) {
            Collections.sort(targets);
        }
        dfs(ticketMap, "JFK", res);
        return res;
    }

    public void dfs(Map<String, List<String>> ticketMap, String from,
                    List<String> res) {
        res.add(from);
        while (ticketMap.containsKey(from) && !ticketMap.get(from).isEmpty()) {
            String to = ticketMap.get(from).get(0);
            ticketMap.get(from).remove(to);
            dfs(ticketMap, to, res);
//            ticketMap.get(from).add(0, to);
        }
    }

    public List<String> findItinerary_bfs(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> ticketMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!ticketMap.containsKey(from))
                ticketMap.put(from, new ArrayList<>());
            ticketMap.get(from).add(to);
        }
        for (List<String> targets : ticketMap.values()) {
            Collections.sort(targets);
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String from = stack.peek();
            if (ticketMap.containsKey(from)) {
                if (ticketMap.get(from).isEmpty()) {
                    res.add(from);
                    stack.pop();
                } else {
                    String to = ticketMap.get(from).get(0);
                    stack.push(to);
                    ticketMap.get(from).remove(to);
                }
            }
        }
        return res;
    }
    Map<String, Queue<String>> graph = new HashMap<>();
    List<String> ans = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket :
                tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(Comparator.naturalOrder()));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");
        return ans;
    }

    private void dfs(String departure) {
        Queue<String> destinations = graph.get(departure);
        while (destinations != null && !destinations.isEmpty())
            dfs(destinations.poll());
        ans.add(0, departure);
    }

    public static void main(String[] args) {
        reconstructItinerary332 solution = new reconstructItinerary332();
        List<List<String>> tickets = new ArrayList<List<String>>() {{
            add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
            add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
            add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
            add(new ArrayList<>(Arrays.asList("LHR", "SFO")));
        }};
        List<String> out = solution.findItinerary_bfs(tickets);
        for (String s : out)
            System.out.println(s);
    }
}
