package weeklyContest153;

public class distanceBetweenBusStop {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockwise = 0, counterclockwise = 0;
        int sum = 0;
        for (int d : distance) {
            sum += d;
        }
        int clockwiseStart = Math.min(start, destination);
        int clockwiseDestination = Math.max(start, destination);
        for (int i = clockwiseStart; i < clockwiseDestination; ++i) {
            clockwise += distance[i];
        }
        counterclockwise = sum - clockwise;
        return Math.min(clockwise, counterclockwise);
    }

}
