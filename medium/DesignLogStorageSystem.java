
import java.util.*;

public class DesignLogStorageSystem {

    private TreeMap<String, List<Integer>> logs;

    public DesignLogStorageSystem() {
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        logs.putIfAbsent(timestamp, new ArrayList<>());
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(
            String start,
            String end,
            String granularity) {

        int length;

        switch (granularity) {
            case "Year":
                length = 4;
                break;
            case "Month":
                length = 7;
                break;
            case "Day":
                length = 10;
                break;
            case "Hour":
                length = 13;
                break;
            case "Minute":
                length = 16;
                break;
            default:
                length = 19;
        }

        String startTime = start.substring(0, length);
        String endTime = end.substring(0, length);

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry
                : logs.entrySet()) {

            String time = entry.getKey().substring(0, length);

            if (time.compareTo(startTime) >= 0
                    && time.compareTo(endTime) <= 0) {
                result.addAll(entry.getValue());
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        DesignLogStorageSystem system =
                new DesignLogStorageSystem();

        system.put(1, "2017:01:01:23:59:59");
        system.put(2, "2017:01:02:00:00:00");
        system.put(3, "2017:02:01:12:00:00");
        system.put(4, "2018:01:01:00:00:00");

        System.out.println(system.retrieve(
                "2017:01:01:00:00:00",
                "2017:12:31:23:59:59",
                "Year"
        ));

        System.out.println(system.retrieve(
                "2017:01:01:00:00:00",
                "2017:01:31:23:59:59",
                "Month"
        ));

        System.out.println(system.retrieve(
                "2017:01:01:00:00:00",
                "2017:01:02:23:59:59",
                "Day"
        ));
    }
}
