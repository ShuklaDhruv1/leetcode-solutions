
import java.util.*;

public class DesignFileSharingSystem {

    private int m;
    private int nextUserId = 1;

    private Map<Integer, Set<Integer>> userChunks;
    private Map<Integer, Set<Integer>> chunkUsers;
    private PriorityQueue<Integer> availableIds;

    public DesignFileSharingSystem(int m) {
        this.m = m;
        userChunks = new HashMap<>();
        chunkUsers = new HashMap<>();
        availableIds = new PriorityQueue<>();

        for (int i = 1; i <= m; i++) {
            chunkUsers.put(i, new HashSet<>());
        }
    }

    public int join(List<Integer> ownedChunks) {
        int userId;

        if (!availableIds.isEmpty()) {
            userId = availableIds.poll();
        } else {
            userId = nextUserId++;
        }

        userChunks.put(userId, new HashSet<>(ownedChunks));

        for (int chunk : ownedChunks) {
            chunkUsers.get(chunk).add(userId);
        }

        return userId;
    }

    public List<Integer> request(int userId, int chunkId) {
        List<Integer> owners = new ArrayList<>(
            chunkUsers.get(chunkId)
        );

        Collections.sort(owners);

        if (!owners.isEmpty()) {
            userChunks.get(userId).add(chunkId);
            chunkUsers.get(chunkId).add(userId);
        }

        return owners;
    }

    public void leave(int userId) {
        Set<Integer> chunks = userChunks.remove(userId);

        if (chunks != null) {
            for (int chunk : chunks) {
                chunkUsers.get(chunk).remove(userId);
            }

            availableIds.offer(userId);
        }
    }

    public static void main(String[] args) {

        DesignFileSharingSystem system =
            new DesignFileSharingSystem(4);

        int user1 = system.join(
            Arrays.asList(1, 2)
        );

        int user2 = system.join(
            Arrays.asList(2, 3)
        );

        System.out.println("User 1 ID: " + user1);
        System.out.println("User 2 ID: " + user2);

        System.out.println(
            "Chunk 2 owners: " + system.request(user1, 2)
        );

        System.out.println(
            "Chunk 3 owners: " + system.request(user1, 3)
        );

        system.leave(user2);

        int user3 = system.join(
            Arrays.asList(4)
        );

        System.out.println("New user ID: " + user3);
    }
}
