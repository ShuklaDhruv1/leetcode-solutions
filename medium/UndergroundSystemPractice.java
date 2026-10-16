
import java.util.HashMap;
import java.util.Map;

public class UndergroundSystemPractice {

    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class RouteStats {
        int totalTime;
        int trips;

        RouteStats(int totalTime, int trips) {
            this.totalTime = totalTime;
            this.trips = trips;
        }
    }

    private Map<Integer, CheckIn> checkIns;
    private Map<String, RouteStats> routes;

    public UndergroundSystemPractice() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn entry = checkIns.remove(id);

        String route = entry.station + "->" + stationName;
        int travelTime = t - entry.time;

        if (!routes.containsKey(route)) {
            routes.put(route, new RouteStats(travelTime, 1));
        } else {
            RouteStats stats = routes.get(route);
            stats.totalTime += travelTime;
            stats.trips++;
        }
    }

    public double getAverageTime(String startStation,
                                 String endStation) {
        String route = startStation + "->" + endStation;
        RouteStats stats = routes.get(route);

        return (double) stats.totalTime / stats.trips;
    }

    public static void main(String[] args) {
        UndergroundSystemPractice system =
                new UndergroundSystemPractice();

        system.checkIn(1, "A", 3);
        system.checkOut(1, "B", 13);

        system.checkIn(2, "A", 10);
        system.checkOut(2, "B", 20);

        System.out.println(
                system.getAverageTime("A", "B"));

        system.checkIn(3, "A", 25);
        system.checkOut(3, "B", 40);

        System.out.println(
                system.getAverageTime("A", "B"));
    }
}
