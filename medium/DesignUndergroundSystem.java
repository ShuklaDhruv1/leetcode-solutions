import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

    static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class RouteInfo {
        int totalTime;
        int totalTrips;

        RouteInfo() {
            totalTime = 0;
            totalTrips = 0;
        }

        void addTrip(int time) {
            totalTime += time;
            totalTrips++;
        }

        double getAverage() {
            return (double) totalTime / totalTrips;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, RouteInfo> routes;

    public DesignUndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(
                id,
                new CheckInInfo(stationName, t)
        );
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);

        String route = info.station + "->" + stationName;
        int travelTime = t - info.time;

        routes.putIfAbsent(route, new RouteInfo());
        routes.get(route).addTrip(travelTime);
    }

    public double getAverageTime(
            String startStation,
            String endStation) {

        String route = startStation + "->" + endStation;

        return routes.get(route).getAverage();
    }

    public static void main(String[] args) {

        DesignUndergroundSystem system =
                new DesignUndergroundSystem();

        system.checkIn(1, "A", 3);
        system.checkIn(2, "A", 8);

        system.checkOut(1, "B", 15);
        system.checkOut(2, "B", 18);

        System.out.println(
                "Average A to B: " +
                system.getAverageTime("A", "B")
        );

        system.checkIn(3, "A", 20);
        system.checkOut(3, "B", 30);

        System.out.println(
                "Updated Average A to B: " +
                system.getAverageTime("A", "B")
        );
    }
}
